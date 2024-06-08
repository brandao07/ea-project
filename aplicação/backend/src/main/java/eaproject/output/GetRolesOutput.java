package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetRolesOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<RoleProperties> rolesList;

    public ArrayList<RoleProperties> getRolesList() {
        return rolesList;
    }

    public void setRolesList(ArrayList<RoleProperties> rolesList) {
        this.rolesList = rolesList;
    }

    public static class RoleProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

        @JsonProperty
        private String description;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Timestamp creationDate) {
            this.creationDate = creationDate;
        }
    }
}
