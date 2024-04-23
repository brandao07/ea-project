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

public class ClubDAO {
    public static Club loadClubByORMID(int ClubId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadClubByORMID(session, ClubId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club getClubByORMID(int ClubId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getClubByORMID(session, ClubId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club loadClubByORMID(int ClubId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadClubByORMID(session, ClubId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club getClubByORMID(int ClubId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getClubByORMID(session, ClubId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club loadClubByORMID(PersistentSession session, int ClubId) throws PersistentException {
        try {
            return (Club) session.load(Club.class, Integer.valueOf(ClubId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club getClubByORMID(PersistentSession session, int ClubId) throws PersistentException {
        try {
            return (Club) session.get(Club.class, Integer.valueOf(ClubId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club loadClubByORMID(PersistentSession session, int ClubId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Club) session.load(Club.class, Integer.valueOf(ClubId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club getClubByORMID(PersistentSession session, int ClubId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Club) session.get(Club.class, Integer.valueOf(ClubId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryClub(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryClub(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryClub(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryClub(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club[] listClubByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listClubByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club[] listClubByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listClubByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryClub(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Club as Club");
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

    public static List queryClub(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Club as Club");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Club", lockMode);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club[] listClubByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        try {
            List list = queryClub(session, condition, orderBy);
            return (Club[]) list.toArray(new Club[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club[] listClubByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            List list = queryClub(session, condition, orderBy, lockMode);
            return (Club[]) list.toArray(new Club[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club loadClubByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadClubByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club loadClubByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadClubByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club loadClubByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        Club[] clubs = listClubByQuery(session, condition, orderBy);
        if (clubs != null && clubs.length > 0)
            return clubs[0];
        else
            return null;
    }

    public static Club loadClubByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        Club[] clubs = listClubByQuery(session, condition, orderBy, lockMode);
        if (clubs != null && clubs.length > 0)
            return clubs[0];
        else
            return null;
    }

    public static java.util.Iterator iterateClubByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateClubByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateClubByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateClubByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateClubByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Club as Club");
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

    public static java.util.Iterator iterateClubByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Club as Club");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Club", lockMode);
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club createClub() {
        return new Club();
    }

    public static boolean save(Club club) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().saveObject(club);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean delete(Club club) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().deleteObject(club);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Club club) throws PersistentException {
        try {
            Team[] lTeams = club.team.toArray();
            for (int i = 0; i < lTeams.length; i++) {
                lTeams[i].setClub(null);
            }
            return delete(club);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Club club, org.orm.PersistentSession session) throws PersistentException {
        try {
            Team[] lTeams = club.team.toArray();
            for (int i = 0; i < lTeams.length; i++) {
                lTeams[i].setClub(null);
            }
            try {
                session.delete(club);
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean refresh(Club club) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().refresh(club);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean evict(Club club) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().evict(club);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Club loadClubByCriteria(ClubCriteria clubCriteria) {
        Club[] clubs = listClubByCriteria(clubCriteria);
        if (clubs == null || clubs.length == 0) {
            return null;
        }
        return clubs[0];
    }

    public static Club[] listClubByCriteria(ClubCriteria clubCriteria) {
        return clubCriteria.listClub();
    }
}
