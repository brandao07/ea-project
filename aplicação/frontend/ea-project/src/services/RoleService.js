import GetRolesOutput from "@/models/output/GetRolesOutput";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import EventBus from "@/eventBus";
import ApiService from "@/services/ApiService";

class RoleService {
  /**
   * Retrieves all roles from the database
   * @param {GetRolesInput} rolesInput - The get roles input
   * @returns {Promise<GetRolesOutput>} The get roles output
   */
  async getAllUsers(rolesInput) {
    try {
      const response = await ApiService.post(
        API_ENDPOINTS.GET_ALL_ROLES,
        rolesInput
      );
      const output = new GetRolesOutput(
        response.rolesList,
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
      const output = new GetRolesOutput(false, [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }
}

export default new RoleService();
