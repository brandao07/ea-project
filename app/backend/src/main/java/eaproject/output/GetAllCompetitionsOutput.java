package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetAllCompetitionsOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<CompetitionProperties> competitionList;

    public ArrayList<CompetitionProperties> getCompetitionList() {
        return competitionList;
    }

    public void setCompetitionList(ArrayList<CompetitionProperties> competitionList) {
        this.competitionList = competitionList;
    }

    public static class CompetitionProperties implements Serializable {

        @JsonProperty
        private Integer id;

        @JsonProperty
        private String name;

        @JsonProperty
        private Timestamp startDate;

        @JsonProperty
        private Timestamp endDate;

        @JsonProperty
        private boolean isActive;

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

        public Timestamp getStartDate() {
            return startDate;
        }

        public void setStartDate(Timestamp startDate) {
            this.startDate = startDate;
        }

        public Timestamp getEndDate() {
            return endDate;
        }

        public void setEndDate(Timestamp endDate) {
            this.endDate = endDate;
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
