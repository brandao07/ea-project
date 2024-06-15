package eaproject.input;

import java.io.Serializable;
import java.sql.Timestamp;

public class CreateClubInput extends BaseInput implements Serializable {

    private String name;
    private boolean isActive;
    private Timestamp creationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
