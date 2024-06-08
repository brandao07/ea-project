package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetAllGradesOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<GradeProperties> gradeList;

    public ArrayList<GradeProperties> getGradeList() {
        return gradeList;
    }

    public void setGradeList(ArrayList<GradeProperties> gradeList) {
        this.gradeList = gradeList;
    }

    public static class GradeProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

        @JsonProperty
        private int minAge;

        @JsonProperty
        private Integer maxAge;

        @JsonProperty
        private String gender;

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

        public int getMinAge() {
            return minAge;
        }

        public void setMinAge(int minAge) {
            this.minAge = minAge;
        }

        public Integer getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(Integer maxAge) {
            this.maxAge = maxAge;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Timestamp creationDate) {
            this.creationDate = creationDate;
        }
    }
}
