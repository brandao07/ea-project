package eaproject.controller;

import eaproject.beans.TrialBean;
import eaproject.input.CreateTrialInput;
import eaproject.input.GetAllTrialsInput;
import eaproject.input.GetTrialByIdInput;
import eaproject.input.UpdateTrialInput;
import eaproject.output.CreateTrialOutput;
import eaproject.output.GetAllTrialsOutput;
import eaproject.output.GetTrialByIdOutput;
import eaproject.output.UpdateTrialOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class TrialController {
    @EJB
    TrialBean trialBean;

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the create operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/CreateTrialEntity")
    public CreateTrialOutput createTrialEntity(@RequestBody CreateTrialInput input) {
        return trialBean.createTrialEntity(input);
    }

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/UpdateTrialEntity")
    public UpdateTrialOutput updateTrialEntity(@RequestBody UpdateTrialInput input) {
        return trialBean.updateTrialEntity(input);
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input The input object containing parameters for fetching the entity by ID.
     * @return An output object containing the DTO and any feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetTrialById")
    public GetTrialByIdOutput getTrialById(@RequestBody GetTrialByIdInput input) { return trialBean.getTrialById(input); }

    /**
     * Retrieves all entities from the database.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetAllTrials")
    public GetAllTrialsOutput getAllTrials(@RequestBody GetAllTrialsInput input) {
        return trialBean.getAllTrials(input);
    }
}
