package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GetUserByIdOutput extends BaseOutput implements Serializable {

    @JsonProperty
    public String name;

    @JsonProperty
    public String email;

    @JsonProperty
    public String gender;

    @JsonProperty
    public Integer age;

    @JsonProperty
    public Double height;

    @JsonProperty
    public Double weight;

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
}
