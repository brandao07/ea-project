package eaproject.beans;

import eaproject.beans.locals.ClubLocal;
import eaproject.dao.Club;
import eaproject.dao.ClubDAO;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.GetAllClubsInput;
import eaproject.input.GetClubByIdInput;
import eaproject.input.UpdateClubInput;
import eaproject.output.GetAllClubsOutput;
import eaproject.output.GetClubByIdOutput;
import eaproject.output.UpdateClubOutput;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "ClubEJB")
@Local(ClubLocal.class)
@Component
public class ClubBean implements ClubLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    public UpdateClubOutput updateClubEntity(UpdateClubInput input) {
        // Create a new output object to store the result of the update operation
        UpdateClubOutput output = new UpdateClubOutput();
        try {
            // Fetch entity from the database
            Club club = ClubDAO.getClubByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (club != null && club.getId() > 0 && club.getIsActive()) {
                // Convert object into an entity
                Club entityToUpdate = Utilities.convertToDAO(input, Club.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, club);

                // Save the entity to the database using the DAO
                ClubDAO.save(club);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Club.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Club.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetClubByIdOutput getClubById(GetClubByIdInput input) {
        GetClubByIdOutput output = new GetClubByIdOutput();
        try {
            // Fetch entity from the database
            Club club = Utilities.fetchEntity(input, input.getId(), ClubDAO::loadClubByORMID, ClubDAO::getClubByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (club != null && club.getId() > 0 && club.getIsActive()) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, club, GetClubByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Club.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllClubsOutput getAllClubs(GetAllClubsInput input) {
        GetAllClubsOutput output = new GetAllClubsOutput();
        try {
            // Fetch entities from the database
            Club[] clubs = ClubDAO.listClubByQuery(null, null);

            // Check if roles are retrieved successfully
            if (clubs.length > 0) {
                // Assign retrieved entities to the output object
                output.setClubList(Utilities.convertToDTOArray(clubs, GetAllClubsOutput.ClubProperties.class));
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
