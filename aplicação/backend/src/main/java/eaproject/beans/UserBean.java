package eaproject.beans;

import eaproject.beans.locals.UserLocal;
import eaproject.dao.*;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.*;
import eaproject.output.*;
import eaproject.utilities.JwtTokenUtil;
import eaproject.utilities.Utilities;
import io.jsonwebtoken.Claims;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import static eaproject.constants.EAProjectConstants.ROLE_DEFAULT;

@Stateless(name = "UserEJB")
@Local(UserLocal.class)
@Component
public class UserBean implements UserLocal {

    // Password encoder for hashing and verifying passwords
    private final PasswordEncoder passwordEncoder;

    @Inject
    public UserBean(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    public void init() {
        System.out.println("UserBean initialized with PasswordEncoder: " + (passwordEncoder != null));
    }

    /**
     * Authenticates a user based on the provided input data.
     *
     * @param userInput the input data for user authentication
     * @return AuthenticationOutput containing the authentication result, token, and feedback messages
     * @throws UsernameNotFoundException if the user is not found
     */
    public AuthenticationOutput authenticateUser(AuthenticationInput userInput) throws UsernameNotFoundException {
        AuthenticationOutput output = new AuthenticationOutput();
        try {
            // Set query parameters
            String condition = "email = '" + userInput.getEmail() + "'";
            User user = UserDAO.loadUserByQuery(condition, null);

            if (user != null && user.getId() > 0 && user.getIsActive()) {
                if (passwordEncoder.matches(userInput.getPassword(), user.getPassword())) {
                    String token = JwtTokenUtil.createToken(user);
                    output.setToken(token);
                    output.addFeedbackMessage("Login successful", FeedbackSeverity.SUCCESS);
                } else {
                    throw new BadCredentialsException("Invalid email or password");
                }
            } else {
                throw new BadCredentialsException("User not found in our database");
            }
        } catch (BadCredentialsException e) {
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        return output;
    }

    /**
     * Registers a new user based on the provided input data.
     *
     * @param input the input data for registering a new user
     * @return UserRegisterOutput containing the registration result and feedback messages
     */
    public UserRegisterOutput registerNewUser(UserRegisterInput input) {
        UserRegisterOutput output = new UserRegisterOutput();
        try {
            // Validate input
            if (input.getName().isEmpty() || input.getEmail().isEmpty() || input.getPassword().isEmpty()) {
                output.addFeedbackMessage("Name, email, and password are required.", FeedbackSeverity.DANGER);
                output.setRegistrationSuccessful(false);
                return output;
            }

            // Convert object into an entity
            User user = Utilities.convertToDAO(input, User.class);

            // Hash the password using the injected PasswordEncoder
            String hashedPassword = passwordEncoder.encode(Objects.requireNonNull(user).getPassword());

            // Set the hashed password
            user.setPassword(hashedPassword);

            // Set user active
            user.setIsActive(true);

            // Set user registration date
            user.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));

            // Set query parameters
            String condition = "name = '" + ROLE_DEFAULT + "'";

            // Get base role
            Role role = RoleDAO.loadRoleByQuery(condition, null);

            // Set base role
            user.setRole(role);

            // Save user to database using DAO
            UserDAO.save(user);

            // If successful
            output.addFeedbackMessage("User registered successfully.", FeedbackSeverity.SUCCESS);
            output.setRegistrationSuccessful(true);
        } catch (PersistentException e) {
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        return output;
    }

    /**
     * Method to retrieve basic user information.
     *
     * @param userInfoInput The input object containing the user ID.
     * @return BasicUserInfoOutput The output object containing user information.
     * @throws UsernameNotFoundException if the user cannot be found.
     */
    public BasicUserInfoOutput basicUserInfo(BasicUserInfoInput userInfoInput, HttpServletRequest request) throws UsernameNotFoundException {
        BasicUserInfoOutput output = new BasicUserInfoOutput();
        try {
            // Extract the JWT token from the request
            String token = jwtTokenUtil.resolveToken(request);

            // Decode the JWT token to extract claims
            Claims claims = jwtTokenUtil.decodeToken(token);

            // Get the user ID from the claims
            int tokenUserId = claims.get("idUser", Integer.class);

            // Check if the user ID from the token matches the user ID from the input
            if (tokenUserId != userInfoInput.getId()) {
                output.addFeedbackMessage("You are not authorized to access this user's information.", FeedbackSeverity.DANGER);
            }

            // Load the user from the database using the provided user ID
            User user = UserDAO.loadUserByORMID(userInfoInput.getId());

            // Check if the user exists and is active
            if (user != null && user.getId() > 0 && user.getIsActive()) {
                // Convert entity into an object
                output = Utilities.convertToDTO(user, BasicUserInfoOutput.class);
            } else {
                output.addFeedbackMessage("User not found in our database.", FeedbackSeverity.DANGER);
            }
        } catch (BadCredentialsException e) {
            // Add feedback message for bad credentials
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            // Add feedback message for database access error
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            // Add feedback message for unexpected errors
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        return output;
    }

    /**
     * Updates user information.
     *
     * @param userInfoInput The input object containing user information to be updated.
     * @param request The HTTP request containing the JWT token.
     * @return An output object containing the result of the update operation.
     * @throws UsernameNotFoundException If the user is not found.
     */
    public UpdateUserInfoOutput updateUserInfo(UpdateUserInfoInput userInfoInput, HttpServletRequest request) {
        // Create a new output object to store the result of the update operation
        UpdateUserInfoOutput output = new UpdateUserInfoOutput();
        try {
            // Extract the JWT token from the HTTP request
            String token = jwtTokenUtil.resolveToken(request);

            // Decode the JWT token to extract the claims
            Claims claims = jwtTokenUtil.decodeToken(token);

            // Get the user ID from the claims in the token
            int tokenUserId = claims.get("idUser", Integer.class);

            // Check if the user ID from the token matches the user ID from the input
            if (tokenUserId != userInfoInput.getId()) {
                output.addFeedbackMessage("You are not authorized to update this user's information.", FeedbackSeverity.DANGER);
            }

            // Load the user from the database using the provided user ID
            User user = UserDAO.loadUserByORMID(userInfoInput.getId());

            // Check if the user exists and is active
            if (user != null && user.getId() > 0 && user.getIsActive()) {
                // Convert object into an entity
                User userToUpdate = Utilities.convertToDAO(userInfoInput, User.class);

                // Set all items to update
                user.setName(userToUpdate.getName());
                user.setEmail(userToUpdate.getEmail());
                user.setGender(userToUpdate.getGender());
                user.setAge(userToUpdate.getAge());
                user.setHeight(userToUpdate.getHeight());
                user.setWeight(userToUpdate.getWeight());

                // Save the User entity to the database using the DAO
                UserDAO.save(user);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage("User updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage("User not found in our database.", FeedbackSeverity.DANGER);
            }
        } catch (BadCredentialsException e) {
            // If a BadCredentialsException is caught, add a danger feedback message with the exception message
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            // If a PersistentException is caught, add a danger feedback message indicating a database access error
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            // If any other exception is caught, add a danger feedback message indicating an unexpected error
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        // Return the output object with the result of the update operation
        return output;
    }

    /**
     * Updates the role of a user based on the provided input.
     *
     * @param userRoleInput An object containing the user ID and the new role ID.
     * @return An output object containing the result of the update operation.
     */
    public UpdateUserRoleOutput updateUserRole(UpdateUserRoleInput userRoleInput) {
        // Create a new output object to store the result of the update operation
        UpdateUserRoleOutput output = new UpdateUserRoleOutput();

        try {
            // Load the user from the database using the provided user ID
            User user = UserDAO.loadUserByORMID(userRoleInput.getUserId());

            // Check if the user exists and is active
            if (user != null && user.getId() > 0 && user.getIsActive()) {
                // Load the role from the database using the provided role ID
                Role role = RoleDAO.getRoleByORMID(userRoleInput.getRoleId());

                // Check if the role exists
                if (role != null && role.getId() > 0) {
                    // Set the new role for the user
                    user.setRole(role);

                    // Save the User entity to the database using the DAO
                    UserDAO.save(user);

                    // If the save operation is successful, add a success feedback message
                    output.addFeedbackMessage("User updated successfully.", FeedbackSeverity.SUCCESS);

                    // Indicate that the update was successful
                    output.setUpdateSuccessful(true);
                } else {
                    // If the role does not exist, indicate the failure and add a feedback message
                    output.setUpdateSuccessful(false);
                    output.addFeedbackMessage("Role not found in our database.", FeedbackSeverity.DANGER);
                }
            } else {
                // If the user does not exist or is not active, indicate the failure and add a feedback message
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage("User not found in our database.", FeedbackSeverity.DANGER);
            }
        } catch (BadCredentialsException e) {
            // If a BadCredentialsException is caught, add a danger feedback message with the exception message
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            // If a PersistentException is caught, add a danger feedback message indicating a database access error
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            // If any other exception is caught, add a danger feedback message indicating an unexpected error
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }

        // Return the output object with the result of the update operation
        return output;
    }

    /**
     * Retrieves all users from the database and returns them in a GetUsersOutput object.
     *
     * @param usersInput A GetUsersInput object containing any input parameters needed for fetching users.
     * @return An object containing the users retrieved from the database.
     */
    public GetUsersOutput getAllUsers(GetUsersInput usersInput) {
        GetUsersOutput output = new GetUsersOutput();
        try {
            // Fetch users from the database using UserDAO
            User[] users = UserDAO.listUserByQuery(null, null);

            // Check if users are retrieved successfully
            if (users.length > 0) {
                // Assign retrieved users to the output object
                output.setUsersList(Utilities.convertToDTOList(Arrays.stream(users).toList(), GetUsersOutput.UserProperties.class));
            } else {
                // Add feedback message if no roles are found
                output.addFeedbackMessage("No roles found in our database.", FeedbackSeverity.DANGER);
            }
        } catch (BadCredentialsException e) {
            // Add feedback message for bad credentials
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            // Add feedback message for database access error
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            // Add feedback message for unexpected errors
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        // Return the output object with users and feedback messages
        return output;
    }
}
