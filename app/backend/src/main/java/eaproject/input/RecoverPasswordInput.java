package eaproject.input;

import java.io.Serializable;

public class RecoverPasswordInput extends BaseInput implements Serializable {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
