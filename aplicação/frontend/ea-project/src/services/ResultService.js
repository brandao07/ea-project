import CreateResultOutput from "@/models/output/CreateResultOutput";
import GetAllResultsOutput from "@/models/output/GetAllResultsOutput";
import GetResultByIdOutput from "@/models/output/GetResultByIdOutput";
import UpdateResultOutput from "@/models/output/UpdateResultOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class ResultService {
  /**
   * Createresultentity
   * @param {CreateResultInput} input - The input
   * @returns {Promise<CreateResultOutput>} The CreateResultOutput
   */
  async createResultEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_RESULT_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateResultOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createResultEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateResultOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updateresultentity
   * @param {UpdateResultInput} input - The input
   * @returns {Promise<UpdateResultOutput>} The UpdateResultOutput
   */
  async updateResultEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_RESULT_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateResultOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateResultEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateResultOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getresultbyid
   * @param {GetResultByIdInput} input - The input
   * @returns {Promise<GetResultByIdOutput>} The GetResultByIdOutput
   */
  async getResultById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_RESULT_BY_ID, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetResultByIdOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getResultById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetResultByIdOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallresults
   * @param {GetAllResultsInput} input - The input
   * @returns {Promise<GetAllResultsOutput>} The GetAllResultsOutput
   */
  async getAllResults(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_RESULTS, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllResultsOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllResults.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllResultsOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new ResultService();
