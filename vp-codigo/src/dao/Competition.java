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
package dao;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
public class Competition implements Serializable {
	public Competition() {
	}
	
	public static Competition loadCompetitionByORMID(int CompetitionId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByORMID(session, CompetitionId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition getCompetitionByORMID(int CompetitionId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getCompetitionByORMID(session, CompetitionId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByORMID(int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadCompetitionByORMID(session, CompetitionId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition getCompetitionByORMID(int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getCompetitionByORMID(session, CompetitionId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByORMID(PersistentSession session, int CompetitionId) throws PersistentException {
		try {
			return (Competition) session.load(dao.Competition.class, Integer.valueOf(CompetitionId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition getCompetitionByORMID(PersistentSession session, int CompetitionId) throws PersistentException {
		try {
			return (Competition) session.get(dao.Competition.class, Integer.valueOf(CompetitionId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition loadCompetitionByORMID(PersistentSession session, int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Competition) session.load(dao.Competition.class, Integer.valueOf(CompetitionId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Competition getCompetitionByORMID(PersistentSession session, int CompetitionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Competition) session.get(dao.Competition.class, Integer.valueOf(CompetitionId), lockMode);
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
		StringBuffer sb = new StringBuffer("From dao.Competition as Competition");
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
		StringBuffer sb = new StringBuffer("From dao.Competition as Competition");
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
		StringBuffer sb = new StringBuffer("From dao.Competition as Competition");
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
		StringBuffer sb = new StringBuffer("From dao.Competition as Competition");
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
	
	public static Competition createCompetition() {
		return new dao.Competition();
	}
	
	public boolean save() throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			dao.Trial[] lTrials = trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setCompetition(null);
			}
			dao.Notification[] lNotifications = notification.toArray();
			for(int i = 0; i < lNotifications.length; i++) {
				lNotifications[i].setCompetition(null);
			}
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			dao.Trial[] lTrials = trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setCompetition(null);
			}
			dao.Notification[] lNotifications = notification.toArray();
			for(int i = 0; i < lNotifications.length; i++) {
				lNotifications[i].setCompetition(null);
			}
			try {
				session.delete(this);
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
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_COMPETITION_TRIAL) {
			return ORM_trial;
		}
		else if (key == orm.ORMConstants.KEY_COMPETITION_NOTIFICATION) {
			return ORM_notification;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int CompetitionId;
	
	private String Name;
	
	private java.sql.Timestamp StartDate;
	
	private java.sql.Timestamp EndDate;
	
	private boolean IsActive;
	
	private java.sql.Timestamp CreationDate;
	
	private java.util.Set ORM_trial = new java.util.HashSet();
	
	private java.util.Set ORM_notification = new java.util.HashSet();
	
	private void setCompetitionId(int value) {
		this.CompetitionId = value;
	}
	
	public int getCompetitionId() {
		return CompetitionId;
	}
	
	public int getORMID() {
		return getCompetitionId();
	}
	
	public void setName(String value) {
		this.Name = value;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setStartDate(java.sql.Timestamp value) {
		this.StartDate = value;
	}
	
	public java.sql.Timestamp getStartDate() {
		return StartDate;
	}
	
	public void setEndDate(java.sql.Timestamp value) {
		this.EndDate = value;
	}
	
	public java.sql.Timestamp getEndDate() {
		return EndDate;
	}
	
	public void setIsActive(boolean value) {
		this.IsActive = value;
	}
	
	public boolean getIsActive() {
		return IsActive;
	}
	
	public void setCreationDate(java.sql.Timestamp value) {
		this.CreationDate = value;
	}
	
	public java.sql.Timestamp getCreationDate() {
		return CreationDate;
	}
	
	private void setORM_Trial(java.util.Set value) {
		this.ORM_trial = value;
	}
	
	private java.util.Set getORM_Trial() {
		return ORM_trial;
	}
	
	public final dao.TrialSetCollection trial = new dao.TrialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_COMPETITION_TRIAL, orm.ORMConstants.KEY_TRIAL_COMPETITION, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Notification(java.util.Set value) {
		this.ORM_notification = value;
	}
	
	private java.util.Set getORM_Notification() {
		return ORM_notification;
	}
	
	public final dao.NotificationSetCollection notification = new dao.NotificationSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_COMPETITION_NOTIFICATION, orm.ORMConstants.KEY_NOTIFICATION_COMPETITION, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getCompetitionId());
	}
	
}
