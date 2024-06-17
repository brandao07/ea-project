package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetCompetitionByIdOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<GetAllTrialsOutput.TrialProperties> trials;

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

    public ArrayList<GetAllTrialsOutput.TrialProperties> getTrials() {
        return trials;
    }

    public void setTrials(ArrayList<GetAllTrialsOutput.TrialProperties> trials) {
        this.trials = trials;
    }

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
