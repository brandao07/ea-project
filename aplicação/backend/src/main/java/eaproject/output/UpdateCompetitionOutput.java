package eaproject.output;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class UpdateCompetitionOutput extends BaseOutput implements Serializable {

    private boolean updateSuccessful;

    public boolean isUpdateSuccessful() {
        return updateSuccessful;
    }

    public void setUpdateSuccessful(boolean updateSuccessful) {
        this.updateSuccessful = updateSuccessful;
    }
}
