package eaproject.controller;

import eaproject.beans.UserBean;
import eaproject.input.*;
import eaproject.output.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
public class UserController {
    @EJB
    UserBean userBean;

    /**
     * Uploads a user's photo to Firebase Storage and updates the user's record in the database with the photo's URL.
     *
     * @param input The input object containing the user ID and the photo to be uploaded.
     * @return An UploadUserPhotoOutput object containing the result of the operation and any feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/UploadUserPhoto")
    public UploadUserPhotoOutput uploadUserPhoto(@RequestBody UploadUserPhotoInput input) {
        return userBean.uploadUserPhoto(input);
    }

    /**
     * Retrieves all users from the database and returns them in a GetAllUsersOutput object.
     *
     * @param input A GetAllUsersInput object containing any input parameters needed for fetching users.
     * @return An object containing the users retrieved from the database.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetAllUsers")
    public GetAllUsersOutput getAllUsers(@RequestBody GetAllUsersInput input) {
        return userBean.getAllUsers(input);
    }

    /**
     * Endpoint to update the current role of a user.
     *
     * @param input A JSON object (in the request body) containing the user ID and the new role ID.
     * @return An output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/UpdateUserCurrentRole")
    public UpdateUserRoleOutput updateUserCurrentRole(@RequestBody UpdateUserRoleInput input) {
        return userBean.updateUserRole(input);
    }

    /**
     * Updates basic user information.
     *
     * @param input The input object containing user information to be updated.
     * @param request The HTTP request containing the JWT token.
     * @return An output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/UpdateBasicUserInfo")
    public UpdateUserOutput updateBasicUserInfo(@RequestBody UpdateUserInput input, HttpServletRequest request) {
        return userBean.updateUserInfo(input, request);
    }

    /**
     * Retrieves basic user information based on the provided user input.
     *
     * @param input Input containing user ID.
     * @param request       HTTP request containing JWT token.
     * @return GetUserByIdOutput containing user details.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/BasicUserInfo")
    public GetUserByIdOutput getBasicUserInfo(@RequestBody GetUserByIdInput input, HttpServletRequest request) {
        return userBean.basicUserInfo(input, request);
    }

    /**
     * Registers a new user with the provided registration details.
     *
     * @param input Input containing user registration details.
     * @return CreateUserOutput indicating the success or failure of the registration.
     */
    @PostMapping("/Register")
    public CreateUserOutput registerUser(@RequestBody CreateUserInput input) {
        return userBean.registerNewUser(input);
    }

    /**
     * Authenticates a user with the provided login credentials.
     *
     * @param input Input containing user login credentials.
     * @return AuthenticationOutput containing authentication status and details.
     */
    @PostMapping("/Login")
    public AuthenticationOutput loginUser(@RequestBody AuthenticationInput input) {
        return userBean.authenticateUser(input);
    }

    /**
     * Recover User Password.
     *
     * @param input Input containing user email.
     * @return RecoverPasswordOutput indicating the success or failure of the operation.
     */
    @PostMapping("/RecoverPassword")
    public RecoverPasswordOutput recoverPassword(@RequestBody RecoverPasswordInput input) {
        return userBean.recoverPassword(input);
    }

    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetUsersByTeamId")
    public GetUsersByTeamIdOutput getUsersByTeamIdOutput(@RequestBody GetUsersByTeamIdInput input) {
        return userBean.getUsersByTeamIdInput(input);
    }
}
