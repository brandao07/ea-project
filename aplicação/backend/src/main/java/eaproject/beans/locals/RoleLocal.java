package eaproject.beans.locals;

import eaproject.input.GetRoleByIdInput;
import eaproject.input.GetAllRolesInput;
import eaproject.input.UpdateRoleInput;
import eaproject.output.GetRoleByIdOutput;
import eaproject.output.GetAllRolesOutput;
import eaproject.output.UpdateRoleOutput;

import javax.ejb.Local;

@Local
public interface RoleLocal {

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateRoleOutput updateRoleEntity(UpdateRoleInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    GetRoleByIdOutput getRoleById(GetRoleByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    GetAllRolesOutput getAllRoles(GetAllRolesInput input);
}