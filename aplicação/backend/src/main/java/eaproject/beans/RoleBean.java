package eaproject.beans;

import eaproject.beans.locals.RoleLocal;
import eaproject.beans.locals.UserLocal;
import eaproject.dao.Role;
import eaproject.dao.RoleDAO;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.GetRolesInput;
import eaproject.output.GetRolesOutput;
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
     * Retrieves all roles from the database and returns them in a GetRolesOutput object.
     *
     * @param rolesInput A GetRolesInput object containing any input parameters needed for fetching roles.
     * @return An object containing the roles retrieved from the database.
     */
    public GetRolesOutput getAllRoles(GetRolesInput rolesInput) {
        GetRolesOutput output = new GetRolesOutput();
        try {
            // Fetch roles from the database using RoleDAO
            Role[] roles = RoleDAO.listRoleByQuery(null, null);

            // Check if roles are retrieved successfully
            if (roles.length > 0) {
                // Assign retrieved roles to the output object
                output.setRolesList(Utilities.convertToDTOArray(roles, GetRolesOutput.RoleProperties.class));
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
