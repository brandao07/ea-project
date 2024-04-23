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

public class CompetitionDAO {
    public static Competition loadCompetitionByORMID(int CompetitionId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadCompetitionByORMID(session, CompetitionId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition getCompetitionByORMID(int CompetitionId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getCompetitionByORMID(session, CompetitionId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition loadCompetitionByORMID(int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadCompetitionByORMID(session, CompetitionId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition getCompetitionByORMID(int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getCompetitionByORMID(session, CompetitionId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition loadCompetitionByORMID(PersistentSession session, int CompetitionId) throws PersistentException {
        try {
            return (Competition) session.load(Competition.class, Integer.valueOf(CompetitionId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition getCompetitionByORMID(PersistentSession session, int CompetitionId) throws PersistentException {
        try {
            return (Competition) session.get(Competition.class, Integer.valueOf(CompetitionId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition loadCompetitionByORMID(PersistentSession session, int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Competition) session.load(Competition.class, Integer.valueOf(CompetitionId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition getCompetitionByORMID(PersistentSession session, int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Competition) session.get(Competition.class, Integer.valueOf(CompetitionId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryCompetition(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryCompetition(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryCompetition(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryCompetition(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition[] listCompetitionByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listCompetitionByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition[] listCompetitionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listCompetitionByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryCompetition(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Competition as Competition");
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

    public static List queryCompetition(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Competition as Competition");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Competition", lockMode);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition[] listCompetitionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        try {
            List list = queryCompetition(session, condition, orderBy);
            return (Competition[]) list.toArray(new Competition[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition[] listCompetitionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            List list = queryCompetition(session, condition, orderBy, lockMode);
            return (Competition[]) list.toArray(new Competition[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition loadCompetitionByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadCompetitionByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition loadCompetitionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadCompetitionByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition loadCompetitionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        Competition[] competitions = listCompetitionByQuery(session, condition, orderBy);
        if (competitions != null && competitions.length > 0)
            return competitions[0];
        else
            return null;
    }

    public static Competition loadCompetitionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        Competition[] competitions = listCompetitionByQuery(session, condition, orderBy, lockMode);
        if (competitions != null && competitions.length > 0)
            return competitions[0];
        else
            return null;
    }

    public static java.util.Iterator iterateCompetitionByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateCompetitionByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateCompetitionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateCompetitionByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateCompetitionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Competition as Competition");
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

    public static java.util.Iterator iterateCompetitionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Competition as Competition");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Competition", lockMode);
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition createCompetition() {
        return new Competition();
    }

    public static boolean save(Competition competition) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().saveObject(competition);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean delete(Competition competition) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().deleteObject(competition);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Competition competition) throws PersistentException {
        try {
            Trial[] lTrials = competition.trial.toArray();
            for (int i = 0; i < lTrials.length; i++) {
                lTrials[i].setCompetition(null);
            }
            Notification[] lNotifications = competition.notification.toArray();
            for (int i = 0; i < lNotifications.length; i++) {
                lNotifications[i].setCompetition(null);
            }
            return delete(competition);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Competition competition, org.orm.PersistentSession session) throws PersistentException {
        try {
            Trial[] lTrials = competition.trial.toArray();
            for (int i = 0; i < lTrials.length; i++) {
                lTrials[i].setCompetition(null);
            }
            Notification[] lNotifications = competition.notification.toArray();
            for (int i = 0; i < lNotifications.length; i++) {
                lNotifications[i].setCompetition(null);
            }
            try {
                session.delete(competition);
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean refresh(Competition competition) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().refresh(competition);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean evict(Competition competition) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().evict(competition);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Competition loadCompetitionByCriteria(CompetitionCriteria competitionCriteria) {
        Competition[] competitions = listCompetitionByCriteria(competitionCriteria);
        if (competitions == null || competitions.length == 0) {
            return null;
        }
        return competitions[0];
    }

    public static Competition[] listCompetitionByCriteria(CompetitionCriteria competitionCriteria) {
        return competitionCriteria.listCompetition();
    }
}
