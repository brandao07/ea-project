package eaproject.controller;

import eaproject.dao.User;
import eaproject.beans.UserBean;
import eaproject.dto.UserDTO;
import eaproject.dto.AuthenticationDTO;
import eaproject.utilities.Utilities;
import eaproject.utilities.JwtTokenUtil;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.ejb.EJB;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {
    @EJB
    UserBean userBean;

    @GetMapping("/GetAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = Arrays.stream(userBean.getAllUsers()).toList();
        if (users == null || users.stream().count() == 0) {
            return ResponseEntity.noContent().build();
        } else {
            List<UserDTO> userDTOList = Utilities.convertToDTOList(users, UserDTO.class);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userDTOList);
        }
    }

    @PostMapping("/Register")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDTO userDTO) {
        boolean createdUser = userBean.createUser(userDTO);
        if (createdUser) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody AuthenticationDTO authenticationInput) {
        try {
            String token = userBean.loginUser(authenticationInput);
            if (token != null && !token.isBlank()) {
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (PersistentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
}
