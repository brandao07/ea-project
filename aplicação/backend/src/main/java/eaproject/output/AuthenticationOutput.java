package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationOutput extends BaseOutput {
    private String token;

    @JsonProperty
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
