package eaproject.beans;

import eaproject.beans.locals.TrialLocal;
import eaproject.dao.*;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.CreateTrialInput;
import eaproject.input.GetAllTrialsInput;
import eaproject.input.GetTrialByIdInput;
import eaproject.input.UpdateTrialInput;
import eaproject.output.CreateTrialOutput;
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
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    public CreateTrialOutput createTrialEntity(CreateTrialInput input) {
        // Create a new output object to store the result of the update operation
        CreateTrialOutput output = new CreateTrialOutput();
        try {
            // Convert object into an entity
            Trial trial = Utilities.convertToDAO(input, Trial.class);

            // Check for Competition Relations
            if (input.getCompetitionId() != null && input.getCompetitionId() > 0) {
                Competition aux = CompetitionDAO.getCompetitionByORMID(input.getCompetitionId());
                if (aux != null && aux.getId() > 0) {
                    trial.setCompetition(aux);
                }
            }

            // Check for Location Relations
            if (input.getLocationId() != null && input.getLocationId() > 0) {
                Location aux = LocationDAO.getLocationByORMID(input.getLocationId());
                if (aux != null && aux.getId() > 0) {
                    trial.setLocation(aux);
                }
            }

   /*         // Check for Grade Relations
            if (input.getGradeId() != null && input.getGradeId() > 0) {
                Grade aux = GradeDAO.getGradeByORMID(input.getGradeId());
                if (aux != null && aux.getId() > 0) {
                    trial.setGrade(aux);
                }
            }
*/
            // Check for State Relations
            if (input.getStateId() != null && input.getStateId() > 0) {
                State aux = StateDAO.getStateByORMID(input.getStateId());
                if (aux != null && aux.getId() > 0) {
                    trial.setState(aux);
                }
            }

            // Check for Type Relations
            if (input.getTypeId() != null && input.getTypeId() > 0) {
                Type aux = TypeDAO.getTypeByORMID(input.getTypeId());
                if (aux != null && aux.getId() > 0) {
                    trial.setType(aux);
                }
            }

            // Set distance
            trial.setDistance(input.getDistance());

            // Save the entity to the database using the DAO
            TrialDAO.save(trial);

            // If the save operation is successful, add a success feedback message
            output.addFeedbackMessage(Trial.class.getName() + input.getName() + " created successfully.", FeedbackSeverity.SUCCESS);

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
    public UpdateTrialOutput updateTrialEntity(UpdateTrialInput input) {
        // Create a new output object to store the result of the update operation
        UpdateTrialOutput output = new UpdateTrialOutput();
        try {
            // Fetch entity from the database
            Trial trial = TrialDAO.getTrialByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (trial != null && trial.getId() > 0 && trial.getIsActive()) {
                // Convert object into an entity
                Trial entityToUpdate = Utilities.convertToDAO(input, Trial.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, trial);

                // Check for Competition Relations
                if (input.getCompetitionId() != null && input.getCompetitionId() > 0) {
                    Competition aux = CompetitionDAO.getCompetitionByORMID(input.getCompetitionId());
                    if (aux != null && aux.getId() > 0) {
                        trial.setCompetition(aux);
                    }
                }

                // Check for Location Relations
                if (input.getLocationId() != null && input.getLocationId() > 0) {
                    Location aux = LocationDAO.getLocationByORMID(input.getLocationId());
                    if (aux != null && aux.getId() > 0) {
                        trial.setLocation(aux);
                    }
                }

/*                // Check for Grade Relations
                if (input.getGradeId() != null && input.getGradeId() > 0) {
                    Grade aux = GradeDAO.getGradeByORMID(input.getGradeId());
                    if (aux != null && aux.getId() > 0) {
                        trial.setGrade(aux);
                    }
                }*/

                // Check for State Relations
                if (input.getStateId() != null && input.getStateId() > 0) {
                    State aux = StateDAO.getStateByORMID(input.getStateId());
                    if (aux != null && aux.getId() > 0) {
                        trial.setState(aux);
                    }
                }

                // Check for Type Relations
                if (input.getTypeId() != null && input.getTypeId() > 0) {
                    Type aux = TypeDAO.getTypeByORMID(input.getTypeId());
                    if (aux != null && aux.getId() > 0) {
                        trial.setType(aux);
                    }
                }

                // Set distance
                trial.setDistance(input.getDistance());

                // Save the entity to the database using the DAO
                TrialDAO.save(trial);

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
            Trial trial = Utilities.fetchEntity(input, input.getId(), TrialDAO::loadTrialByORMID, TrialDAO::getTrialByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (trial != null && trial.getId() > 0 && trial.getIsActive()) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, trial, GetTrialByIdOutput.class, input.isLazyLoad());
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
            Trial[] trials = TrialDAO.listTrialByQuery(null, null);

            // Check if roles are retrieved successfully
            if (trials.length > 0) {
                // Assign retrieved entities to the output object
                output.setTrials(Utilities.convertToDTOArray(trials, GetAllTrialsOutput.TrialProperties.class));
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
