package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BasicUserInfoOutput extends BaseOutput implements Serializable {

    @JsonProperty
    public String name;

    @JsonProperty
    public String email;

    @JsonProperty
    public String gender;

    @JsonProperty
    public int age;

    @JsonProperty
    public double height;

    @JsonProperty
    public double weight;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
