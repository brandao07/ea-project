package eaproject.beans.locals;

import javax.ejb.Local;

import eaproject.input.CreateCompetitionInput;
import eaproject.input.GetAllCompetitionsInput;
import eaproject.input.GetCompetitionByIdInput;
import eaproject.input.UpdateCompetitionInput;
import eaproject.output.CreateCompetitionOutput;
import eaproject.output.GetAllCompetitionsOutput;
import eaproject.output.GetCompetitionByIdOutput;
import eaproject.output.UpdateCompetitionOutput;

@Local
public interface CompetitionLocal {

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    CreateCompetitionOutput createCompetitionEntity(CreateCompetitionInput input);

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateCompetitionOutput updateCompetitionEntity(UpdateCompetitionInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    GetCompetitionByIdOutput getCompetitionById(GetCompetitionByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    GetAllCompetitionsOutput getAllCompetitions(GetAllCompetitionsInput input);
}