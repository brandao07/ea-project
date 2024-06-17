import ApiService from "@/services/ApiService";
import {
  setLocalStorageItems,
  removeLocalStorageItems,
} from "@/utils/storageUtils";
import { StorageKeys } from "@/constants/storageKeys";

class AuthService {
  /**
   * Authenticates a user, stores the token and claims in localStorage, and redirects
   * @param {string} token - The JWT token
   * @param {object} router - The Vue router instance to handle redirection
   */
  login(token,userId,role, router) {
    // Import JWT Decode
    const jwt_decode = require("jwt-decode");

    // Decode the token to get the claims
    const decodedToken = jwt_decode.jwtDecode(token);

    // Store the token and claims in localStorage
    setLocalStorageItems({
      [StorageKeys.JWT_TOKEN]: token,
      [StorageKeys.NAME]: decodedToken.name,
      [StorageKeys.IS_ACTIVE]: decodedToken.isActive,
      [StorageKeys.REGISTER_DATE]: decodedToken.registerDate,
      [StorageKeys.PHOTO]: decodedToken.photo,
      [StorageKeys.ID_USER]: userId,
      [StorageKeys.ROLE]: role,
    });

    // Set the token in ApiService
    ApiService.setToken(token);

    // Redirect to home page or any other page
    router.push("/");
  }


  /**
   * Logs out the user by clearing localStorage and redirecting to the login page
   * @param {object} router - The Vue router instance to handle redirection
   */
  logout(router) {
    // Remove the token and claims from localStorage
    removeLocalStorageItems([
      StorageKeys.JWT_TOKEN,
      StorageKeys.ID_USER,
      StorageKeys.NAME,
      StorageKeys.IS_ACTIVE,
      StorageKeys.REGISTER_DATE,
      StorageKeys.PHOTO,
      StorageKeys.ROLE,
    ]);

    // Clear the token in ApiService
    ApiService.clearToken();

    // Redirect to login page
    router.push("/login");
  }
}

export default new AuthService();
