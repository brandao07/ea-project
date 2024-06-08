package eaproject.beans.locals;

import eaproject.input.GetAllClubsInput;
import eaproject.input.GetClubByIdInput;
import eaproject.input.UpdateClubInput;
import eaproject.output.GetAllClubsOutput;
import eaproject.output.GetClubByIdOutput;
import eaproject.output.UpdateClubOutput;

import javax.ejb.Local;

@Local
public interface ClubLocal {
    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateClubOutput updateClubEntity(UpdateClubInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    GetClubByIdOutput getClubById(GetClubByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    GetAllClubsOutput getAllClubs(GetAllClubsInput input);
}