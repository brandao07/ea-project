package eaproject.controller;

import eaproject.beans.GradeBean;
import eaproject.input.GetAllGradesInput;
import eaproject.input.GetGradeByIdInput;
import eaproject.input.UpdateGradeInput;
import eaproject.output.GetAllGradesOutput;
import eaproject.output.GetGradeByIdOutput;
import eaproject.output.UpdateGradeOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class GradeController {
    @EJB
    GradeBean typeBean;

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/UpdateGradeEntity")
    public UpdateGradeOutput updateGradeEntity(@RequestBody UpdateGradeInput input) {
        return typeBean.updateGradeEntity(input);
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input The input object containing parameters for fetching the entity by ID.
     * @return An output object containing the DTO and any feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetGradeById")
    public GetGradeByIdOutput getGradeById(@RequestBody GetGradeByIdInput input) { return typeBean.getGradeById(input); }

    /**
     * Retrieves all entities from the database.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetAllGrades")
    public GetAllGradesOutput getAllGrades(@RequestBody GetAllGradesInput input) {
        return typeBean.getAllGrades(input);
    }
}
