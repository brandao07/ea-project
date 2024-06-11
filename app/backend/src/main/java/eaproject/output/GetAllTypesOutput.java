package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetAllTypesOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<TypeProperties> types;

    public ArrayList<TypeProperties> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<TypeProperties> types) {
        this.types = types;
    }

    public static class TypeProperties implements Serializable {
        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

        @JsonProperty
        private Integer numberOfPersons;

        @JsonProperty
        private Timestamp creationDate;

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

        public Integer getNumberOfPersons() {
            return numberOfPersons;
        }

        public void setNumberOfPersons(Integer numberOfPersons) {
            this.numberOfPersons = numberOfPersons;
        }

        public Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Timestamp creationDate) {
            this.creationDate = creationDate;
        }
    }
}
