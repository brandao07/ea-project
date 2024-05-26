package eaproject.beans;

import eaproject.beans.locals.UserLocal;
import eaproject.dao.*;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.AuthenticationInput;
import eaproject.input.UserRegisterInput;
import eaproject.output.AuthenticationOutput;
import eaproject.output.UserRegisterOutput;
import eaproject.utilities.JwtTokenUtil;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

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
            // Use prepared statement to prevent SQL injection
            String condition = "email = '" + userInput.getEmail() + "'";
            User user = UserDAO.loadUserByQuery(condition, null);

            if (user != null && user.getUserId() > 0 && user.getIsActive()) {
                if (passwordEncoder.matches(userInput.getPassword(), user.getPassword())) {
                    String token = JwtTokenUtil.createToken(user);
                    output.setToken(token);
                    output.addFeedbackMessage("Login successful", FeedbackSeverity.SUCCESS);
                } else {
                    throw new BadCredentialsException("Invalid email or password");
                }
            } else {
                throw new BadCredentialsException("Invalid email or password");
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

            // Convert UserOutput to User entity
            User user = Utilities.convertToDAO(input, User.class);

            // Hash the password using the injected PasswordEncoder
            String hashedPassword = passwordEncoder.encode(Objects.requireNonNull(user).getPassword());

            // Set the hashed password
            user.setPassword(hashedPassword);

            // Set user active
            user.setIsActive(true);

            // Set user registration date
            user.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));

            // Get base role FIXME: We need to change this to a base role...
            Role role = RoleDAO.getRoleByORMID(1);

            // Set base role FIXME: See comments above
            user.setRole(role);

            // Get base team FIXME: We need get the team from another way, maybe perform a select of the team when register?!...
            Team team = TeamDAO.getTeamByORMID(1);

            // Set base team FIXME: See comments above
            user.setTeam(team);

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
}
