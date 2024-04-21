package eaproject.beans;

import eaproject.beans.locals.UserLocal;
import eaproject.dao.*;

import org.orm.PersistentException;
import org.springframework.stereotype.Component;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless(name = "UserEJB")
@Local(UserLocal.class)
@Component
public class UserBean {
    public List<user> getAllUsers() {
        try {
            return Arrays.stream(userDAO.listUserByQuery(null,null)).toList();
        } catch (PersistentException e) {
            throw new RuntimeException(e);
        }
    }
}
