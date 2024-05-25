import axios from "axios";
import UserRegisterOutput from "@/models/output/UserRegisterOutput";
import AuthenticationOutput from "@/models/output/AuthenticationOutput";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from '@/models/base/FeedbackMessage';
import EventBus from '@/eventBus';

class UserService {
  /**
   * Registers a new user
   * @param {UserRegisterInput} userRegisterInput - The user registration input
   * @returns {Promise<UserRegisterOutput>} The user registration output
   */
  async registerUser(userRegisterInput) {
    try {
      const response = await axios.post(API_ENDPOINTS.REGISTER, userRegisterInput);
      const output = new UserRegisterOutput(response.data.registrationSuccessful, response.data.feedbackMessages);
      output.feedbackMessages.forEach(msg => {
        EventBus.emit('feedback-message', msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage('An error occurred during registration.', FeedbackSeverity.DANGER);
      const output = new UserRegisterOutput(false, [errorMessage]);
      EventBus.emit('feedback-message', errorMessage);
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
      const feedbackMessages = response.data.feedbackMessages.map(msg =>
        new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new AuthenticationOutput(response.data.token, feedbackMessages);
      output.feedbackMessages.forEach(msg => {
        EventBus.emit('feedback-message', msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage('An error occurred during authentication.', FeedbackSeverity.DANGER);
      const output = new AuthenticationOutput('', [errorMessage]);
      EventBus.emit('feedback-message', errorMessage);
      return output;
    }
  }
}

export default new UserService();
