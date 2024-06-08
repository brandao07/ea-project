package eaproject.beans;

import eaproject.beans.locals.TrialLocal;
import eaproject.dao.Trial;
import eaproject.dao.TrialDAO;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.GetAllTrialsInput;
import eaproject.input.GetTrialByIdInput;
import eaproject.input.UpdateTrialInput;
import eaproject.output.GetAllTrialsOutput;
import eaproject.output.GetTrialByIdOutput;
import eaproject.output.UpdateTrialOutput;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "TrialEJB")
@Local(TrialLocal.class)
@Component
public class TrialBean implements TrialLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    public UpdateTrialOutput updateTrialEntity(UpdateTrialInput input) {
        // Create a new output object to store the result of the update operation
        UpdateTrialOutput output = new UpdateTrialOutput();
        try {
            // Fetch entity from the database
            Trial type = TrialDAO.getTrialByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (type != null && type.getId() > 0) {
                // Convert object into an entity
                Trial entityToUpdate = Utilities.convertToDAO(input, Trial.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, type);

                // Save the entity to the database using the DAO
                TrialDAO.save(type);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Trial.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Trial.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetTrialByIdOutput getTrialById(GetTrialByIdInput input) {
        GetTrialByIdOutput output = new GetTrialByIdOutput();
        try {
            // Fetch entity from the database
            Trial type = Utilities.fetchEntity(input, input.getId(), TrialDAO::loadTrialByORMID, TrialDAO::getTrialByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (type != null && type.getId() > 0) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, type, GetTrialByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Trial.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllTrialsOutput getAllTrials(GetAllTrialsInput input) {
        GetAllTrialsOutput output = new GetAllTrialsOutput();
        try {
            // Fetch entities from the database
            Trial[] types = TrialDAO.listTrialByQuery(null, null);

            // Check if roles are retrieved successfully
            if (types.length > 0) {
                // Assign retrieved entities to the output object
                output.setTrials(Utilities.convertToDTOArray(types, GetAllTrialsOutput.TrialProperties.class));
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
