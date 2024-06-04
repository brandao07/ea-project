package eaproject.controller;

import eaproject.beans.UserBean;
import eaproject.input.*;
import eaproject.output.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
public class UserController {
    @EJB
    UserBean userBean;

    /**
     * Retrieves all users from the database and returns them in a GetUsersOutput object.
     *
     * @param usersInput A GetUsersInput object containing any input parameters needed for fetching users.
     * @return An object containing the users retrieved from the database.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetAllUsers")
    public GetUsersOutput getAllUsers(@RequestBody GetUsersInput usersInput) {
        return userBean.getAllUsers(usersInput);
    }

    /**
     * Endpoint to update the current role of a user.
     *
     * @param userRoleInput A JSON object (in the request body) containing the user ID and the new role ID.
     * @return An output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/UpdateUserCurrentRole")
    public UpdateUserRoleOutput updateUserCurrentRole(@RequestBody UpdateUserRoleInput userRoleInput) {
        return userBean.updateUserRole(userRoleInput);
    }

    /**
     * Updates basic user information.
     *
     * @param userInfoInput The input object containing user information to be updated.
     * @param request The HTTP request containing the JWT token.
     * @return An output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/UpdateBasicUserInfo")
    public UpdateUserInfoOutput updateBasicUserInfo(@RequestBody UpdateUserInfoInput userInfoInput, HttpServletRequest request) {
        return userBean.updateUserInfo(userInfoInput, request);
    }

    /**
     * Retrieves basic user information based on the provided user input.
     *
     * @param userInfoInput Input containing user ID.
     * @param request       HTTP request containing JWT token.
     * @return BasicUserInfoOutput containing user details.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/BasicUserInfo")
    public BasicUserInfoOutput getBasicUserInfo(@RequestBody BasicUserInfoInput userInfoInput, HttpServletRequest request) {
        return userBean.basicUserInfo(userInfoInput, request);
    }

    /**
     * Registers a new user with the provided registration details.
     *
     * @param userRegisterInput Input containing user registration details.
     * @return UserRegisterOutput indicating the success or failure of the registration.
     */
    @PostMapping("/Register")
    public UserRegisterOutput registerUser(@RequestBody UserRegisterInput userRegisterInput) {
        return userBean.registerNewUser(userRegisterInput);
    }

    /**
     * Authenticates a user with the provided login credentials.
     *
     * @param authenticationInput Input containing user login credentials.
     * @return AuthenticationOutput containing authentication status and details.
     */
    @PostMapping("/Login")
    public AuthenticationOutput loginUser(@RequestBody AuthenticationInput authenticationInput) {
        return userBean.authenticateUser(authenticationInput);
    }
}
