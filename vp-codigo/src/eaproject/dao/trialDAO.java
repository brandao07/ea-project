/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: User-PC(University of Minho)
 * License Type: Academic
 */
package eaproject.dao;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class trialDAO {
	public static trial loadTrialByORMID(int TrialId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTrialByORMID(session, TrialId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial getTrialByORMID(int TrialId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getTrialByORMID(session, TrialId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial loadTrialByORMID(int TrialId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTrialByORMID(session, TrialId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial getTrialByORMID(int TrialId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getTrialByORMID(session, TrialId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial loadTrialByORMID(PersistentSession session, int TrialId) throws PersistentException {
		try {
			return (trial) session.load(eaproject.dao.trial.class, Integer.valueOf(TrialId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial getTrialByORMID(PersistentSession session, int TrialId) throws PersistentException {
		try {
			return (trial) session.get(eaproject.dao.trial.class, Integer.valueOf(TrialId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial loadTrialByORMID(PersistentSession session, int TrialId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (trial) session.load(eaproject.dao.trial.class, Integer.valueOf(TrialId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial getTrialByORMID(PersistentSession session, int TrialId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (trial) session.get(eaproject.dao.trial.class, Integer.valueOf(TrialId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTrial(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryTrial(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTrial(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryTrial(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial[] listTrialByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listTrialByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial[] listTrialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listTrialByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTrial(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.trial as trial");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTrial(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.trial as trial");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("trial", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial[] listTrialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTrial(session, condition, orderBy);
			return (trial[]) list.toArray(new trial[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial[] listTrialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTrial(session, condition, orderBy, lockMode);
			return (trial[]) list.toArray(new trial[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial loadTrialByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTrialByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial loadTrialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTrialByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial loadTrialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		trial[] trials = listTrialByQuery(session, condition, orderBy);
		if (trials != null && trials.length > 0)
			return trials[0];
		else
			return null;
	}
	
	public static trial loadTrialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		trial[] trials = listTrialByQuery(session, condition, orderBy, lockMode);
		if (trials != null && trials.length > 0)
			return trials[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTrialByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateTrialByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTrialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateTrialByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTrialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.trial as trial");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTrialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.trial as trial");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("trial", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial createTrial() {
		return new eaproject.dao.trial();
	}
	
	public static boolean save(eaproject.dao.trial ltrial) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(ltrial);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.trial ltrial) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(ltrial);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.trial ltrial)throws PersistentException {
		try {
			if (ltrial.getState() != null) {
				ltrial.getState().trial.remove(ltrial);
			}
			
			if (ltrial.getCompetition() != null) {
				ltrial.getCompetition().trial.remove(ltrial);
			}
			
			if (ltrial.getGrade() != null) {
				ltrial.getGrade().trial.remove(ltrial);
			}
			
			if (ltrial.getType() != null) {
				ltrial.getType().trial.remove(ltrial);
			}
			
			if (ltrial.getLocation() != null) {
				ltrial.getLocation().trial.remove(ltrial);
			}
			
			if (ltrial.getUser() != null) {
				ltrial.getUser().trial.remove(ltrial);
			}
			
			eaproject.dao.result[] lResults = ltrial.result.toArray();
			for(int i = 0; i < lResults.length; i++) {
				lResults[i].setTrial(null);
			}
			return delete(ltrial);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.trial ltrial, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (ltrial.getState() != null) {
				ltrial.getState().trial.remove(ltrial);
			}
			
			if (ltrial.getCompetition() != null) {
				ltrial.getCompetition().trial.remove(ltrial);
			}
			
			if (ltrial.getGrade() != null) {
				ltrial.getGrade().trial.remove(ltrial);
			}
			
			if (ltrial.getType() != null) {
				ltrial.getType().trial.remove(ltrial);
			}
			
			if (ltrial.getLocation() != null) {
				ltrial.getLocation().trial.remove(ltrial);
			}
			
			if (ltrial.getUser() != null) {
				ltrial.getUser().trial.remove(ltrial);
			}
			
			eaproject.dao.result[] lResults = ltrial.result.toArray();
			for(int i = 0; i < lResults.length; i++) {
				lResults[i].setTrial(null);
			}
			try {
				session.delete(ltrial);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(eaproject.dao.trial ltrial) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(ltrial);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.trial ltrial) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(ltrial);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static trial loadTrialByCriteria(trialCriteria trialCriteria) {
		trial[] trials = listTrialByCriteria(trialCriteria);
		if(trials == null || trials.length == 0) {
			return null;
		}
		return trials[0];
	}
	
	public static trial[] listTrialByCriteria(trialCriteria trialCriteria) {
		return trialCriteria.listTrial();
	}
}
