package eaproject.beans.locals;

import eaproject.input.CreateLocationInput;
import eaproject.input.GetAllLocationsInput;
import eaproject.input.GetLocationByIdInput;
import eaproject.input.UpdateLocationInput;
import eaproject.output.CreateLocationOutput;
import eaproject.output.GetAllLocationsOutput;
import eaproject.output.GetLocationByIdOutput;
import eaproject.output.UpdateLocationOutput;

import javax.ejb.Local;

@Local
public interface LocationLocal {

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    CreateLocationOutput createLocationEntity(CreateLocationInput input);

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateLocationOutput updateLocationEntity(UpdateLocationInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    GetLocationByIdOutput getLocationById(GetLocationByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    GetAllLocationsOutput getAllLocations(GetAllLocationsInput input);
}