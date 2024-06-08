package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationOutput extends BaseOutput {

    @JsonProperty
    public String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() { return token; }
}
