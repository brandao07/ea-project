package eaproject.controllers;

import com.google.gson.Gson;
import eaproject.beans.UserBean;
import eaproject.dao.user;
import eaproject.dto.userDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.ejb.EJB;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/user")
public class UserController {
    @EJB
    UserBean userBean;

    @GetMapping("/")
    public ResponseEntity<userDTO[]> getAllUsers() {
        user[] users = userBean.getAllUsers();
        if (users == null || users.length == 0) {
            return ResponseEntity.noContent().build();
        } else {
            userDTO[] usersList = new userDTO[users.length];
            for(int i = 0; i < users.length; i++){
                usersList[i] = new userDTO(users[i]);
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(usersList);
        }
    }
}
