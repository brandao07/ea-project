/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */

/**
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */
package eaproject.dao;

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.List;

public class RoleDAO {
    public static Role loadRoleByORMID(int RoleId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadRoleByORMID(session, RoleId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role getRoleByORMID(int RoleId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getRoleByORMID(session, RoleId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role loadRoleByORMID(int RoleId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadRoleByORMID(session, RoleId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role getRoleByORMID(int RoleId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getRoleByORMID(session, RoleId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role loadRoleByORMID(PersistentSession session, int RoleId) throws PersistentException {
        try {
            return (Role) session.load(Role.class, Integer.valueOf(RoleId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role getRoleByORMID(PersistentSession session, int RoleId) throws PersistentException {
        try {
            return (Role) session.get(Role.class, Integer.valueOf(RoleId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role loadRoleByORMID(PersistentSession session, int RoleId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Role) session.load(Role.class, Integer.valueOf(RoleId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role getRoleByORMID(PersistentSession session, int RoleId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Role) session.get(Role.class, Integer.valueOf(RoleId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryRole(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryRole(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryRole(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryRole(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role[] listRoleByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listRoleByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role[] listRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listRoleByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryRole(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Role as Role");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryRole(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Role as Role");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Role", lockMode);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role[] listRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        try {
            List list = queryRole(session, condition, orderBy);
            return (Role[]) list.toArray(new Role[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role[] listRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            List list = queryRole(session, condition, orderBy, lockMode);
            return (Role[]) list.toArray(new Role[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role loadRoleByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadRoleByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role loadRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadRoleByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role loadRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        Role[] roles = listRoleByQuery(session, condition, orderBy);
        if (roles != null && roles.length > 0)
            return roles[0];
        else
            return null;
    }

    public static Role loadRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        Role[] roles = listRoleByQuery(session, condition, orderBy, lockMode);
        if (roles != null && roles.length > 0)
            return roles[0];
        else
            return null;
    }

    public static java.util.Iterator iterateRoleByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateRoleByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateRoleByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Role as Role");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Role as Role");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Role", lockMode);
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role createRole() {
        return new Role();
    }

    public static boolean save(Role role) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().saveObject(role);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean delete(Role role) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().deleteObject(role);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Role role) throws PersistentException {
        try {
            User[] lUsers = role.user.toArray();
            for (int i = 0; i < lUsers.length; i++) {
                lUsers[i].setRole(null);
            }
            return delete(role);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Role role, org.orm.PersistentSession session) throws PersistentException {
        try {
            User[] lUsers = role.user.toArray();
            for (int i = 0; i < lUsers.length; i++) {
                lUsers[i].setRole(null);
            }
            try {
                session.delete(role);
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean refresh(Role role) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().refresh(role);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean evict(Role role) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().evict(role);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Role loadRoleByCriteria(RoleCriteria roleCriteria) {
        Role[] roles = listRoleByCriteria(roleCriteria);
        if (roles == null || roles.length == 0) {
            return null;
        }
        return roles[0];
    }

    public static Role[] listRoleByCriteria(RoleCriteria roleCriteria) {
        return roleCriteria.listRole();
    }
}
