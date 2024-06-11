package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetAllResultsOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<ResultProperties> resultList;

    public ArrayList<ResultProperties> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<ResultProperties> resultList) {
        this.resultList = resultList;
    }

    public static class ResultProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private Integer position;

        @JsonProperty
        private Timestamp time;

        @JsonProperty
        private String observations;

        @JsonProperty
        private Timestamp penaltyTime;

        @JsonProperty
        private Timestamp creationDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public Timestamp getTime() {
            return time;
        }

        public void setTime(Timestamp time) {
            this.time = time;
        }

        public String getObservations() {
            return observations;
        }

        public void setObservations(String observations) {
            this.observations = observations;
        }

        public Timestamp getPenaltyTime() {
            return penaltyTime;
        }

        public void setPenaltyTime(Timestamp penaltyTime) {
            this.penaltyTime = penaltyTime;
        }

        public Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Timestamp creationDate) {
            this.creationDate = creationDate;
        }
    }
}
