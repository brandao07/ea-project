import axios from 'axios';
import UserRegisterOutput from '@/models/output/UserRegisterOutput';
import AuthenticationOutput from '@/models/output/AuthenticationOutput';
import FeedbackSeverity from '@/models/enums/FeedbackSeverity';
import API_ENDPOINTS from '@/config/api';


class UserService {
    /**
     * Registers a new user
     * @param {UserRegisterInput} userRegisterInput - The user registration input
     * @returns {Promise<UserRegisterOutput>} The user registration output
     */
    async registerUser(userRegisterInput) {
        try {
            const response = await axios.post(API_ENDPOINTS.REGISTER, userRegisterInput);
            const output = new UserRegisterOutput(response.data.registrationSuccessful);
            output.setFeedbackMessages(response.data.feedbackMessages);
            return output;
        } catch (error) {
            const output = new UserRegisterOutput(false);
            output.addFeedbackMessage('An error occurred during registration.', FeedbackSeverity.DANGER);
            return output;
        }
    }

    /**
     * Authenticates a user
     * @param {AuthenticationInput} authenticationInput - The authentication input
     * @returns {Promise<AuthenticationOutput>} The authentication output
     */
    async loginUser(authenticationInput) {
        try {
            const response = await axios.post(API_ENDPOINTS.LOGIN, authenticationInput);
            const output = new AuthenticationOutput(response.data.token);
            output.setFeedbackMessages(response.data.feedbackMessages);
            return output;
        } catch (error) {
            const output = new AuthenticationOutput('');
            output.addFeedbackMessage('An error occurred during authentication.', FeedbackSeverity.DANGER);
            return output;
        }
    }
}

export default new UserService();
