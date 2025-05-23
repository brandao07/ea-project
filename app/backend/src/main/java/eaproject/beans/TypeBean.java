package eaproject.beans;

import eaproject.beans.locals.TypeLocal;
import eaproject.dao.Type;
import eaproject.dao.TypeDAO;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.CreateTypeInput;
import eaproject.input.GetAllTypesInput;
import eaproject.input.GetTypeByIdInput;
import eaproject.input.UpdateTypeInput;
import eaproject.output.CreateTypeOutput;
import eaproject.output.GetAllTypesOutput;
import eaproject.output.GetTypeByIdOutput;
import eaproject.output.UpdateTypeOutput;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "TypeEJB")
@Local(TypeLocal.class)
@Component
public class TypeBean implements TypeLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    public CreateTypeOutput createTypeEntity(CreateTypeInput input) {
        // Create a new output object to store the result of the update operation
        CreateTypeOutput output = new CreateTypeOutput();
        try {
            // Convert object into an entity
            Type type = Utilities.convertToDAO(input, Type.class);

            // Save the entity to the database using the DAO
            TypeDAO.save(type);

            // If the save operation is successful, add a success feedback message
            output.addFeedbackMessage(Type.class.getName() + input.getName() + " created successfully.", FeedbackSeverity.SUCCESS);

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
    public UpdateTypeOutput updateTypeEntity(UpdateTypeInput input) {
        // Create a new output object to store the result of the update operation
        UpdateTypeOutput output = new UpdateTypeOutput();
        try {
            // Fetch entity from the database
            Type type = TypeDAO.getTypeByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (type != null && type.getId() > 0) {
                // Convert object into an entity
                Type entityToUpdate = Utilities.convertToDAO(input, Type.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, type);

                // Save the entity to the database using the DAO
                TypeDAO.save(type);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Type.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Type.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetTypeByIdOutput getTypeById(GetTypeByIdInput input) {
        GetTypeByIdOutput output = new GetTypeByIdOutput();
        try {
            // Fetch entity from the database
            Type type = Utilities.fetchEntity(input, input.getId(), TypeDAO::loadTypeByORMID, TypeDAO::getTypeByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (type != null && type.getId() > 0) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, type, GetTypeByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Type.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllTypesOutput getAllTypes(GetAllTypesInput input) {
        GetAllTypesOutput output = new GetAllTypesOutput();
        try {
            // Fetch entities from the database
            Type[] types = TypeDAO.listTypeByQuery(null, null);

            // Check if roles are retrieved successfully
            if (types.length > 0) {
                // Assign retrieved entities to the output object
                output.setTypes(Utilities.convertToDTOArray(types, GetAllTypesOutput.TypeProperties.class));
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
