package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetAllGradesOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private List<GradeProperties> gradeList;

    public List<GradeProperties> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<GradeProperties> gradeList) {
        this.gradeList = gradeList;
    }

    public static class GradeProperties implements Serializable {
        private int id;
        private String name;
        private int minAge;
        private int maxAge;
        private String gender;
        private Timestamp creationDate;

        // Getters and setters
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

        public int getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(int maxAge) {
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
