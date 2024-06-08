package eaproject.beans;

import eaproject.beans.locals.NotificationLocal;
import eaproject.dao.Notification;
import eaproject.dao.NotificationDAO;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.GetAllNotificationsInput;
import eaproject.input.GetNotificationByIdInput;
import eaproject.input.UpdateNotificationInput;
import eaproject.output.GetAllNotificationsOutput;
import eaproject.output.GetNotificationByIdOutput;
import eaproject.output.UpdateNotificationOutput;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "NotificationEJB")
@Local(NotificationLocal.class)
@Component
public class NotificationBean implements NotificationLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    public UpdateNotificationOutput updateNotificationEntity(UpdateNotificationInput input) {
        // Create a new output object to store the result of the update operation
        UpdateNotificationOutput output = new UpdateNotificationOutput();
        try {
            // Fetch entity from the database
            Notification notification = NotificationDAO.getNotificationByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (notification != null && notification.getId() > 0) {
                // Convert object into an entity
                Notification entityToUpdate = Utilities.convertToDAO(input, Notification.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, notification);

                // Save the entity to the database using the DAO
                NotificationDAO.save(notification);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Notification.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Notification.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetNotificationByIdOutput getNotificationById(GetNotificationByIdInput input) {
        GetNotificationByIdOutput output = new GetNotificationByIdOutput();
        try {
            // Fetch entity from the database
            Notification notification = Utilities.fetchEntity(input, input.getId(), NotificationDAO::loadNotificationByORMID, NotificationDAO::getNotificationByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (notification != null && notification.getId() > 0) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, notification, GetNotificationByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Notification.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllNotificationsOutput getAllNotifications(GetAllNotificationsInput input) {
        GetAllNotificationsOutput output = new GetAllNotificationsOutput();
        try {
            // Fetch entities from the database
            Notification[] notifications = NotificationDAO.listNotificationByQuery(null, null);

            // Check if roles are retrieved successfully
            if (notifications.length > 0) {
                // Assign retrieved entities to the output object
                output.setNotificationList(Utilities.convertToDTOArray(notifications, GetAllNotificationsOutput.NotificationProperties.class));
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
