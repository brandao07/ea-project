package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationOutput extends BaseOutput {

    @JsonProperty
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() { return token; }
}
