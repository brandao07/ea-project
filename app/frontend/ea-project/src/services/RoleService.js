import CreateRoleOutput from "@/models/output/CreateRoleOutput";
import GetAllRolesOutput from "@/models/output/GetAllRolesOutput";
import GetRoleByIdOutput from "@/models/output/GetRoleByIdOutput";
import UpdateRoleOutput from "@/models/output/UpdateRoleOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class RoleService {
  /**
   * Createroleentity
   * @param {CreateRoleInput} input - The input
   * @returns {Promise<CreateRoleOutput>} The CreateRoleOutput
   */
  async createRoleEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_ROLE_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateRoleOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createRoleEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateRoleOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updateroleentity
   * @param {UpdateRoleInput} input - The input
   * @returns {Promise<UpdateRoleOutput>} The UpdateRoleOutput
   */
  async updateRoleEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_ROLE_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateRoleOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateRoleEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateRoleOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getrolebyid
   * @param {GetRoleByIdInput} input - The input
   * @returns {Promise<GetRoleByIdOutput>} The GetRoleByIdOutput
   */
  async getRoleById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ROLE_BY_ID, input);
      const output = new GetRoleByIdOutput(response.id, response.name, response.description, response.creationDate);
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getRoleById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetRoleByIdOutput("", "", "", "");
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallroles
   * @param {GetAllRolesInput} input - The input
   * @returns {Promise<GetAllRolesOutput>} The GetAllRolesOutput
   */
  async getAllRoles(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_ROLES, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllRolesOutput(response.rolesList, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllRoles.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllRolesOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new RoleService();
