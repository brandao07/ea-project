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

public class competitionDAO {
	public static competition loadCompetitionByORMID(int CompetitionId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByORMID(session, CompetitionId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition getCompetitionByORMID(int CompetitionId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getCompetitionByORMID(session, CompetitionId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition loadCompetitionByORMID(int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByORMID(session, CompetitionId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition getCompetitionByORMID(int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getCompetitionByORMID(session, CompetitionId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition loadCompetitionByORMID(PersistentSession session, int CompetitionId) throws PersistentException {
		try {
			return (competition) session.load(eaproject.dao.competition.class, Integer.valueOf(CompetitionId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition getCompetitionByORMID(PersistentSession session, int CompetitionId) throws PersistentException {
		try {
			return (competition) session.get(eaproject.dao.competition.class, Integer.valueOf(CompetitionId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition loadCompetitionByORMID(PersistentSession session, int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (competition) session.load(eaproject.dao.competition.class, Integer.valueOf(CompetitionId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition getCompetitionByORMID(PersistentSession session, int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (competition) session.get(eaproject.dao.competition.class, Integer.valueOf(CompetitionId), lockMode);
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
	
	public static competition[] listCompetitionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listCompetitionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition[] listCompetitionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.competition as competition");
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.competition as competition");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("competition", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition[] listCompetitionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCompetition(session, condition, orderBy);
			return (competition[]) list.toArray(new competition[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition[] listCompetitionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCompetition(session, condition, orderBy, lockMode);
			return (competition[]) list.toArray(new competition[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition loadCompetitionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition loadCompetitionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition loadCompetitionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		competition[] competitions = listCompetitionByQuery(session, condition, orderBy);
		if (competitions != null && competitions.length > 0)
			return competitions[0];
		else
			return null;
	}
	
	public static competition loadCompetitionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		competition[] competitions = listCompetitionByQuery(session, condition, orderBy, lockMode);
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.competition as competition");
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.competition as competition");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("competition", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition createCompetition() {
		return new eaproject.dao.competition();
	}
	
	public static boolean save(eaproject.dao.competition lcompetition) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(lcompetition);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.competition lcompetition) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(lcompetition);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.competition lcompetition)throws PersistentException {
		try {
			eaproject.dao.trial[] lTrials = lcompetition.trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setCompetition(null);
			}
			eaproject.dao.notification[] lNotifications = lcompetition.notification.toArray();
			for(int i = 0; i < lNotifications.length; i++) {
				lNotifications[i].setCompetition(null);
			}
			return delete(lcompetition);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.competition lcompetition, org.orm.PersistentSession session)throws PersistentException {
		try {
			eaproject.dao.trial[] lTrials = lcompetition.trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setCompetition(null);
			}
			eaproject.dao.notification[] lNotifications = lcompetition.notification.toArray();
			for(int i = 0; i < lNotifications.length; i++) {
				lNotifications[i].setCompetition(null);
			}
			try {
				session.delete(lcompetition);
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
	
	public static boolean refresh(eaproject.dao.competition lcompetition) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(lcompetition);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.competition lcompetition) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(lcompetition);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static competition loadCompetitionByCriteria(competitionCriteria competitionCriteria) {
		competition[] competitions = listCompetitionByCriteria(competitionCriteria);
		if(competitions == null || competitions.length == 0) {
			return null;
		}
		return competitions[0];
	}
	
	public static competition[] listCompetitionByCriteria(competitionCriteria competitionCriteria) {
		return competitionCriteria.listCompetition();
	}
}
