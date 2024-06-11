import CreateNotificationOutput from "@/models/output/CreateNotificationOutput";
import GetAllNotificationsOutput from "@/models/output/GetAllNotificationsOutput";
import GetNotificationByIdOutput from "@/models/output/GetNotificationByIdOutput";
import UpdateNotificationOutput from "@/models/output/UpdateNotificationOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class NotificationService {
  /**
   * Createnotificationentity
   * @param {CreateNotificationInput} input - The input
   * @returns {Promise<CreateNotificationOutput>} The CreateNotificationOutput
   */
  async createNotificationEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_NOTIFICATION_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateNotificationOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createNotificationEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateNotificationOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updatenotificationentity
   * @param {UpdateNotificationInput} input - The input
   * @returns {Promise<UpdateNotificationOutput>} The UpdateNotificationOutput
   */
  async updateNotificationEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_NOTIFICATION_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateNotificationOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateNotificationEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateNotificationOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getnotificationbyid
   * @param {GetNotificationByIdInput} input - The input
   * @returns {Promise<GetNotificationByIdOutput>} The GetNotificationByIdOutput
   */
  async getNotificationById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_NOTIFICATION_BY_ID, input);
      const output = new GetNotificationByIdOutput(response.id, response.messageHeader, response.messageBody, response.messageType, response.photographyPath, response.creationDate);
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getNotificationById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetNotificationByIdOutput("", "", "", "", "", "");
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallnotifications
   * @param {GetAllNotificationsInput} input - The input
   * @returns {Promise<GetAllNotificationsOutput>} The GetAllNotificationsOutput
   */
  async getAllNotifications(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_NOTIFICATIONS, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllNotificationsOutput(response.notificationList, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllNotifications.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllNotificationsOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new NotificationService();
