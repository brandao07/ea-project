package eaproject.controller;

import eaproject.beans.UserBean;
import eaproject.input.*;
import eaproject.output.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/UploadUserPhoto")
    public UploadUserPhotoOutput uploadUserPhoto(@RequestParam("id") int id, @RequestParam("photo") MultipartFile photo) {
        UploadUserPhotoInput input = new UploadUserPhotoInput();
        input.setId(id);
        input.setPhoto(photo);
        return userBean.uploadUserPhoto(input);
    }

    /**
     * Retrieves all users from the database and returns them in a GetAllUsersOutput object.
     *
     * @param usersInput A GetAllUsersInput object containing any input parameters needed for fetching users.
     * @return An object containing the users retrieved from the database.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetAllUsers")
    public GetAllUsersOutput getAllUsers(@RequestBody GetAllUsersInput usersInput) {
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
    public UpdateUserOutput updateBasicUserInfo(@RequestBody UpdateUserInput userInfoInput, HttpServletRequest request) {
        return userBean.updateUserInfo(userInfoInput, request);
    }

    /**
     * Retrieves basic user information based on the provided user input.
     *
     * @param userInfoInput Input containing user ID.
     * @param request       HTTP request containing JWT token.
     * @return GetUserByIdOutput containing user details.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/BasicUserInfo")
    public GetUserByIdOutput getBasicUserInfo(@RequestBody GetUserByIdInput userInfoInput, HttpServletRequest request) {
        return userBean.basicUserInfo(userInfoInput, request);
    }

    /**
     * Registers a new user with the provided registration details.
     *
     * @param CreateUserInput Input containing user registration details.
     * @return CreateUserOutput indicating the success or failure of the registration.
     */
    @PostMapping("/Register")
    public CreateUserOutput registerUser(@RequestBody CreateUserInput CreateUserInput) {
        return userBean.registerNewUser(CreateUserInput);
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
