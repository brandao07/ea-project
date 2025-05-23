package eaproject.beans;

import eaproject.beans.locals.RoleLocal;
import eaproject.beans.locals.UserLocal;
import eaproject.dao.Role;
import eaproject.dao.RoleDAO;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.CreateRoleInput;
import eaproject.input.GetAllRolesInput;
import eaproject.input.GetRoleByIdInput;
import eaproject.input.UpdateRoleInput;
import eaproject.output.CreateRoleOutput;
import eaproject.output.GetAllRolesOutput;
import eaproject.output.GetRoleByIdOutput;
import eaproject.output.UpdateRoleOutput;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "RoleEJB")
@Local(UserLocal.class)
@Component
public class RoleBean implements RoleLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    public CreateRoleOutput createRoleEntity(CreateRoleInput input) {
        // Create a new output object to store the result of the update operation
        CreateRoleOutput output = new CreateRoleOutput();
        try {
            // Convert object into an entity
            Role role = Utilities.convertToDAO(input, Role.class);

            // Save the entity to the database using the DAO
            RoleDAO.save(role);

            // If the save operation is successful, add a success feedback message
            output.addFeedbackMessage(Role.class.getName() + input.getName() + " created successfully.", FeedbackSeverity.SUCCESS);

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
    public UpdateRoleOutput updateRoleEntity(UpdateRoleInput input) {
        // Create a new output object to store the result of the update operation
        UpdateRoleOutput output = new UpdateRoleOutput();
        try {
            // Fetch entity from the database
            Role role = RoleDAO.getRoleByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (role != null && role.getId() > 0) {
                // Convert object into an entity
                Role entityToUpdate = Utilities.convertToDAO(input, Role.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, role);

                // Save the entity to the database using the DAO
                RoleDAO.save(role);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Role.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Role.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetRoleByIdOutput getRoleById(GetRoleByIdInput input) {
        GetRoleByIdOutput output = new GetRoleByIdOutput();
        try {
            // Fetch entity from the database
            Role role = Utilities.fetchEntity(input, input.getId(), RoleDAO::loadRoleByORMID, RoleDAO::getRoleByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (role != null && role.getId() > 0) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, role, GetRoleByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Role.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllRolesOutput getAllRoles(GetAllRolesInput input) {
        GetAllRolesOutput output = new GetAllRolesOutput();
        try {
            // Fetch roles from the database using RoleDAO
            Role[] roles = RoleDAO.listRoleByQuery(null, null);

            // Check if roles are retrieved successfully
            if (roles.length > 0) {
                // Assign retrieved roles to the output object
                output.setRolesList(Utilities.convertToDTOArray(roles, GetAllRolesOutput.RoleProperties.class));
            } else {
                // Add feedback message if no roles are found
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
