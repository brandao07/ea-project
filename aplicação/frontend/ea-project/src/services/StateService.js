import CreateStateOutput from "@/models/output/CreateStateOutput";
import GetAllStatesOutput from "@/models/output/GetAllStatesOutput";
import GetStateByIdOutput from "@/models/output/GetStateByIdOutput";
import UpdateStateOutput from "@/models/output/UpdateStateOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class StateService {
  /**
   * Createstateentity
   * @param {CreateStateInput} input - The input
   * @returns {Promise<CreateStateOutput>} The CreateStateOutput
   */
  async createStateEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_STATE_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateStateOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createStateEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateStateOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updatestateentity
   * @param {UpdateStateInput} input - The input
   * @returns {Promise<UpdateStateOutput>} The UpdateStateOutput
   */
  async updateStateEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_STATE_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateStateOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateStateEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateStateOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getstatebyid
   * @param {GetStateByIdInput} input - The input
   * @returns {Promise<GetStateByIdOutput>} The GetStateByIdOutput
   */
  async getStateById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_STATE_BY_ID, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetStateByIdOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getStateById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetStateByIdOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallstates
   * @param {GetAllStatesInput} input - The input
   * @returns {Promise<GetAllStatesOutput>} The GetAllStatesOutput
   */
  async getAllStates(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_STATES, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllStatesOutput(response, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllStates.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllStatesOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new StateService();
