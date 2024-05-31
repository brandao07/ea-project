package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import eaproject.dao.Role;

import java.io.Serializable;

public class GetRolesOutput extends BaseOutput implements Serializable {

    @JsonProperty
    public Role[] rolesArray;

    public Role[] getRolesArray() {
        return rolesArray;
    }

    public void setRolesArray(Role[] rolesArray) {
        this.rolesArray = rolesArray;
    }
}
