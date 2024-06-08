package eaproject.beans;

import eaproject.beans.locals.StateLocal;
import eaproject.dao.State;
import eaproject.dao.StateDAO;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.GetAllStatesInput;
import eaproject.input.GetStateByIdInput;
import eaproject.input.UpdateStateInput;
import eaproject.output.GetAllStatesOutput;
import eaproject.output.GetStateByIdOutput;
import eaproject.output.UpdateStateOutput;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "StateEJB")
@Local(StateLocal.class)
@Component
public class StateBean implements StateLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    public UpdateStateOutput updateStateEntity(UpdateStateInput input) {
        // Create a new output object to store the result of the update operation
        UpdateStateOutput output = new UpdateStateOutput();
        try {
            // Fetch entity from the database
            State state = StateDAO.getStateByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (state != null && state.getId() > 0) {
                // Convert object into an entity
                State entityToUpdate = Utilities.convertToDAO(input, State.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, state);

                // Save the entity to the database using the DAO
                StateDAO.save(state);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(State.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(State.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetStateByIdOutput getStateById(GetStateByIdInput input) {
        GetStateByIdOutput output = new GetStateByIdOutput();
        try {
            // Fetch entity from the database
            State state = Utilities.fetchEntity(input, input.getId(), StateDAO::loadStateByORMID, StateDAO::getStateByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (state != null && state.getId() > 0) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, state, GetStateByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(State.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllStatesOutput getAllStates(GetAllStatesInput input) {
        GetAllStatesOutput output = new GetAllStatesOutput();
        try {
            // Fetch entities from the database
            State[] state = StateDAO.listStateByQuery(null, null);

            // Check if roles are retrieved successfully
            if (state.length > 0) {
                // Assign retrieved entities to the output object
                output.setStateList(Utilities.convertToDTOArray(state, GetAllStatesOutput.StateProperties.class));
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
