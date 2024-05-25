package eaproject.beans.locals;

import eaproject.input.AuthenticationInput;
import eaproject.input.UserRegisterInput;
import eaproject.output.AuthenticationOutput;
import eaproject.output.UserRegisterOutput;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.ejb.Local;

@Local
public interface UserLocal {
    /**
     * Authenticates a user based on the provided input data.
     *
     * @param userInput the input data for user authentication
     * @return AuthenticationOutput containing the authentication result, token, and feedback messages
     * @throws UsernameNotFoundException if the user is not found
     */
    AuthenticationOutput authenticateUser(AuthenticationInput userInput) throws UsernameNotFoundException;

    /**
     * Registers a new user based on the provided input data.
     *
     * @param input the input data for registering a new user
     * @return UserRegisterOutput containing the registration result and feedback messages
     */
    UserRegisterOutput registerNewUser(UserRegisterInput input);
}