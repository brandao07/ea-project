package eaproject.beans;

import eaproject.beans.locals.UserLocal;
import eaproject.dao.User;
import eaproject.dao.UserDAO;
import eaproject.dto.UserDTO;
import eaproject.utilities.Utilities;
import org.orm.PersistentException;
import org.springframework.stereotype.Component;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "UserEJB")
@Local(UserLocal.class)
@Component
public class UserBean {
    public User[] getAllUsers() {
        try {
            return UserDAO.listUserByQuery(null,null);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public boolean createUser(UserDTO userDTO) {
        try {
            // Convert UserDTO to User entity
            User user = Utilities.convertToDAO(userDTO, User.class);
            // Save user to database using DAO
            return UserDAO.save(user);
        } catch (PersistentException e) {
            throw new RuntimeException(e);
        }
    }
}
