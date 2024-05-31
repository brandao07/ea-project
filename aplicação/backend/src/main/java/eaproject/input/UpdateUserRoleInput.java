package eaproject.input;

import java.io.Serializable;

public class UpdateUserRoleInput extends BaseInput implements Serializable {

    private int roleId;
    private int userId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
