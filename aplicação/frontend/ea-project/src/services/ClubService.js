import CreateClubOutput from "@/models/output/CreateClubOutput";
import GetAllClubsOutput from "@/models/output/GetAllClubsOutput";
import GetClubByIdOutput from "@/models/output/GetClubByIdOutput";
import UpdateClubOutput from "@/models/output/UpdateClubOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class ClubService {
  /**
   * Createclubentity
   * @param {CreateClubInput} input - The input
   * @returns {Promise<CreateClubOutput>} The CreateClubOutput
   */
  async createClubEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_CLUB_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateClubOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createClubEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateClubOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updateclubentity
   * @param {UpdateClubInput} input - The input
   * @returns {Promise<UpdateClubOutput>} The UpdateClubOutput
   */
  async updateClubEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_CLUB_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateClubOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateClubEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateClubOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getclubbyid
   * @param {GetClubByIdInput} input - The input
   * @returns {Promise<GetClubByIdOutput>} The GetClubByIdOutput
   */
  async getClubById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_CLUB_BY_ID, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetClubByIdOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getClubById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetClubByIdOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallclubs
   * @param {GetAllClubsInput} input - The input
   * @returns {Promise<GetAllClubsOutput>} The GetAllClubsOutput
   */
  async getAllClubs(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_CLUBS, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllClubsOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllClubs.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllClubsOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new ClubService();
