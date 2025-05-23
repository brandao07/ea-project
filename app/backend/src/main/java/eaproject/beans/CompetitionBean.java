package eaproject.beans;

import eaproject.beans.locals.CompetitionLocal;
import eaproject.dao.*;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.CreateCompetitionInput;
import eaproject.input.GetAllCompetitionsInput;
import eaproject.input.GetCompetitionByIdInput;
import eaproject.input.UpdateCompetitionInput;
import eaproject.output.*;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless(name = "CompetitionEJB")
@Local(CompetitionLocal.class)
@Component
public class CompetitionBean implements CompetitionLocal {

    @Autowired
    TrialBean trialBean;

    @PostConstruct
    public void init() {
    }

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    public CreateCompetitionOutput createCompetitionEntity(CreateCompetitionInput input) {
        // Create a new output object to store the result of the update operation
        CreateCompetitionOutput output = new CreateCompetitionOutput();
        try {
            // Convert object into an entity
            Competition competition = Utilities.convertToDAO(input, Competition.class);

            var typeCondition = "name = '" + input.getType() + "'";
            Type type = TypeDAO.loadTypeByQuery(typeCondition, null);
            competition.setType(type);

            var gradeCondition = "name = '" + input.getGrade() + "'";
            Grade grade = GradeDAO.loadGradeByQuery(gradeCondition, null);
            competition.setGrade(grade);

            var userCondition = "id = '" + input.getUserId() + "'";
            User user = UserDAO.loadUserByQuery(userCondition, null);
            competition.setUser(user);

            // Save the entity to the database using the DAO
            CompetitionDAO.save(competition);

            competition = CompetitionDAO.loadCompetitionByQuery("name = '" + input.getName() + "'", null);

            Competition finalCompetition = competition;
            input.getTrials().forEach(trial -> {
                trial.setCompetitionId(finalCompetition.getId());
                trialBean.createTrialEntity(trial);
            });

            // If the save operation is successful, add a success feedback message
            output.addFeedbackMessage(Competition.class.getName() + input.getName() + " created successfully.", FeedbackSeverity.SUCCESS);

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
    public UpdateCompetitionOutput updateCompetitionEntity(UpdateCompetitionInput input) {
        // Create a new output object to store the result of the update operation
        UpdateCompetitionOutput output = new UpdateCompetitionOutput();
        try {
            // Fetch entity from the database
            Competition competition = CompetitionDAO.getCompetitionByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (competition != null && competition.getId() > 0 && competition.getIsActive()) {
                // Convert object into an entity
                Competition entityToUpdate = Utilities.convertToDAO(input, Competition.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, competition);

                // Check for Notification Relations
                if (input.getNotificationIds() != null && (long) input.getNotificationIds().size() > 0) {
                    for (int notificationId : input.getNotificationIds()) {
                        Notification aux = NotificationDAO.loadNotificationByORMID(notificationId);
                        if (aux != null && aux.getId() > 0)  {
                            competition.notification.add(aux);
                        }
                    }
                }

                // Save the entity to the database using the DAO
                CompetitionDAO.save(competition);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Competition.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);

                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Competition.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetCompetitionByIdOutput getCompetitionById(GetCompetitionByIdInput input) {
        GetCompetitionByIdOutput output = new GetCompetitionByIdOutput();
        try {
            // Fetch entity from the database
            Competition competition = Utilities.fetchEntity(input, input.getId(), CompetitionDAO::loadCompetitionByORMID, CompetitionDAO::getCompetitionByORMID, input.isLazyLoad());
            String condition = "competitionid = " + competition.getId() + " and isactive = true";
            Trial[] trials = TrialDAO.listTrialByQuery(condition, null);
            // Check if entity is retrieved successfully
            if (competition != null && competition.getId() > 0 && competition.getIsActive()) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, competition, GetCompetitionByIdOutput.class, input.isLazyLoad());
                output.setType(competition.getType().getName());
                output.setGrade(competition.getGrade().getName());

                ArrayList<GetAllTrialsOutput.TrialProperties> trialProperties = new ArrayList<>();
                for (Trial trial : trials) {
                    var tp = new GetAllTrialsOutput.TrialProperties();
                    tp.setLat(trial.getLocation().getLatitude());
                    tp.setLon(trial.getLocation().getLongitude());
                    tp.setId(trial.getId());
                    tp.setName(trial.getName());
                    tp.setStartDate(trial.getStartDate());
                    tp.setDistanceUnit(trial.getDistanceUnit());
                    tp.setDistance(trial.getDistance());
                    tp.setLocation(trial.getLocation().getCity());
                    tp.setModality(trial.getModality());
                    trialProperties.add(tp);
                }
                output.setTrials(trialProperties);
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Competition.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllCompetitionsOutput getAllCompetitions(GetAllCompetitionsInput input) {
        GetAllCompetitionsOutput output = new GetAllCompetitionsOutput();
        try {
            // Fetch entities from the database
            String condition = "isactive = true";
            Competition[] competitions = CompetitionDAO.listCompetitionByQuery(condition, null);

            // Check if roles are retrieved successfully
            if (competitions.length > 0) {
                // Assign retrieved entities to the output object
                ArrayList<GetAllCompetitionsOutput.CompetitionProperties> competitionProperties = new ArrayList<>();
                for (Competition c : competitions) {
                    var cp = new GetAllCompetitionsOutput.CompetitionProperties();
                    cp.setId(c.getId());
                    cp.setName(c.getName());
                    cp.setType(c.getType().getName());
                    cp.setGender(c.getGender());
                    cp.setGrade(c.getGrade().getName());
                    cp.setStartDate(c.getStartDate());
                    cp.setEndDate(c.getEndDate());
                    cp.setIsActive(c.getIsActive());
                    competitionProperties.add(cp);
                }
                output.setCompetitionList(competitionProperties);
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
