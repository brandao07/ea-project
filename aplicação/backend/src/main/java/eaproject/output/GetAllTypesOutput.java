package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetAllTypesOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private List<TypeProperties> typeList;

    public List<TypeProperties> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeProperties> typeList) {
        this.typeList = typeList;
    }

    public static class TypeProperties implements Serializable {
        private int id;
        private String name;
        private int numberOfPersons;
        private Timestamp creationDate;

        // Getters and setters
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

        public int getNumberOfPersons() {
            return numberOfPersons;
        }

        public void setNumberOfPersons(int numberOfPersons) {
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
