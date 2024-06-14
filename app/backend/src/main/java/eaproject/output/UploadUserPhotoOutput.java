package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UploadUserPhotoOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private String token;

    @JsonProperty
    private boolean updateSuccessful;

    public boolean isUpdateSuccessful() {
        return updateSuccessful;
    }

    public void setUpdateSuccessful(boolean updateSuccessful) {
        this.updateSuccessful = updateSuccessful;
    }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }
}
