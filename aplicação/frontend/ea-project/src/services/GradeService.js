import CreateGradeOutput from "@/models/output/CreateGradeOutput";
import GetAllGradesOutput from "@/models/output/GetAllGradesOutput";
import GetGradeByIdOutput from "@/models/output/GetGradeByIdOutput";
import UpdateGradeOutput from "@/models/output/UpdateGradeOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class GradeService {
  /**
   * Creategradeentity
   * @param {CreateGradeInput} input - The input
   * @returns {Promise<CreateGradeOutput>} The CreateGradeOutput
   */
  async createGradeEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_GRADE_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateGradeOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createGradeEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateGradeOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updategradeentity
   * @param {UpdateGradeInput} input - The input
   * @returns {Promise<UpdateGradeOutput>} The UpdateGradeOutput
   */
  async updateGradeEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_GRADE_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateGradeOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateGradeEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateGradeOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getgradebyid
   * @param {GetGradeByIdInput} input - The input
   * @returns {Promise<GetGradeByIdOutput>} The GetGradeByIdOutput
   */
  async getGradeById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_GRADE_BY_ID, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetGradeByIdOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getGradeById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetGradeByIdOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallgrades
   * @param {GetAllGradesInput} input - The input
   * @returns {Promise<GetAllGradesOutput>} The GetAllGradesOutput
   */
  async getAllGrades(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_GRADES, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllGradesOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllGrades.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllGradesOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new GradeService();
