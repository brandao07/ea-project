package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;

public class GetStateByIdOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private StateProperties state;

    public StateProperties getState() {
        return state;
    }

    public void setState(StateProperties state) {
        this.state = state;
    }

    public static class StateProperties implements Serializable {
        private int id;
        private String name;
        private Timestamp creationDate;

        // Getters e setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
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
}
