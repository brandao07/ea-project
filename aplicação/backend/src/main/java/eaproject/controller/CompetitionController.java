package eaproject.controller;

import eaproject.beans.CompetitionBean;
import eaproject.input.GetAllCompetitionsInput;
import eaproject.input.GetCompetitionByIdInput;
import eaproject.input.UpdateCompetitionInput;
import eaproject.output.GetAllCompetitionsOutput;
import eaproject.output.GetCompetitionByIdOutput;
import eaproject.output.UpdateCompetitionOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class CompetitionController {
    @EJB
    CompetitionBean typeBean;

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/UpdateCompetitionEntity")
    public UpdateCompetitionOutput updateCompetitionEntity(@RequestBody UpdateCompetitionInput input) {
        return typeBean.updateCompetitionEntity(input);
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input The input object containing parameters for fetching the entity by ID.
     * @return An output object containing the DTO and any feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetCompetitionById")
    public GetCompetitionByIdOutput getCompetitionById(@RequestBody GetCompetitionByIdInput input) { return typeBean.getCompetitionById(input); }

    /**
     * Retrieves all entities from the database.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetAllCompetitions")
    public GetAllCompetitionsOutput getAllCompetitions(@RequestBody GetAllCompetitionsInput input) {
        return typeBean.getAllCompetitions(input);
    }
}
