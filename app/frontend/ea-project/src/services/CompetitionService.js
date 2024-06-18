import CreateCompetitionOutput from "@/models/output/CreateCompetitionOutput";
import GetAllCompetitionsOutput from "@/models/output/GetAllCompetitionsOutput";
import GetCompetitionByIdOutput from "@/models/output/GetCompetitionByIdOutput";
import UpdateCompetitionOutput from "@/models/output/UpdateCompetitionOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class CompetitionService {
  /**
   * Createcompetitionentity
   * @param {CreateCompetitionInput} input - The input
   * @returns {Promise<CreateCompetitionOutput>} The CreateCompetitionOutput
   */
  async createCompetitionEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_COMPETITION_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateCompetitionOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createCompetitionEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateCompetitionOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updatecompetitionentity
   * @param {UpdateCompetitionInput} input - The input
   * @returns {Promise<UpdateCompetitionOutput>} The UpdateCompetitionOutput
   */
  async updateCompetitionEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_COMPETITION_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateCompetitionOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateCompetitionEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateCompetitionOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getcompetitionbyid
   * @param {GetCompetitionByIdInput} input - The input
   * @returns {Promise<GetCompetitionByIdOutput>} The GetCompetitionByIdOutput
   */
  async getCompetitionById(input) {
    try {
      console.log(input);
      console.log("teste");
      const response = await ApiService.post(API_ENDPOINTS.GET_COMPETITION_BY_ID, input);
      const output = new GetCompetitionByIdOutput(response.id, response.name, response.startDate,response.endDate,response.isActive,response.creationDate,response.gender,response.grade,response.category);
      console.log(output);
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getCompetitionById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetCompetitionByIdOutput("", "", "");
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getallcompetitions
   * @param {GetAllCompetitionsInput} input - The input
   * @returns {Promise<GetAllCompetitionsOutput>} The GetAllCompetitionsOutput
   */
  async getAllCompetitions(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_COMPETITIONS, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllCompetitionsOutput(response.competitionList, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllCompetitions.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllCompetitionsOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  async deleteCompetition(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.DELETE_COMPETITION, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllCompetitionsOutput(response.competitionList, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during deleteCompetition.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllCompetitionsOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new CompetitionService();
