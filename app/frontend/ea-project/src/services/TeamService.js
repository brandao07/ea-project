import CreateTeamOutput from "@/models/output/CreateTeamOutput";
import GetAllTeamsOutput from "@/models/output/GetAllTeamsOutput";
import GetTeamByIdOutput from "@/models/output/GetTeamByIdOutput";
import GetTeamsByTrialIdOutput from "@/models/output/GetTeamsByTrialIdOutput";
import UpdateTeamOutput from "@/models/output/UpdateTeamOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class TeamService {
  /**
   * Createteamentity
   * @param {CreateTeamInput} input - The input
   * @returns {Promise<CreateTeamOutput>} The CreateTeamOutput
   */
  async createTeamEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_TEAM_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateTeamOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createTeamEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateTeamOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updateteamentity
   * @param {UpdateTeamInput} input - The input
   * @returns {Promise<UpdateTeamOutput>} The UpdateTeamOutput
   */
  async updateTeamEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_TEAM_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateTeamOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateTeamEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateTeamOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getteambyid
   * @param {GetTeamByIdInput} input - The input
   * @returns {Promise<GetTeamByIdOutput>} The GetTeamByIdOutput
   */
  async getTeamById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_TEAM_BY_ID, input);
      const output = new GetTeamByIdOutput(response.id, response.name, response.isActive, response.creationDate);
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getTeamById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetTeamByIdOutput("", "", "", "");
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallteams
   * @param {GetAllTeamsInput} input - The input
   * @returns {Promise<GetAllTeamsOutput>} The GetAllTeamsOutput
   */
  async getAllTeams(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_TEAMS, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllTeamsOutput(response.teamList, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllTeams.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllTeamsOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getteamsbytrialidoutput
   * @param {GetTeamsByTrialIdInput} input - The input
   * @returns {Promise<GetTeamsByTrialIdOutput>} The GetTeamsByTrialIdOutput
   */
  async getTeamsByTrialIdOutput(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_TEAMS_BY_TRIAL_ID, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetTeamsByTrialIdOutput(response.teamList, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getTeamsByTrialIdOutput.",
        FeedbackSeverity.DANGER
      );
      const output = new GetTeamsByTrialIdOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new TeamService();
