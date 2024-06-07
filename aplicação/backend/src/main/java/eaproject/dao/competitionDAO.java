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

public class CompetitionDAO {
	public static Competition loadCompetitionByORMID(int Id) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByORMID(session, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition getCompetitionByORMID(int Id) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getCompetitionByORMID(session, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByORMID(int Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByORMID(session, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition getCompetitionByORMID(int Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getCompetitionByORMID(session, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByORMID(PersistentSession session, int Id) throws PersistentException {
		try {
			return (Competition) session.load(eaproject.dao.Competition.class, Integer.valueOf(Id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition getCompetitionByORMID(PersistentSession session, int Id) throws PersistentException {
		try {
			return (Competition) session.get(eaproject.dao.Competition.class, Integer.valueOf(Id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByORMID(PersistentSession session, int Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Competition) session.load(eaproject.dao.Competition.class, Integer.valueOf(Id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition getCompetitionByORMID(PersistentSession session, int Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Competition) session.get(eaproject.dao.Competition.class, Integer.valueOf(Id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCompetition(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryCompetition(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCompetition(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryCompetition(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition[] listCompetitionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listCompetitionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition[] listCompetitionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listCompetitionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCompetition(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Competition as Competition");
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
	
	public static List queryCompetition(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Competition as Competition");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Competition", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition[] listCompetitionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCompetition(session, condition, orderBy);
			return (Competition[]) list.toArray(new Competition[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition[] listCompetitionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCompetition(session, condition, orderBy, lockMode);
			return (Competition[]) list.toArray(new Competition[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
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
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateCompetitionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCompetitionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateCompetitionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCompetitionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Competition as Competition");
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
	
	public static java.util.Iterator iterateCompetitionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Competition as Competition");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Competition", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition createCompetition() {
		return new eaproject.dao.Competition();
	}
	
	public static boolean save(eaproject.dao.Competition competition) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(competition);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.Competition competition) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(competition);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.Competition competition)throws PersistentException {
		try {
			eaproject.dao.Trial[] lTrials = competition.trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setCompetition(null);
			}
			return delete(competition);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.Competition competition, org.orm.PersistentSession session)throws PersistentException {
		try {
			eaproject.dao.Trial[] lTrials = competition.trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setCompetition(null);
			}
			try {
				session.delete(competition);
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
	
	public static boolean refresh(eaproject.dao.Competition competition) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(competition);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.Competition competition) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(competition);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByCriteria(CompetitionCriteria competitionCriteria) {
		Competition[] competitions = listCompetitionByCriteria(competitionCriteria);
		if(competitions == null || competitions.length == 0) {
			return null;
		}
		return competitions[0];
	}
	
	public static Competition[] listCompetitionByCriteria(CompetitionCriteria competitionCriteria) {
		return competitionCriteria.listCompetition();
	}
}
