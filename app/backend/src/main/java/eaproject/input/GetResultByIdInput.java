package eaproject.input;

import java.io.Serializable;

public class GetResultByIdInput extends BaseInput implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
