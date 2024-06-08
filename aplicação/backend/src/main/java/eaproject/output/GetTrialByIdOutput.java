package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetTrialByIdOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Timestamp startDate;

    @JsonProperty
    private double distance;

    @JsonProperty
    private String distanceUnit;

    @JsonProperty
    private boolean isActive;

    @JsonProperty
    private Timestamp creationDate;

    @JsonProperty
    private StateProperties state;

    @JsonProperty
    private CompetitionProperties competition;

    @JsonProperty
    private GradeProperties grade;

    @JsonProperty
    private TypeProperties type;

    @JsonProperty
    private LocationProperties location;

    @JsonProperty
    private List<ResultProperties> results;

    @JsonProperty
    private List<TeamProperties> teams;

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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
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

    public StateProperties getState() {
        return state;
    }

    public void setState(StateProperties state) {
        this.state = state;
    }

    public CompetitionProperties getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionProperties competition) {
        this.competition = competition;
    }

    public GradeProperties getGrade() {
        return grade;
    }

    public void setGrade(GradeProperties grade) {
        this.grade = grade;
    }

    public TypeProperties getType() {
        return type;
    }

    public void setType(TypeProperties type) {
        this.type = type;
    }

    public LocationProperties getLocation() {
        return location;
    }

    public void setLocation(LocationProperties location) {
        this.location = location;
    }

    public List<ResultProperties> getResults() {
        return results;
    }

    public void setResults(List<ResultProperties> results) {
        this.results = results;
    }

    public List<TeamProperties> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamProperties> teams) {
        this.teams = teams;
    }

    public static class StateProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

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

    public static class CompetitionProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

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

    public static class GradeProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

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

    public static class TypeProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

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

    public static class LocationProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

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

    public static class ResultProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

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

    public static class TeamProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;


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
