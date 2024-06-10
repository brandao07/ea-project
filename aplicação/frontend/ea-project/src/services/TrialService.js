import CreateTrialOutput from "@/models/output/CreateTrialOutput";
import GetAllTrialsOutput from "@/models/output/GetAllTrialsOutput";
import GetTrialByIdOutput from "@/models/output/GetTrialByIdOutput";
import UpdateTrialOutput from "@/models/output/UpdateTrialOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class TrialService {
  /**
   * Createtrialentity
   * @param {CreateTrialInput} input - The input
   * @returns {Promise<CreateTrialOutput>} The CreateTrialOutput
   */
  async createTrialEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_TRIAL_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateTrialOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createTrialEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateTrialOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updatetrialentity
   * @param {UpdateTrialInput} input - The input
   * @returns {Promise<UpdateTrialOutput>} The UpdateTrialOutput
   */
  async updateTrialEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_TRIAL_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateTrialOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateTrialEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateTrialOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Gettrialbyid
   * @param {GetTrialByIdInput} input - The input
   * @returns {Promise<GetTrialByIdOutput>} The GetTrialByIdOutput
   */
  async getTrialById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_TRIAL_BY_ID, input);
      const output = new GetTrialByIdOutput(response.id, response.name, response.startDate);
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getTrialById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetTrialByIdOutput("", "", "");
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getalltrials
   * @param {GetAllTrialsInput} input - The input
   * @returns {Promise<GetAllTrialsOutput>} The GetAllTrialsOutput
   */
  async getAllTrials(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_TRIALS, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllTrialsOutput(response.trials, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllTrials.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllTrialsOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new TrialService();
