const BASE_URL = 'http://localhost:7000/api'; // Adjust based on backend URL

const API_ENDPOINTS = {
    REGISTER: `${BASE_URL}/Register`,
    LOGIN: `${BASE_URL}/Login`,
    BASIC_USER_INFO: `${BASE_URL}/BasicUserInfo`,
    UPDATE_BASIC_USER_INFO: `${BASE_URL}/UpdateBasicUserInfo`,
    GET_ALL_ROLES: `${BASE_URL}/GetAllRoles`,
    UPDATE_CURRENT_USER_ROLE: `${BASE_URL}/UpdateUserCurrentRole`,
    GET_ALL_USERS: `${BASE_URL}/GetAllUsers`
};

export default API_ENDPOINTS;
