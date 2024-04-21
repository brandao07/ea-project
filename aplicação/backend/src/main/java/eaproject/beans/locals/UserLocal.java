package eaproject.beans.locals;

import eaproject.dao.user;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserLocal {
    public List<user> getAllUsers();
}
