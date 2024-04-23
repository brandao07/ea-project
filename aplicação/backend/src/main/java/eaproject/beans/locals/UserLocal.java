package eaproject.beans.locals;

import eaproject.dao.User;

import javax.ejb.Local;

@Local
public interface UserLocal {
    User[] getAllUsers();
}
