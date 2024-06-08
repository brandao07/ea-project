package eaproject.controller;

import eaproject.beans.LocationBean;
import eaproject.input.GetAllLocationsInput;
import eaproject.input.GetLocationByIdInput;
import eaproject.input.UpdateLocationInput;
import eaproject.output.GetAllLocationsOutput;
import eaproject.output.GetLocationByIdOutput;
import eaproject.output.UpdateLocationOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class LocationController {
    @EJB
    LocationBean typeBean;

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/UpdateLocationEntity")
    public UpdateLocationOutput updateLocationEntity(@RequestBody UpdateLocationInput input) {
        return typeBean.updateLocationEntity(input);
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input The input object containing parameters for fetching the entity by ID.
     * @return An output object containing the DTO and any feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetLocationById")
    public GetLocationByIdOutput getLocationById(@RequestBody GetLocationByIdInput input) { return typeBean.getLocationById(input); }

    /**
     * Retrieves all entities from the database.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetAllLocations")
    public GetAllLocationsOutput getAllLocations(@RequestBody GetAllLocationsInput input) {
        return typeBean.getAllLocations(input);
    }
}
