package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetAllStatesOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<StateProperties> stateList;

    public ArrayList<StateProperties> getStateList() {
        return stateList;
    }

    public void setStateList(ArrayList<StateProperties> stateList) {
        this.stateList = stateList;
    }

    public static class StateProperties implements Serializable {

        @JsonProperty
        private Integer id;

        @JsonProperty
        private String name;

        @JsonProperty
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
}
