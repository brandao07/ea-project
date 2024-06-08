package eaproject.beans.locals;

import javax.ejb.Local;

import eaproject.input.CreateResultInput;
import eaproject.input.GetAllResultsInput;
import eaproject.input.GetResultByIdInput;
import eaproject.input.UpdateResultInput;
import eaproject.output.CreateResultOutput;
import eaproject.output.GetAllResultsOutput;
import eaproject.output.GetResultByIdOutput;
import eaproject.output.UpdateResultOutput;

@Local
public interface ResultLocal {

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    CreateResultOutput createResultEntity(CreateResultInput input);

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateResultOutput updateResultEntity(UpdateResultInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    GetResultByIdOutput getResultById(GetResultByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    GetAllResultsOutput getAllResults(GetAllResultsInput input);
}