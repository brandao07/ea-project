import UserRegisterOutput from "@/models/output/UserRegisterOutput";
import AuthenticationOutput from "@/models/output/AuthenticationOutput";
import BasicUserInfoOutput from "@/models/output/BasicUserInfoOutput";
import UpdateUserInfoOutput from "@/models/output/UpdateUserInfoOutput";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import EventBus from "@/eventBus";
import ApiService from "@/services/ApiService";

class UserService {
  /**
   * Registers a new user
   * @param {UserRegisterInput} userRegisterInput - The user registration input
   * @returns {Promise<UserRegisterOutput>} The user registration output
   */
  async registerUser(userRegisterInput) {
    try {
      const response = await ApiService.post(
        API_ENDPOINTS.REGISTER,
        userRegisterInput
      );
      const output = new UserRegisterOutput(
        response.registrationSuccessful,
        response.feedbackMessages
      );
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during registration.",
        FeedbackSeverity.DANGER
      );
      const output = new UserRegisterOutput(false, [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
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
      const response = await ApiService.post(
        API_ENDPOINTS.LOGIN,
        authenticationInput
      );
      const feedbackMessages = response.feedbackMessages.map(
        (msg) =>
          new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new AuthenticationOutput(response.token, feedbackMessages);
      ApiService.setToken(response.token); // Store the token
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during authentication.",
        FeedbackSeverity.DANGER
      );
      const output = new AuthenticationOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Retrieves basic user info
   * @param {BasicUserInfoInput} userInfoInput - The basic user info input
   * @returns {Promise<BasicUserInfoOutput>} The basic user info output
   */
  async getBasicUserInfo(userInfoInput) {
    try {
      const response = await ApiService.post(
        API_ENDPOINTS.BASIC_USER_INFO,
        userInfoInput
      );
      const feedbackMessages = response.feedbackMessages.map(
        (msg) =>
          new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new BasicUserInfoOutput(
        response.name,
        response.email,
        response.gender,
        response.age,
        response.height,
        response.weight,
        feedbackMessages
      );
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during service call.",
        FeedbackSeverity.DANGER
      );
      const output = new BasicUserInfoOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updates an existing user
   * @param {UpdateUserInfoInput} userRegisterInput - The update user basic info input
   * @returns {Promise<UpdateUserInfoOutput>} The update user basic info output
   */
  async updateBasicUserInfo(userInfoInput) {
    try {
      const response = await ApiService.post(
        API_ENDPOINTS.UPDATE_BASIC_USER_INFO,
        userInfoInput
      );
      const output = new UpdateUserInfoOutput(
        response.updateSuccessful,
        response.feedbackMessages
      );
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during update.",
        FeedbackSeverity.DANGER
      );
      const output = new UserRegisterOutput(false, [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }
}

export default new UserService();
