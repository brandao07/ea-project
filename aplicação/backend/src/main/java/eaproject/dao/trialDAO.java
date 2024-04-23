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

public class TrialDAO {
    public static Trial loadTrialByORMID(int TrialId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadTrialByORMID(session, TrialId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial getTrialByORMID(int TrialId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getTrialByORMID(session, TrialId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial loadTrialByORMID(int TrialId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadTrialByORMID(session, TrialId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial getTrialByORMID(int TrialId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getTrialByORMID(session, TrialId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial loadTrialByORMID(PersistentSession session, int TrialId) throws PersistentException {
        try {
            return (Trial) session.load(Trial.class, Integer.valueOf(TrialId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial getTrialByORMID(PersistentSession session, int TrialId) throws PersistentException {
        try {
            return (Trial) session.get(Trial.class, Integer.valueOf(TrialId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial loadTrialByORMID(PersistentSession session, int TrialId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Trial) session.load(Trial.class, Integer.valueOf(TrialId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial getTrialByORMID(PersistentSession session, int TrialId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Trial) session.get(Trial.class, Integer.valueOf(TrialId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryTrial(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryTrial(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryTrial(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryTrial(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial[] listTrialByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listTrialByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial[] listTrialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listTrialByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryTrial(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Trial as Trial");
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

    public static List queryTrial(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Trial as Trial");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Trial", lockMode);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial[] listTrialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        try {
            List list = queryTrial(session, condition, orderBy);
            return (Trial[]) list.toArray(new Trial[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial[] listTrialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            List list = queryTrial(session, condition, orderBy, lockMode);
            return (Trial[]) list.toArray(new Trial[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial loadTrialByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadTrialByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial loadTrialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadTrialByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial loadTrialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        Trial[] trials = listTrialByQuery(session, condition, orderBy);
        if (trials != null && trials.length > 0)
            return trials[0];
        else
            return null;
    }

    public static Trial loadTrialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        Trial[] trials = listTrialByQuery(session, condition, orderBy, lockMode);
        if (trials != null && trials.length > 0)
            return trials[0];
        else
            return null;
    }

    public static java.util.Iterator iterateTrialByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateTrialByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateTrialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateTrialByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateTrialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Trial as Trial");
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

    public static java.util.Iterator iterateTrialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Trial as Trial");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Trial", lockMode);
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial createTrial() {
        return new Trial();
    }

    public static boolean save(Trial trial) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().saveObject(trial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean delete(Trial trial) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().deleteObject(trial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Trial trial) throws PersistentException {
        try {
            if (trial.getState() != null) {
                trial.getState().trial.remove(trial);
            }

            if (trial.getCompetition() != null) {
                trial.getCompetition().trial.remove(trial);
            }

            if (trial.getGrade() != null) {
                trial.getGrade().trial.remove(trial);
            }

            if (trial.getType() != null) {
                trial.getType().trial.remove(trial);
            }

            if (trial.getLocation() != null) {
                trial.getLocation().trial.remove(trial);
            }

            if (trial.getUser() != null) {
                trial.getUser().trial.remove(trial);
            }

            Result[] lResults = trial.result.toArray();
            for (int i = 0; i < lResults.length; i++) {
                lResults[i].setTrial(null);
            }
            return delete(trial);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Trial trial, org.orm.PersistentSession session) throws PersistentException {
        try {
            if (trial.getState() != null) {
                trial.getState().trial.remove(trial);
            }

            if (trial.getCompetition() != null) {
                trial.getCompetition().trial.remove(trial);
            }

            if (trial.getGrade() != null) {
                trial.getGrade().trial.remove(trial);
            }

            if (trial.getType() != null) {
                trial.getType().trial.remove(trial);
            }

            if (trial.getLocation() != null) {
                trial.getLocation().trial.remove(trial);
            }

            if (trial.getUser() != null) {
                trial.getUser().trial.remove(trial);
            }

            Result[] lResults = trial.result.toArray();
            for (int i = 0; i < lResults.length; i++) {
                lResults[i].setTrial(null);
            }
            try {
                session.delete(trial);
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean refresh(Trial trial) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().refresh(trial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean evict(Trial trial) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().evict(trial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Trial loadTrialByCriteria(TrialCriteria trialCriteria) {
        Trial[] trials = listTrialByCriteria(trialCriteria);
        if (trials == null || trials.length == 0) {
            return null;
        }
        return trials[0];
    }

    public static Trial[] listTrialByCriteria(TrialCriteria trialCriteria) {
        return trialCriteria.listTrial();
    }
}
