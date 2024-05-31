package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UpdateUserInfoOutput extends BaseOutput implements Serializable {

    @JsonProperty
    public boolean updateSuccessful;

    public void setUpdateSuccessful(boolean updateSuccessful) {
        this.updateSuccessful = updateSuccessful;
    }
}
