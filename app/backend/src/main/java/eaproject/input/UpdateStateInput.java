package eaproject.input;

import java.io.Serializable;
import java.sql.Timestamp;

public class UpdateStateInput extends BaseInput implements Serializable {

    private Integer id;
    private String name;
    private Timestamp creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
