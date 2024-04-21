package eaproject.controllers;

import eaproject.beans.UserBean;
import eaproject.dao.user;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/user")
public class UserController {

    @EJB
    UserBean userBean = new UserBean();

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        List<user> users = userBean.getAllUsers();
        if (users.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }
}
