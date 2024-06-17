package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationOutput extends BaseOutput {

    @JsonProperty
    private String token;
    @JsonProperty
    private String role;
    @JsonProperty
    private int userId;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() { return token; }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
