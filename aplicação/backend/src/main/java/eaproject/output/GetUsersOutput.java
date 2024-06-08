package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetUsersOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private List<UserProperties> usersList;

    public List<UserProperties> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<UserProperties> usersList) {
        this.usersList = usersList;
    }

    public static class UserProperties implements Serializable {
        private int id;
        private String name;
        private String email;
        private String gender;
        private int age;
        private double height;
        private double weight;
        private Timestamp registerDate;
        private String photographyPath;
        
        public int getId() {
            return id;
        }

        public void setId(int id) { this.id = id; }
        
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
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
    }
}
