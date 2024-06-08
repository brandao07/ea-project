package eaproject.beans.locals;

import javax.ejb.Local;

import eaproject.input.GetAllGradesInput;
import eaproject.input.GetGradeByIdInput;
import eaproject.input.UpdateGradeInput;
import eaproject.output.GetAllGradesOutput;
import eaproject.output.GetGradeByIdOutput;
import eaproject.output.UpdateGradeOutput;

@Local
public interface GradeLocal {
    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateGradeOutput updateGradeEntity(UpdateGradeInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID.
     * @return an output object containing the DTO and any feedback messages.
     */
    GetGradeByIdOutput getGradeById(GetGradeByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types.
     * @return an output object containing the list of objects and feedback messages.
     */
    GetAllGradesOutput getAllGrades(GetAllGradesInput input);
}