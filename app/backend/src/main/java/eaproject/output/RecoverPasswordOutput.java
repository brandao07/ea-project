package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecoverPasswordOutput extends BaseOutput {
    @JsonProperty
    private boolean successful;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
