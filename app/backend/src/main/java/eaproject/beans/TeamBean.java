package eaproject.beans;

import eaproject.beans.locals.TeamLocal;
import eaproject.dao.*;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.*;
import eaproject.output.*;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "TeamEJB")
@Local(TeamLocal.class)
@Component
public class TeamBean implements TeamLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    public CreateTeamOutput createTeamEntity(CreateTeamInput input) {
        // Create a new output object to store the result of the update operation
        CreateTeamOutput output = new CreateTeamOutput();
        try {
            // Convert object into an entity
            Team team = Utilities.convertToDAO(input, Team.class);

            // Save the entity to the database using the DAO
            TeamDAO.save(team);

            // If the save operation is successful, add a success feedback message
            output.addFeedbackMessage(Team.class.getName() + input.getName() + " created successfully.", FeedbackSeverity.SUCCESS);

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
    public UpdateTeamOutput updateTeamEntity(UpdateTeamInput input) {
        // Create a new output object to store the result of the update operation
        UpdateTeamOutput output = new UpdateTeamOutput();
        try {
            // Fetch entity from the database
            Team team = TeamDAO.getTeamByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (team != null && team.getId() > 0 && team.getIsActive()) {
                // Convert object into an entity
                Team entityToUpdate = Utilities.convertToDAO(input, Team.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, team);

                // Check for User Relations
                if (!input.getUserIds().isEmpty()) {
                    for (int userId : input.getUserIds()) {
                        User aux = UserDAO.loadUserByORMID(userId);
                        if (aux != null && aux.getId() > 0)  {
                            team.user.add(aux);
                        }
                    }
                }

                // Save the entity to the database using the DAO
                TeamDAO.save(team);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Team.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Team.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetTeamByIdOutput getTeamById(GetTeamByIdInput input) {
        GetTeamByIdOutput output = new GetTeamByIdOutput();
        try {
            // Fetch entity from the database
            Team team = Utilities.fetchEntity(input, input.getId(), TeamDAO::loadTeamByORMID, TeamDAO::getTeamByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (team != null && team.getId() > 0  && team.getIsActive()) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, team, GetTeamByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Team.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllTeamsOutput getAllTeams(GetAllTeamsInput input) {
        GetAllTeamsOutput output = new GetAllTeamsOutput();
        try {
            // Fetch entities from the database
            Team[] teams = TeamDAO.listTeamByQuery(null, null);

            // Check if roles are retrieved successfully
            if (teams.length > 0) {
                // Assign retrieved entities to the output object
                output.setTeamList(Utilities.convertToDTOArray(teams, GetAllTeamsOutput.TeamProperties.class));
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

    public GetTeamsByTrialIdOutput getTeamsByTrialId(GetTeamsByTrialIdInput input) {
        GetTeamsByTrialIdOutput output = new GetTeamsByTrialIdOutput();
        try {
            Trial trial = TrialDAO.getTrialByORMID(input.getId());

            // Fetch entities from the database
            Team[] teams = trial.team.toArray();

            // Check if roles are retrieved successfully
            if (teams.length > 0) {
                // Assign retrieved entities to the output object
                output.setTeamList(Utilities.convertToDTOArray(teams, GetTeamsByTrialIdOutput.TeamProperties.class));
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

    public GetTeamsByClubIdOutput getTeamsByClubId(GetTeamsByClubIdInput input) {
        GetTeamsByClubIdOutput output = new GetTeamsByClubIdOutput();
        try {
            String condition = "clubid = " + input.getId();
            Team[] teams = TeamDAO.listTeamByQuery(condition, null);
            // Check if roles are retrieved successfully
            if (teams.length > 0) {
                // Assign retrieved entities to the output object
                output.setTeamList(Utilities.convertToDTOArray(teams, GetTeamsByTrialIdOutput.TeamProperties.class));
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
