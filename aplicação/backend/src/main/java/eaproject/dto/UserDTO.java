package eaproject.dto;

import eaproject.dao.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private int userId;
    private String name;
    private String email;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private boolean isActive;
    private String registerDate;

    // Constructor
    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.age = user.getAge();
        this.height = user.getHeight();
        this.weight = user.getWeight();
        this.isActive = user.getIsActive();
        this.registerDate = user.getRegisterDate().toString();
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
