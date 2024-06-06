package eaproject.input;

import java.io.Serializable;

public class BasicUserInfoInput extends BaseInput implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
