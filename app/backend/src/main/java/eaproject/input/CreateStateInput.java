package eaproject.input;

import java.io.Serializable;
import java.sql.Timestamp;

public class CreateStateInput extends BaseInput implements Serializable {

    private String name;
    private Timestamp creationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
