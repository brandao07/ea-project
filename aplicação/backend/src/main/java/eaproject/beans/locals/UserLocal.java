package eaproject.beans.locals;

import eaproject.dao.user;

import javax.ejb.Local;

@Local
public interface UserLocal {
    user[] getAllUsers();
}
