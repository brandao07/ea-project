package eaproject.beans;

import eaproject.beans.locals.LocationLocal;
import eaproject.dao.Location;
import eaproject.dao.LocationDAO;
import eaproject.dao.Type;
import eaproject.dao.TypeDAO;
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

@Stateless(name = "LocationEJB")
@Local(LocationLocal.class)
@Component
public class LocationBean implements LocationLocal {

    @PostConstruct
    public void init() {
    }

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the Create operation.
     */
    public CreateLocationOutput createLocationEntity(CreateLocationInput input) {
        // Create a new output object to store the result of the update operation
        CreateLocationOutput output = new CreateLocationOutput();
        try {
            // Convert object into an entity
            Location location = Utilities.convertToDAO(input, Location.class);

            // Save the entity to the database using the DAO
            LocationDAO.save(location);

            // If the save operation is successful, add a success feedback message
            output.addFeedbackMessage(Location.class.getName() + " created successfully.", FeedbackSeverity.SUCCESS);

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
    public UpdateLocationOutput updateLocationEntity(UpdateLocationInput input) {
        // Create a new output object to store the result of the update operation
        UpdateLocationOutput output = new UpdateLocationOutput();
        try {
            // Fetch entity from the database
            Location location = LocationDAO.getLocationByORMID(input.getId());

            // Check if entity is retrieved successfully
            if (location != null && location.getId() > 0) {
                // Convert object into an entity
                Location entityToUpdate = Utilities.convertToDAO(input, Location.class);

                // Update only non-null fields of the existing entity
                Utilities.updateNonNullFields(entityToUpdate, location);

                // Save the entity to the database using the DAO
                LocationDAO.save(location);

                // If the save operation is successful, add a success feedback message
                output.addFeedbackMessage(Location.class.getName() + " updated successfully.", FeedbackSeverity.SUCCESS);
                // Indicate that the update was successful
                output.setUpdateSuccessful(true);
            } else {
                output.setUpdateSuccessful(false);
                output.addFeedbackMessage(Location.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetLocationByIdOutput getLocationById(GetLocationByIdInput input) {
        GetLocationByIdOutput output = new GetLocationByIdOutput();
        try {
            // Fetch entity from the database
            Location location = Utilities.fetchEntity(input, input.getId(), LocationDAO::loadLocationByORMID, LocationDAO::getLocationByORMID, input.isLazyLoad());

            // Check if entity is retrieved successfully
            if (location != null && location.getId() > 0) {
                // Assign retrieved entity to the output object
                output = Utilities.processLazyLoad(input, location, GetLocationByIdOutput.class, input.isLazyLoad());
            } else {
                // Add feedback message if no entities are found
                output.addFeedbackMessage(Location.class.getName() + " entity with id " + input.getId() + " not found in our database.", FeedbackSeverity.DANGER);
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
    public GetAllLocationsOutput getAllLocations(GetAllLocationsInput input) {
        GetAllLocationsOutput output = new GetAllLocationsOutput();
        try {
            // Fetch entities from the database
            Location[] locations = LocationDAO.listLocationByQuery(null, null);

            // Check if roles are retrieved successfully
            if (locations.length > 0) {
                // Assign retrieved entities to the output object
                output.setLocationList(Utilities.convertToDTOArray(locations, GetAllLocationsOutput.LocationProperties.class));
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
