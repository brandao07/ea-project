import ApiService from "@/services/ApiService";

class AuthService {
  /**
   * Authenticates a user, stores the token and claims in localStorage, and redirects
   * @param {string} token - The JWT token
   * @param {object} router - The Vue router instance to handle redirection
   */
  login(token, router) {
    // Store the token
    localStorage.setItem("jwt-token", token);
    ApiService.setToken(token); // Set the token in ApiService

    // Import JWT Decode
    const jwt_decode = require('jwt-decode');

    // Decode the token to get the claims
    const decodedToken = jwt_decode.jwtDecode(token);

    // Store each claim separately in localStorage or sessionStorage
    localStorage.setItem('idUser', decodedToken.idUser);
    localStorage.setItem('name', decodedToken.name);
    localStorage.setItem('isActive', decodedToken.isActive);
    localStorage.setItem('registerDate', decodedToken.registerDate);
    localStorage.setItem('picture', decodedToken.picture);
    localStorage.setItem('role', decodedToken.role);

    // Redirect to home page or any other page
    router.push("/");
  }

  /**
   * Logs out the user by clearing localStorage and redirecting to the login page
   * @param {object} router - The Vue router instance to handle redirection
   */
  logout(router) {
    // Clear localStorage
    localStorage.removeItem("jwt-token");
    localStorage.removeItem("idUser");
    localStorage.removeItem("name");
    localStorage.removeItem("isActive");
    localStorage.removeItem("registerDate");
    localStorage.removeItem("picture");
    localStorage.removeItem("role");
    ApiService.clearToken(); // Clear the token in ApiService

    // Redirect to login page
    router.push("/login");
  }
}

export default new AuthService();
