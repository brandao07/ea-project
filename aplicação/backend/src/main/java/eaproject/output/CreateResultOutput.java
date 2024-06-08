package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CreateResultOutput extends BaseOutput implements Serializable {
    @JsonProperty
    private boolean updateSuccessful;

    public boolean isUpdateSuccessful() {
        return updateSuccessful;
    }

    public void setUpdateSuccessful(boolean updateSuccessful) {
        this.updateSuccessful = updateSuccessful;
    }
}
