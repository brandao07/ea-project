import CreateLocationOutput from "@/models/output/CreateLocationOutput";
import GetAllLocationsOutput from "@/models/output/GetAllLocationsOutput";
import GetLocationByIdOutput from "@/models/output/GetLocationByIdOutput";
import UpdateLocationOutput from "@/models/output/UpdateLocationOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class LocationService {
  /**
   * Createlocationentity
   * @param {CreateLocationInput} input - The input
   * @returns {Promise<CreateLocationOutput>} The CreateLocationOutput
   */
  async createLocationEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.CREATE_LOCATION_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new CreateLocationOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during createLocationEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new CreateLocationOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Updatelocationentity
   * @param {UpdateLocationInput} input - The input
   * @returns {Promise<UpdateLocationOutput>} The UpdateLocationOutput
   */
  async updateLocationEntity(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.UPDATE_LOCATION_ENTITY, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new UpdateLocationOutput(response.updateSuccessful, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during updateLocationEntity.",
        FeedbackSeverity.DANGER
      );
      const output = new UpdateLocationOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getlocationbyid
   * @param {GetLocationByIdInput} input - The input
   * @returns {Promise<GetLocationByIdOutput>} The GetLocationByIdOutput
   */
  async getLocationById(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_LOCATION_BY_ID, input);
      const output = new GetLocationByIdOutput(response.id, response.latitude, response.longitude, response.address, response.city, response.country, response.postalCode, response.creationDate);
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getLocationById.",
        FeedbackSeverity.DANGER
      );
      const output = new GetLocationByIdOutput("", "", "", "", "", "", "", "");
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

  /**
   * Getalllocations
   * @param {GetAllLocationsInput} input - The input
   * @returns {Promise<GetAllLocationsOutput>} The GetAllLocationsOutput
   */
  async getAllLocations(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_ALL_LOCATIONS, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetAllLocationsOutput(response.locationList, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getAllLocations.",
        FeedbackSeverity.DANGER
      );
      const output = new GetAllLocationsOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new LocationService();
