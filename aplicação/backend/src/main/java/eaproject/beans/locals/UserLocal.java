package eaproject.beans.locals;

import eaproject.input.AuthenticationInput;
import eaproject.input.BasicUserInfoInput;
import eaproject.input.UpdateUserInfoInput;
import eaproject.input.UserRegisterInput;
import eaproject.output.AuthenticationOutput;
import eaproject.output.BasicUserInfoOutput;
import eaproject.output.UpdateUserInfoOutput;
import eaproject.output.UserRegisterOutput;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface UserLocal {

    /**
     * Updates user information.
     *
     * @param userInfoInput The input object containing user information to be updated.
     * @param request       The HTTP request containing the JWT token.
     * @return An output object containing the result of the update operation.
     */
    UpdateUserInfoOutput updateUserInfo(UpdateUserInfoInput userInfoInput, HttpServletRequest request);

    /**
     * Retrieves basic user information based on the provided user input.
     * Accessible by users with 'ROLE_USER' or 'ROLE_ADMIN' roles.
     *
     * @param userInfoInput Input containing user ID.
     * @param request       HTTP request containing JWT token.
     * @return BasicUserInfoOutput containing user details.
     */
    BasicUserInfoOutput basicUserInfo(BasicUserInfoInput userInfoInput, HttpServletRequest request);

    /**
     * Registers a new user with the provided registration details.
     *
     * @param userRegisterInput Input containing user registration details.
     * @return UserRegisterOutput indicating the success or failure of the registration.
     */
    UserRegisterOutput registerNewUser(UserRegisterInput userRegisterInput);

    /**
     * Authenticates a user with the provided login credentials.
     *
     * @param authenticationInput Input containing user login credentials.
     * @return AuthenticationOutput containing authentication status and details.
     */
    AuthenticationOutput authenticateUser(AuthenticationInput authenticationInput);
}