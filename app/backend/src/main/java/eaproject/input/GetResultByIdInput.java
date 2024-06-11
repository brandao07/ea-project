package eaproject.input;

import java.io.Serializable;

public class GetResultByIdInput extends BaseInput implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
