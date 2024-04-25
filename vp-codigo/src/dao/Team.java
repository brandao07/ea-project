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
public class Team implements Serializable {
	public Team() {
	}
	
	public static Team loadTeamByORMID(int TeamId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTeamByORMID(session, TeamId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team getTeamByORMID(int TeamId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getTeamByORMID(session, TeamId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByORMID(int TeamId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTeamByORMID(session, TeamId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team getTeamByORMID(int TeamId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getTeamByORMID(session, TeamId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByORMID(PersistentSession session, int TeamId) throws PersistentException {
		try {
			return (Team) session.load(dao.Team.class, Integer.valueOf(TeamId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team getTeamByORMID(PersistentSession session, int TeamId) throws PersistentException {
		try {
			return (Team) session.get(dao.Team.class, Integer.valueOf(TeamId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByORMID(PersistentSession session, int TeamId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Team) session.load(dao.Team.class, Integer.valueOf(TeamId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team getTeamByORMID(PersistentSession session, int TeamId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Team) session.get(dao.Team.class, Integer.valueOf(TeamId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTeam(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryTeam(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTeam(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryTeam(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team[] listTeamByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listTeamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team[] listTeamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listTeamByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTeam(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From dao.Team as Team");
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
	
	public static List queryTeam(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From dao.Team as Team");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Team", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team[] listTeamByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTeam(session, condition, orderBy);
			return (Team[]) list.toArray(new Team[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team[] listTeamByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTeam(session, condition, orderBy, lockMode);
			return (Team[]) list.toArray(new Team[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTeamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadTeamByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Team[] teams = listTeamByQuery(session, condition, orderBy);
		if (teams != null && teams.length > 0)
			return teams[0];
		else
			return null;
	}
	
	public static Team loadTeamByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Team[] teams = listTeamByQuery(session, condition, orderBy, lockMode);
		if (teams != null && teams.length > 0)
			return teams[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTeamByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateTeamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTeamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateTeamByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTeamByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From dao.Team as Team");
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
	
	public static java.util.Iterator iterateTeamByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From dao.Team as Team");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Team", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByCriteria(TeamCriteria teamCriteria) {
		Team[] teams = listTeamByCriteria(teamCriteria);
		if(teams == null || teams.length == 0) {
			return null;
		}
		return teams[0];
	}
	
	public static Team[] listTeamByCriteria(TeamCriteria teamCriteria) {
		return teamCriteria.listTeam();
	}
	
	public static Team createTeam() {
		return new dao.Team();
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
			if(getClub() != null) {
				getClub().team.remove(this);
			}
			
			dao.User[] lUsers = user.toArray();
			for(int i = 0; i < lUsers.length; i++) {
				lUsers[i].setTeam(null);
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
			if(getClub() != null) {
				getClub().team.remove(this);
			}
			
			dao.User[] lUsers = user.toArray();
			for(int i = 0; i < lUsers.length; i++) {
				lUsers[i].setTeam(null);
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
		if (key == orm.ORMConstants.KEY_TEAM_USER) {
			return ORM_user;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_TEAM_CLUB) {
			this.club = (dao.Club) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int TeamId;
	
	private dao.Club club;
	
	private String Name;
	
	private boolean IsActive;
	
	private java.sql.Timestamp CreationDate;
	
	private java.util.Set ORM_user = new java.util.HashSet();
	
	private void setTeamId(int value) {
		this.TeamId = value;
	}
	
	public int getTeamId() {
		return TeamId;
	}
	
	public int getORMID() {
		return getTeamId();
	}
	
	public void setName(String value) {
		this.Name = value;
	}
	
	public String getName() {
		return Name;
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
	
	private void setORM_User(java.util.Set value) {
		this.ORM_user = value;
	}
	
	private java.util.Set getORM_User() {
		return ORM_user;
	}
	
	public final dao.UserSetCollection user = new dao.UserSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TEAM_USER, orm.ORMConstants.KEY_USER_TEAM, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setClub(dao.Club value) {
		if (club != null) {
			club.team.remove(this);
		}
		if (value != null) {
			value.team.add(this);
		}
	}
	
	public dao.Club getClub() {
		return club;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Club(dao.Club value) {
		this.club = value;
	}
	
	private dao.Club getORM_Club() {
		return club;
	}
	
	public String toString() {
		return String.valueOf(getTeamId());
	}
	
}
