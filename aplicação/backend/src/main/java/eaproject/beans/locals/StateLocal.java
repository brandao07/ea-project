package eaproject.beans.locals;

import javax.ejb.Local;

import eaproject.input.GetAllStatesInput;
import eaproject.input.GetStateByIdInput;
import eaproject.input.UpdateStateInput;
import eaproject.output.GetAllStatesOutput;
import eaproject.output.GetStateByIdOutput;
import eaproject.output.UpdateStateOutput;

@Local
public interface StateLocal {

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateStateOutput updateStateEntity(UpdateStateInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID.
     * @return an output object containing the DTO and any feedback messages.
     */
    GetStateByIdOutput getStateById(GetStateByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types.
     * @return an output object containing the list of objects and feedback messages.
     */
    GetAllStatesOutput getAllStates(GetAllStatesInput input);
}