package eaproject.controller;

import eaproject.beans.UserBean;
import eaproject.input.AuthenticationInput;
import eaproject.input.UserRegisterInput;
import eaproject.output.AuthenticationOutput;
import eaproject.output.UserRegisterOutput;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class UserController {
    @EJB
    UserBean userBean;

    @PostMapping("/Register")
    public UserRegisterOutput registerUser(@RequestBody UserRegisterInput userRegisterInput) {
        return userBean.registerNewUser(userRegisterInput);
    }

    @PostMapping("/Login")
    public AuthenticationOutput loginUser(@RequestBody AuthenticationInput authenticationInput) {
        return userBean.authenticateUser(authenticationInput);
    }
}
