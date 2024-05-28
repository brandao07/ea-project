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

public class TeamDAO {
	public static Team loadTeamByORMID(int TeamId) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadTeamByORMID(session, TeamId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team getTeamByORMID(int TeamId) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return getTeamByORMID(session, TeamId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByORMID(int TeamId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadTeamByORMID(session, TeamId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team getTeamByORMID(int TeamId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return getTeamByORMID(session, TeamId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByORMID(PersistentSession session, int TeamId) throws PersistentException {
		try {
			return (Team) session.load(eaproject.dao.Team.class, Integer.valueOf(TeamId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team getTeamByORMID(PersistentSession session, int TeamId) throws PersistentException {
		try {
			return (Team) session.get(eaproject.dao.Team.class, Integer.valueOf(TeamId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByORMID(PersistentSession session, int TeamId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Team) session.load(eaproject.dao.Team.class, Integer.valueOf(TeamId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team getTeamByORMID(PersistentSession session, int TeamId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Team) session.get(eaproject.dao.Team.class, Integer.valueOf(TeamId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTeam(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return queryTeam(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTeam(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return queryTeam(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team[] listTeamByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return listTeamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team[] listTeamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return listTeamByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTeam(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Team as Team");
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.Team as Team");
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
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadTeamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Team loadTeamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
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
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return iterateTeamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTeamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return iterateTeamByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTeamByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Team as Team");
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
		StringBuffer sb = new StringBuffer("From eaproject.dao.Team as Team");
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
	
	public static Team createTeam() {
		return new eaproject.dao.Team();
	}
	
	public static boolean save(eaproject.dao.Team team) throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().saveObject(team);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.Team team) throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().deleteObject(team);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.Team team)throws PersistentException {
		try {
			if (team.getClub() != null) {
				team.getClub().team.remove(team);
			}
			
			eaproject.dao.User[] lUsers = team.user.toArray();
			for(int i = 0; i < lUsers.length; i++) {
				lUsers[i].setTeam(null);
			}
			return delete(team);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.Team team, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (team.getClub() != null) {
				team.getClub().team.remove(team);
			}
			
			eaproject.dao.User[] lUsers = team.user.toArray();
			for(int i = 0; i < lUsers.length; i++) {
				lUsers[i].setTeam(null);
			}
			try {
				session.delete(team);
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
	
	public static boolean refresh(eaproject.dao.Team team) throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().getSession().refresh(team);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.Team team) throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().getSession().evict(team);
			return true;
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
}
