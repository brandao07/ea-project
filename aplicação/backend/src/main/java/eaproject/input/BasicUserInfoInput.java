package eaproject.input;

import java.io.Serializable;

public class BasicUserInfoInput extends BaseInput implements Serializable {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
