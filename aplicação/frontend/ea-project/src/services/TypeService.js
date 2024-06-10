import CreateTypeOutput from "@/models/output/CreateTypeOutput";
import GetAllTypesOutput from "@/models/output/GetAllTypesOutput";
import GetTypeByIdOutput from "@/models/output/GetTypeByIdOutput";
import UpdateTypeOutput from "@/models/output/UpdateTypeOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class TypeService {
  /**
   * Createtypeentity
   * @param {CreateTypeInput} input - The input
   * @returns {Promise<CreateTypeOutput>} The CreateTypeOutput
   */
  async createTypeEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_TYPE_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateTypeOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createTypeEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateTypeOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updatetypeentity
   * @param {UpdateTypeInput} input - The input
   * @returns {Promise<UpdateTypeOutput>} The UpdateTypeOutput
   */
  async updateTypeEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_TYPE_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateTypeOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateTypeEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateTypeOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Gettypebyid
   * @param {GetTypeByIdInput} input - The input
   * @returns {Promise<GetTypeByIdOutput>} The GetTypeByIdOutput
   */
  async getTypeById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_TYPE_BY_ID, input);
      const output = new GetTypeByIdOutput(response.id, response.name, response.numberOfPersons, response.creationDate);
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getTypeById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetTypeByIdOutput("", "", "", "");
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getalltypes
   * @param {GetAllTypesInput} input - The input
   * @returns {Promise<GetAllTypesOutput>} The GetAllTypesOutput
   */
  async getAllTypes(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_TYPES, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllTypesOutput(response.types, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllTypes.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllTypesOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new TypeService();
