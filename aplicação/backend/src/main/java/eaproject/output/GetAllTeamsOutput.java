package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetAllTeamsOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private List<TeamProperties> teamList;

    public List<TeamProperties> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TeamProperties> teamList) {
        this.teamList = teamList;
    }

    public static class TeamProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

        @JsonProperty
        private boolean isActive;

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
