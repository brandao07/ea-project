package eaproject.controller;

import eaproject.beans.StateBean;
import eaproject.input.GetAllStatesInput;
import eaproject.input.GetStateByIdInput;
import eaproject.input.UpdateStateInput;
import eaproject.output.GetAllStatesOutput;
import eaproject.output.GetStateByIdOutput;
import eaproject.output.UpdateStateOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class StateController {
    @EJB
    StateBean typeBean;

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/UpdateStateEntity")
    public UpdateStateOutput updateStateEntity(@RequestBody UpdateStateInput input) {
        return typeBean.updateStateEntity(input);
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input The input object containing parameters for fetching the entity by ID.
     * @return An output object containing the DTO and any feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetStateById")
    public GetStateByIdOutput getStateById(@RequestBody GetStateByIdInput input) { return typeBean.getStateById(input); }

    /**
     * Retrieves all entities from the database.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetAllStates")
    public GetAllStatesOutput getAllStates(@RequestBody GetAllStatesInput input) {
        return typeBean.getAllStates(input);
    }
}
