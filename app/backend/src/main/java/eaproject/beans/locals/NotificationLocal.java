package eaproject.beans.locals;

import eaproject.input.CreateNotificationInput;
import eaproject.input.GetAllNotificationsInput;
import eaproject.input.GetNotificationByIdInput;
import eaproject.input.UpdateNotificationInput;
import eaproject.output.CreateNotificationOutput;
import eaproject.output.GetAllNotificationsOutput;
import eaproject.output.GetNotificationByIdOutput;
import eaproject.output.UpdateNotificationOutput;

import javax.ejb.Local;

@Local
public interface NotificationLocal {

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    CreateNotificationOutput createNotificationEntity(CreateNotificationInput input);

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    UpdateNotificationOutput updateNotificationEntity(UpdateNotificationInput input);

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input the input object containing parameters for fetching the entity by ID
     * @return an output object containing the DTO and any feedback messages
     */
    GetNotificationByIdOutput getNotificationById(GetNotificationByIdInput input);

    /**
     * Retrieves all entities from the database.
     *
     * @param input the input object containing parameters for fetching types
     * @return an output object containing the list of objects and feedback messages
     */
    GetAllNotificationsOutput getAllNotifications(GetAllNotificationsInput input);
}