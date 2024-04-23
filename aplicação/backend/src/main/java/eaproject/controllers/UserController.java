package eaproject.controllers;

import eaproject.beans.UserBean;
import eaproject.dao.user;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/user")
public class UserController {
    @EJB
    UserBean userBean;

    @GetMapping("/")
    public ResponseEntity<user[]> getAllUsers() {
        user[] users = userBean.getAllUsers();
        if (users == null || users.length == 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }
}
