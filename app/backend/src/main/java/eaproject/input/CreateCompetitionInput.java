package eaproject.input;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CreateCompetitionInput extends BaseInput implements Serializable {

    private String name;
    private String grade;
    private String type;
    private String gender;
    private int userId;
    private Timestamp startDate;
    private Timestamp endDate;
    private boolean isActive;
    private Timestamp creationDate;
    private ArrayList<CreateTrialInput> trialList;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public ArrayList<CreateTrialInput> getTrialList() {
        return trialList;
    }

    public void setTrialList(ArrayList<CreateTrialInput> trialList) {
        this.trialList = trialList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
