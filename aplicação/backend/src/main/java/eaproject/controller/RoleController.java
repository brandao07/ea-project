package eaproject.controller;

import eaproject.beans.RoleBean;
import eaproject.input.GetRolesInput;
import eaproject.output.GetRolesOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class RoleController {
    @EJB
    RoleBean roleBean;

    /**
     * Retrieves all roles from the database and returns them in a GetRolesOutput object.
     *
     * @param rolesInput A GetRolesInput object containing any input parameters needed for fetching roles.
     * @return An object containing the roles retrieved from the database.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @PostMapping("/GetAllRoles")
    public GetRolesOutput getAllRoles(@RequestBody GetRolesInput rolesInput) {
        return roleBean.getAllRoles(rolesInput);
    }
}
