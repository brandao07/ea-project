package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GetAllTrialsOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<TrialProperties> trials;

    public ArrayList<TrialProperties> getTrials() {
        return trials;
    }

    public void setTrials(ArrayList<TrialProperties> trials) {
        this.trials = trials;
    }

    public static class TrialProperties implements Serializable {

        @JsonProperty
        private Integer id;

        @JsonProperty
        private String name;

        @JsonProperty
        private Timestamp startDate;

        @JsonProperty
        private Double distance;

        @JsonProperty
        private String distanceUnit;

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

        public Double getDistance() {
            return distance;
        }

        public void setDistance(Double distance) {
            this.distance = distance;
        }

        public String getDistanceUnit() {
            return distanceUnit;
        }

        public void setDistanceUnit(String distanceUnit) {
            this.distanceUnit = distanceUnit;
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
