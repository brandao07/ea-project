package eaproject.beans.locals;

import eaproject.dao.User;
import eaproject.dto.AuthenticationDTO;
import eaproject.dto.UserDTO;

import javax.ejb.Local;

@Local
public interface UserLocal {
    User[] getAllUsers();
    String loadUserByUserEmail(AuthenticationDTO userInput);
    boolean createUser(UserDTO userDTO);
}
