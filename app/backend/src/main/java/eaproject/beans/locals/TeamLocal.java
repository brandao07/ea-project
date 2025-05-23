package eaproject.beans.locals;

import javax.ejb.Local;

import eaproject.input.*;
import eaproject.output.*;

@Local
public interface TeamLocal {

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    CreateTeamOutput createTeamEntity(CreateTeamInput input);

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

    
    GetTeamsByTrialIdOutput getTeamsByTrialId(GetTeamsByTrialIdInput input);
}