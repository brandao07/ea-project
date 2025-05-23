package eaproject.beans;

import eaproject.beans.locals.GradeLocal;
import eaproject.dao.Grade;
import eaproject.dao.GradeDAO;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.CreateGradeInput;
import eaproject.input.GetAllGradesInput;
import eaproject.input.GetGradeByIdInput;
import eaproject.input.UpdateGradeInput;
import eaproject.output.CreateGradeOutput;
import eaproject.output.GetAllGradesOutput;
import eaproject.output.GetGradeByIdOutput;
import eaproject.output.UpdateGradeOutput;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "GradeEJB")
@Local(GradeLocal.class)
@Component
public class GradeBean implements GradeLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    public CreateGradeOutput createGradeEntity(CreateGradeInput input) {
        // Create a new output object to store the result of the update operation
        CreateGradeOutput output = new CreateGradeOutput();
        try {
            // Convert object into an entity
            Grade grade = Utilities.convertToDAO(input, Grade.class);

            // Save the entity to the database using the DAO
            GradeDAO.save(grade);

            // If the save operation is successful, add a success feedback message
            output.addFeedbackMessage(Grade.class.getName() + input.getName() + " created successfully.", FeedbackSeverity.SUCCESS);

            // Indicate that the update was successful
            output.setUpdateSuccessful(true);
        } catch (BadCredentialsException e) {
            // If a BadCredentialsException is caught, add a danger feedback message with the exception message
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            // If a PersistentException is caught, add a danger feedback message indicating a database access error
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            // If any other exception is caught, add a danger feedback message indicating an unexpected error
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        // Return the output object with the result of the update operation
        return output;
    }

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    public UpdateGradeOutput updateGradeEntity(UpdateGradeInput input) {
        // Create a new output object to store the result of the update operation
        UpdateGradeOutput output = new UpdateGradeOutput();
        try {
            // Fetch entity from the database
            Grade grade = GradeDAO.getGradeByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (grade != null && grade.getId() > 0) {
                // Convert object into an entity
                Grade entityToUpdate = Utilities.convertToDAO(input, Grade.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, grade);

                // Save the entity to the database using the DAO
                GradeDAO.save(grade);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Grade.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Grade.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
            }
        } catch (BadCredentialsException e) {
            // If a BadCredentialsException is caught, add a danger feedback message with the exception message
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            // If a PersistentException is caught, add a danger feedback message indicating a database access error
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            // If any other exception is caught, add a danger feedback message indicating an unexpected error
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        // Return the output object with the result of the update operation
        return output;
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    public GetGradeByIdOutput getGradeById(GetGradeByIdInput input) {
        GetGradeByIdOutput output = new GetGradeByIdOutput();
        try {
            // Fetch entity from the database
            Grade grade = Utilities.fetchEntity(input, input.getId(), GradeDAO::loadGradeByORMID, GradeDAO::getGradeByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (grade != null && grade.getId() > 0) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, grade, GetGradeByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Grade.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
            }
        } catch (BadCredentialsException e) {
            // Add feedback message for bad credentials
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            // Add feedback message for database access error
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            // Add feedback message for unexpected errors
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        // Return the output object with roles and feedback messages
        return output;
    }

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    public GetAllGradesOutput getAllGrades(GetAllGradesInput input) {
        GetAllGradesOutput output = new GetAllGradesOutput();
        try {
            // Fetch entities from the database
            Grade[] grades = GradeDAO.listGradeByQuery(null, null);

            // Check if roles are retrieved successfully
            if (grades.length > 0) {
                // Assign retrieved entities to the output object
                output.setGradeList(Utilities.convertToDTOArray(grades, GetAllGradesOutput.GradeProperties.class));
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage("No roles found in our database.", FeedbackSeverity.DANGER);
            }
        } catch (BadCredentialsException e) {
            // Add feedback message for bad credentials
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        } catch (PersistentException e) {
            // Add feedback message for database access error
            output.addFeedbackMessage("An error occurred while accessing the database", FeedbackSeverity.DANGER);
        } catch (Exception e) {
            // Add feedback message for unexpected errors
            output.addFeedbackMessage("An unexpected error occurred", FeedbackSeverity.DANGER);
        }
        // Return the output object with roles and feedback messages
        return output;
    }
}
