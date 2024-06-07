package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetAllStateOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private List<StateProperties> stateList;

    public List<StateProperties> getStateList() {
        return stateList;
    }

    public void setStateList(List<StateProperties> stateList) {
        this.stateList = stateList;
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
