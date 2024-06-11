package eaproject.input;

import java.io.Serializable;

public class GetTeamByIdInput extends BaseInput implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
