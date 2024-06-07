package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetAllResultsOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private List<ResultProperties> resultList;

    public List<ResultProperties> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultProperties> resultList) {
        this.resultList = resultList;
    }

    public static class ResultProperties implements Serializable {
        private int id;
        private int position;
        private Timestamp time;
        private String observations;
        private Timestamp penaltyTime;
        private Timestamp creationDate;

        // Getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
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
