/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */
package eaproject.dao;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class TrialDAO {
	public static Trial loadTrialByORMID(int Id) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTrialByORMID(session, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial getTrialByORMID(int Id) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getTrialByORMID(session, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial loadTrialByORMID(int Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTrialByORMID(session, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial getTrialByORMID(int Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getTrialByORMID(session, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial loadTrialByORMID(PersistentSession session, int Id) throws PersistentException {
		try {
			return (Trial) session.load(eaproject.dao.Trial.class, Integer.valueOf(Id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial getTrialByORMID(PersistentSession session, int Id) throws PersistentException {
		try {
			return (Trial) session.get(eaproject.dao.Trial.class, Integer.valueOf(Id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial loadTrialByORMID(PersistentSession session, int Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Trial) session.load(eaproject.dao.Trial.class, Integer.valueOf(Id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial getTrialByORMID(PersistentSession session, int Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Trial) session.get(eaproject.dao.Trial.class, Integer.valueOf(Id), lockMode);
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
	
	public static Trial[] listTrialByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listTrialByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial[] listTrialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.Trial as Trial");
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.Trial as Trial");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Trial", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial[] listTrialByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTrial(session, condition, orderBy);
			return (Trial[]) list.toArray(new Trial[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial[] listTrialByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTrial(session, condition, orderBy, lockMode);
			return (Trial[]) list.toArray(new Trial[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial loadTrialByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTrialByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial loadTrialByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTrialByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.Trial as Trial");
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.Trial as Trial");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Trial", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial createTrial() {
		return new eaproject.dao.Trial();
	}
	
	public static boolean save(eaproject.dao.Trial trial) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(trial);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.Trial trial) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(trial);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.Trial trial)throws PersistentException {
		try {
			if (trial.getCompetition() != null) {
				trial.getCompetition().trial.remove(trial);
			}
			
			if (trial.getGrade() != null) {
				trial.getGrade().trial.remove(trial);
			}
			
			eaproject.dao.Result[] lResults = trial.result.toArray();
			for(int i = 0; i < lResults.length; i++) {
				lResults[i].trial.remove(trial);
			}
			eaproject.dao.Team[] lTeams = trial.team.toArray();
			for(int i = 0; i < lTeams.length; i++) {
				lTeams[i].trial.remove(trial);
			}
			return delete(trial);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.Trial trial, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (trial.getCompetition() != null) {
				trial.getCompetition().trial.remove(trial);
			}
			
			if (trial.getGrade() != null) {
				trial.getGrade().trial.remove(trial);
			}
			
			eaproject.dao.Result[] lResults = trial.result.toArray();
			for(int i = 0; i < lResults.length; i++) {
				lResults[i].trial.remove(trial);
			}
			eaproject.dao.Team[] lTeams = trial.team.toArray();
			for(int i = 0; i < lTeams.length; i++) {
				lTeams[i].trial.remove(trial);
			}
			try {
				session.delete(trial);
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
	
	public static boolean refresh(eaproject.dao.Trial trial) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(trial);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.Trial trial) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(trial);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Trial loadTrialByCriteria(TrialCriteria trialCriteria) {
		Trial[] trials = listTrialByCriteria(trialCriteria);
		if(trials == null || trials.length == 0) {
			return null;
		}
		return trials[0];
	}
	
	public static Trial[] listTrialByCriteria(TrialCriteria trialCriteria) {
		return trialCriteria.listTrial();
	}
}
