package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserRegisterOutput extends BaseOutput implements Serializable {
    public boolean registrationSuccessful;

    @JsonProperty
    public boolean isRegistrationSuccessful() {
        return registrationSuccessful;
    }

    public void setRegistrationSuccessful(boolean registrationSuccessful) {
        this.registrationSuccessful = registrationSuccessful;
    }
}
