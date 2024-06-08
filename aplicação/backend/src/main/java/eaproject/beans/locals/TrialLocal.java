package eaproject.beans.locals;

import javax.ejb.Local;

import eaproject.input.GetAllTrialsInput;
import eaproject.input.GetTrialByIdInput;
import eaproject.input.UpdateTrialInput;
import eaproject.output.GetAllTrialsOutput;
import eaproject.output.GetTrialByIdOutput;
import eaproject.output.UpdateTrialOutput;

@Local
public interface TrialLocal {

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateTrialOutput updateTrialEntity(UpdateTrialInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    GetTrialByIdOutput getTrialById(GetTrialByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    GetAllTrialsOutput getAllTrials(GetAllTrialsInput input);
}