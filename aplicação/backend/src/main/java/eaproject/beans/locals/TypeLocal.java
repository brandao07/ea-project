package eaproject.beans.locals;

import eaproject.input.CreateTypeInput;
import eaproject.input.GetAllTypesInput;
import eaproject.input.GetTypeByIdInput;
import eaproject.input.UpdateTypeInput;
import eaproject.output.CreateTypeOutput;
import eaproject.output.GetAllTypesOutput;
import eaproject.output.GetTypeByIdOutput;
import eaproject.output.UpdateTypeOutput;

import javax.ejb.Local;

@Local
public interface TypeLocal {

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    CreateTypeOutput createTypeEntity(CreateTypeInput input);

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateTypeOutput updateTypeEntity(UpdateTypeInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input The input object containing parameters for fetching the entity by ID.
     * @return An output object containing the DTO and any feedback messages.
     */
    GetTypeByIdOutput getTypeById(GetTypeByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    GetAllTypesOutput getAllTypes(GetAllTypesInput input);
}