package eaproject.input;

import java.io.Serializable;
import java.sql.Timestamp;

public class UpdateResultInput extends BaseInput implements Serializable {

    private int id;
    private Integer position;
    private Timestamp time;
    private String observations;
    private Timestamp penaltyTime;
    private Timestamp creationDate;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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
