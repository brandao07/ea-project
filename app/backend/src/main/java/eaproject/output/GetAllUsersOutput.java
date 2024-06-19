package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetAllUsersOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<UserProperties> usersList;

    public ArrayList<UserProperties> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<UserProperties> usersList) {
        this.usersList = usersList;
    }

    public static class UserProperties implements Serializable {
        private Integer id;
        private String name;
        private String email;
        private String gender;
        private Integer age;
        private Double height;
        private Integer clubid;
        private Double weight;
        private Timestamp registerDate;
        private String photographyPath;
        
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) { this.id = id; }
        
        public String getName() { return name; }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public Timestamp getRegisterDate() {
            return registerDate;
        }

        public void setRegisterDate(Timestamp registerDate) {
            this.registerDate = registerDate;
        }

        public String getPhotographyPath() {
            return photographyPath;
        }

        public void setPhotographyPath(String photographyPath) {
            this.photographyPath = photographyPath;
        }

        public Integer getClubid() {
            return clubid;
        }

        public void setClubid(Integer clubid) {
            this.clubid = clubid;
        }
    }
}
