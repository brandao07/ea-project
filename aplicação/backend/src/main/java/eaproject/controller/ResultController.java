package eaproject.controller;

import eaproject.beans.ResultBean;
import eaproject.input.GetAllResultsInput;
import eaproject.input.GetResultByIdInput;
import eaproject.input.UpdateResultInput;
import eaproject.output.GetAllResultsOutput;
import eaproject.output.GetResultByIdOutput;
import eaproject.output.UpdateResultOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class ResultController {
    @EJB
    ResultBean typeBean;

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/UpdateResultEntity")
    public UpdateResultOutput updateResultEntity(@RequestBody UpdateResultInput input) {
        return typeBean.updateResultEntity(input);
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input The input object containing parameters for fetching the entity by ID.
     * @return An output object containing the DTO and any feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetResultById")
    public GetResultByIdOutput getResultById(@RequestBody GetResultByIdInput input) { return typeBean.getResultById(input); }

    /**
     * Retrieves all entities from the database.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetAllResults")
    public GetAllResultsOutput getAllResults(@RequestBody GetAllResultsInput input) {
        return typeBean.getAllResults(input);
    }
}
