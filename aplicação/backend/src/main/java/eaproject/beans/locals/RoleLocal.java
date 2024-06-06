package eaproject.beans.locals;

import eaproject.output.*;
import eaproject.input.GetRolesInput;

import javax.ejb.Local;

@Local
public interface RoleLocal {

    /**
     * Retrieves all roles from the database and returns them in a GetRolesOutput object.
     *
     * @param rolesInput A GetRolesInput object containing any input parameters needed for fetching roles.
     * @return An object containing the roles retrieved from the database.
     */
    GetRolesOutput getAllRoles(GetRolesInput rolesInput);
}