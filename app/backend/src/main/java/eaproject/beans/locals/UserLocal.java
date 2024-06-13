package eaproject.beans.locals;

import eaproject.input.*;
import eaproject.output.*;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface UserLocal {

    /**
     * Uploads a user's photo to Firebase Storage and updates the user's record in the database with the photo's URL.
     *
     * @param input The input object containing the user ID and the photo to be uploaded.
     * @return An UploadUserPhotoOutput object containing the result of the operation and any feedback messages.
     */
    UploadUserPhotoOutput uploadUserPhoto(UploadUserPhotoInput input);

    /**
     * Retrieves all users from the database and returns them in a GetAllUsersOutput object.
     *
     * @param usersInput A GetAllUsersInput object containing any input parameters needed for fetching users.
     * @return An object containing the users retrieved from the database.
     */
    GetAllUsersOutput getAllUsers(GetAllUsersInput usersInput);

    /**
     * Updates the role of a user based on the provided input.
     *
     * @param userRoleInput An object containing the user ID and the new role ID.
     * @return An output object containing the result of the update operation.
     */
    UpdateUserRoleOutput updateUserRole(UpdateUserRoleInput userRoleInput);

    /**
     * Updates user information.
     *
     * @param userInfoInput The input object containing user information to be updated.
     * @param request       The HTTP request containing the JWT token.
     * @return An output object containing the result of the update operation.
     */
    UpdateUserOutput updateUserInfo(UpdateUserInput userInfoInput, HttpServletRequest request);

    /**
     * Retrieves basic user information based on the provided user input.
     * Accessible by users with 'ROLE_USER' or 'ROLE_ADMIN' roles.
     *
     * @param userInfoInput Input containing user ID.
     * @param request       HTTP request containing JWT token.
     * @return GetUserByIdOutput containing user details.
     */
    GetUserByIdOutput basicUserInfo(GetUserByIdInput userInfoInput, HttpServletRequest request);

    /**
     * Registers a new user with the provided registration details.
     *
     * @param userRegisterInput Input containing user registration details.
     * @return CreateUserOutput indicating the success or failure of the registration.
     */
    CreateUserOutput registerNewUser(CreateUserInput userRegisterInput);

    /**
     * Authenticates a user with the provided login credentials.
     *
     * @param authenticationInput Input containing user login credentials.
     * @return AuthenticationOutput containing authentication status and details.
     */
    AuthenticationOutput authenticateUser(AuthenticationInput authenticationInput);
}