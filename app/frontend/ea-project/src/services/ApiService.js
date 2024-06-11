import axios from "axios";
import EventBus from "@/eventBus";
import FeedbackMessage from "@/models/base/FeedbackMessage";
import FeedbackSeverity from "@/models/enums/FeedbackSeverity";

class ApiService {
  constructor() {
    this.token = localStorage.getItem("token"); // Retrieve the token from localStorage
  }

  /**
   * Sets the authentication token and saves it to localStorage
   * @param {string} token - The authentication token
   */
  setToken(token) {
    this.token = token;
    localStorage.setItem("token", token); // Save the token to localStorage
  }

  /**
   * Clears the authentication token and removes it from localStorage
   */
  clearToken() {
    this.token = null;
    localStorage.removeItem("token"); // Remove the token from localStorage
  }

  /**
   * Internal method to get headers
   * @returns {object} Headers object with Authorization if token is set
   */
  _getHeaders() {
    const headers = {
      Accept: "application/json, text/plain, */*",
    };
    if (this.token) {
      headers["Authorization"] = this.token;
    }
    return headers;
  }

  /**
   * Makes a generic authenticated GET request
   * @param {string} endpoint - The API endpoint
   * @param {object} [params={}] - The query parameters
   * @returns {Promise<any>} The API response
   */
  async get(endpoint, params = {}) {
    try {
      const response = await axios.get(endpoint, {
        headers: this._getHeaders(),
        params: params,
      });
      return response.data;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during the GET request.",
        FeedbackSeverity.DANGER
      );
      EventBus.emit("feedback-message", errorMessage);
      throw error;
    }
  }

  /**
   * Makes a generic authenticated POST request
   * @param {string} endpoint - The API endpoint
   * @param {object} data - The request data
   * @returns {Promise<any>} The API response
   */
  async post(endpoint, data) {
    try {
      const response = await axios.post(endpoint, data, {
        headers: this._getHeaders(),
      });
      return response.data;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during the POST request.",
        FeedbackSeverity.DANGER
      );
      EventBus.emit("feedback-message", errorMessage);
      throw error;
    }
  }

  /**
   * Makes a generic authenticated PUT request
   * @param {string} endpoint - The API endpoint
   * @param {object} data - The request data
   * @returns {Promise<any>} The API response
   */
  async put(endpoint, data) {
    try {
      const response = await axios.put(endpoint, data, {
        headers: this._getHeaders(),
      });
      return response.data;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during the PUT request.",
        FeedbackSeverity.DANGER
      );
      EventBus.emit("feedback-message", errorMessage);
      throw error;
    }
  }

  /**
   * Makes a generic authenticated DELETE request
   * @param {string} endpoint - The API endpoint
   * @param {object} [params={}] - The query parameters
   * @returns {Promise<any>} The API response
   */
  async delete(endpoint, params = {}) {
    try {
      const response = await axios.delete(endpoint, {
        headers: this._getHeaders(),
        params: params,
      });
      return response.data;
    } catch (error) {
      const errorMessage = new FeedbackMessage(
        "An error occurred during the DELETE request.",
        FeedbackSeverity.DANGER
      );
      EventBus.emit("feedback-message", errorMessage);
      throw error;
    }
  }
}

export default new ApiService();
