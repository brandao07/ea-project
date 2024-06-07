package eaproject.output;

import java.io.Serializable;

public class UpdateTypeOutput extends BaseOutput implements Serializable {

    private boolean updateSuccessful;

    public boolean isUpdateSuccessful() {
        return updateSuccessful;
    }

    public void setUpdateSuccessful(boolean updateSuccessful) {
        this.updateSuccessful = updateSuccessful;
    }
}
