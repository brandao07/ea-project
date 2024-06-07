package eaproject.output;

import java.io.Serializable;
import java.util.List;

public class UpdateTeamOutput extends BaseOutput implements Serializable {

    private boolean updateSuccessful;
    private TeamProperties team; // Propriedades da Team atualizadas

    public boolean isUpdateSuccessful() {
        return updateSuccessful;
    }

    public void setUpdateSuccessful(boolean updateSuccessful) {
        this.updateSuccessful = updateSuccessful;
    }

    public TeamProperties getTeam() {
        return team;
    }

    public void setTeam(TeamProperties team) {
        this.team = team;
    }

    public static class TeamProperties implements Serializable {
        private int id;
        private String name;
        private boolean isActive;
        private java.sql.Timestamp creationDate;
        private ClubProperties club; // LAZY
        private List<UserProperties> users; // LAZY

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

        public boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }

        public java.sql.Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(java.sql.Timestamp creationDate) {
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
    }

    public static class ClubProperties implements Serializable {
        private int id;
        private String name;

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
    }

    public static class UserProperties implements Serializable {
        private int id;
        private String name;

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
    }
}
