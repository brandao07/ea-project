import GetWeatherOutput from "@/models/output/GetWeatherOutput";

import ApiService from "@/services/ApiService";
import API_ENDPOINTS from "@/config/api";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";
import EventBus from "@/eventBus";

class WeatherService {
  /**
   * Getcurrentweather
   * @param {GetWeatherInput} input - The input
   * @returns {Promise<GetWeatherOutput>} The GetWeatherOutput
   */
  async getCurrentWeather(input) {
    try {
      const response = await ApiService.post(API_ENDPOINTS.GET_WEATHER, input);
      const feedbackMessages = response.feedbackMessages.map(
        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])
      );
      const output = new GetWeatherOutput(response.weather, feedbackMessages);
      output.feedbackMessages.forEach((msg) => {
        EventBus.emit("feedback-message", msg);
      });
      return output;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during getCurrentWeather.",
        FeedbackSeverity.DANGER
      );
      const output = new GetWeatherOutput("", [errorMessage]);
      EventBus.emit("feedback-message", errorMessage);
      return output;
    }
  }

}

export default new WeatherService();
