package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import eaproject.dao.User;

import java.io.Serializable;

public class GetUsersOutput extends BaseOutput implements Serializable {

    @JsonProperty
    public User[] userArray;

    public User[] getUserArray() {
        return userArray;
    }

    public void setUserArray(User[] userArray) {
        this.userArray = userArray;
    }
}
