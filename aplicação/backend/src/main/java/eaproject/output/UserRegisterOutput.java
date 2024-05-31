package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserRegisterOutput extends BaseOutput implements Serializable {
    @JsonProperty
    public boolean registrationSuccessful;

    public void setRegistrationSuccessful(boolean registrationSuccessful) {
        this.registrationSuccessful = registrationSuccessful;
    }
}
