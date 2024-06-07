package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;

public class GetClubByIdOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ClubProperties club;

    public ClubProperties getClub() {
        return club;
    }

    public void setClub(ClubProperties club) {
        this.club = club;
    }

    public static class ClubProperties implements Serializable {
        private int id;
        private String name;
        private boolean isActive;
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
}
