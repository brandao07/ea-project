import AuthenticationOutput from "@/models/output/AuthenticationOutput";
import CreateUserOutput from "@/models/output/CreateUserOutput";
import GetAllUsersOutput from "@/models/output/GetAllUsersOutput";
import GetUserByIdOutput from "@/models/output/GetUserByIdOutput";
import RecoverPasswordOutput from "@/models/output/RecoverPasswordOutput";
import UpdateUserOutput from "@/models/output/UpdateUserOutput";
import UpdateUserRoleOutput from "@/models/output/UpdateUserRoleOutput";
import UploadUserPhotoOutput from "@/models/output/UploadUserPhotoOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class UserService {
  /**
   * Uploaduserphoto
   * @param {UploadUserPhotoInput} input - The input
   * @returns {Promise<UploadUserPhotoOutput>} The UploadUserPhotoOutput
   */
  async uploadUserPhoto(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPLOAD_USER_PHOTO, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UploadUserPhotoOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during uploadUserPhoto.",
        FeedbackSeverity.DANGER
      );
      const output = new UploadUserPhotoOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallusers
   * @param {GetAllUsersInput} input - The input
   * @returns {Promise<GetAllUsersOutput>} The GetAllUsersOutput
   */
  async getAllUsers(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_USERS, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllUsersOutput(response.usersList, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllUsers.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllUsersOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updateusercurrentrole
   * @param {UpdateUserRoleInput} input - The input
   * @returns {Promise<UpdateUserRoleOutput>} The UpdateUserRoleOutput
   */
  async updateUserCurrentRole(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_USER_CURRENT_ROLE, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateUserRoleOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateUserCurrentRole.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateUserRoleOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updatebasicuserinfo
   * @param {UpdateUserInput} input - The input
   * @returns {Promise<UpdateUserOutput>} The UpdateUserOutput
   */
  async updateBasicUserInfo(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_BASIC_USER_INFO, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateUserOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateBasicUserInfo.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateUserOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getbasicuserinfo
   * @param {GetUserByIdInput} input - The input
   * @returns {Promise<GetUserByIdOutput>} The GetUserByIdOutput
   */
  async getBasicUserInfo(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.BASIC_USER_INFO, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetUserByIdOutput(response.name, response.email, response.gender, response.age, response.height, response.weight, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getBasicUserInfo.",
        FeedbackSeverity.DANGER
      );
      const output = new GetUserByIdOutput("", "", "", "", "", "", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Registeruser
   * @param {CreateUserInput} input - The input
   * @returns {Promise<CreateUserOutput>} The CreateUserOutput
   */
  async registerUser(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.REGISTER, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateUserOutput(response.registrationSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during registerUser.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateUserOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Loginuser
   * @param {AuthenticationInput} input - The input
   * @returns {Promise<AuthenticationOutput>} The AuthenticationOutput
   */
  async loginUser(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.LOGIN, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new AuthenticationOutput(response.token, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during loginUser.",
        FeedbackSeverity.DANGER
      );
      const output = new AuthenticationOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Recoverpassword
   * @param {RecoverPasswordInput} input - The input
   * @returns {Promise<RecoverPasswordOutput>} The RecoverPasswordOutput
   */
  async recoverPassword(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.RECOVER_PASSWORD, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new RecoverPasswordOutput(response.successful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during recoverPassword.",
        FeedbackSeverity.DANGER
      );
      const output = new RecoverPasswordOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new UserService();
