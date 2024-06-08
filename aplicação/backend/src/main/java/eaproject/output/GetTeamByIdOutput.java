package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetTeamByIdOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private boolean isActive;

    @JsonProperty
    private Timestamp creationDate;

    @JsonProperty
    private ClubProperties club;

    @JsonProperty
    private List<UserProperties> users;

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

    public ClubProperties getClub() {
        return club;
    }

    public void setClub(ClubProperties club) {
        this.club = club;
    }

    public List<UserProperties> getUsers() {
        return users;
    }

    public void setUsers(List<UserProperties> users) {
        this.users = users;
    }

    public static class ClubProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

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
    }

    public static class UserProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

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
    }
}
