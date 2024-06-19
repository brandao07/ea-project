package eaproject.controller;

import eaproject.beans.TeamBean;
import eaproject.input.*;
import eaproject.output.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class TeamController {
    @EJB
    TeamBean teamBean;

    /**
     * Creates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the create operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/CreateTeamEntity")
    public CreateTeamOutput createTeamEntity(@RequestBody CreateTeamInput input) {
        return teamBean.createTeamEntity(input);
    }

    /**
     * Updates the entity in the database based on the input, updating only non-null fields.
     *
     * @param input The input object containing the data to update.
     * @return The output object containing the result of the update operation.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/UpdateTeamEntity")
    public UpdateTeamOutput updateTeamEntity(@RequestBody UpdateTeamInput input) {
        return teamBean.updateTeamEntity(input);
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param input The input object containing parameters for fetching the entity by ID.
     * @return An output object containing the DTO and any feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetTeamById")
    public GetTeamByIdOutput getTeamById(@RequestBody GetTeamByIdInput input) { return teamBean.getTeamById(input); }

    /**
     * Retrieves all entities from the database.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetAllTeams")
    public GetAllTeamsOutput getAllTeams(@RequestBody GetAllTeamsInput input) {
        return teamBean.getAllTeams(input);
    }

    /**
     * Retrieves all entities by team Id.
     *
     * @param input The input object containing parameters for fetching types.
     * @return An output object containing the list of objects and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetTeamsByTrialId")
    public GetTeamsByTrialIdOutput getTeamsByTrialIdOutput(@RequestBody GetTeamsByTrialIdInput input) {
        return teamBean.getTeamsByTrialId(input);
    }

    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetTeamsByClubId")
    public GetTeamsByClubIdOutput getTeamsByClubIdOutput(@RequestBody GetTeamsByClubIdInput input) {
        return teamBean.getTeamsByClubId(input);
    }
}
