package eaproject.beans;

import eaproject.beans.locals.UserLocal;
import eaproject.dao.user;
import eaproject.dao.userDAO;
import org.springframework.stereotype.Component;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "UserEJB")
@Local(UserLocal.class)
@Component
public class UserBean {
    public user[] getAllUsers() {
        try {
            return userDAO.listUserByQuery(null,null);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
