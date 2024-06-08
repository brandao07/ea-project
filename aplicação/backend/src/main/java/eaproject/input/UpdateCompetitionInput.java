package eaproject.input;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class UpdateCompetitionInput extends BaseInput implements Serializable {

    private int id;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private boolean isActive;
    private Timestamp creationDate;
    private List<Integer> notificationIds;

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

    public List<Integer> getNotificationIds() {
        return notificationIds;
    }

    public void setNotificationIds(List<Integer> notificationIds) {
        this.notificationIds = notificationIds;
    }
}
