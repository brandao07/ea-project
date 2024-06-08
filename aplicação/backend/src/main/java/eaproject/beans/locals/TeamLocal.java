package eaproject.beans.locals;

import javax.ejb.Local;

import eaproject.input.GetAllTeamsInput;
import eaproject.input.GetTeamByIdInput;
import eaproject.input.UpdateTeamInput;
import eaproject.output.GetAllTeamsOutput;
import eaproject.output.GetTeamByIdOutput;
import eaproject.output.UpdateTeamOutput;

@Local
public interface TeamLocal {
    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateTeamOutput updateTeamEntity(UpdateTeamInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    GetTeamByIdOutput getTeamById(GetTeamByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    GetAllTeamsOutput getAllTeams(GetAllTeamsInput input);
}