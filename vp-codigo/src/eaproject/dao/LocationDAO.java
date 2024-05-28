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

public class LocationDAO {
	public static Location loadLocationByORMID(int LocationId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadLocationByORMID(session, LocationId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location getLocationByORMID(int LocationId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getLocationByORMID(session, LocationId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location loadLocationByORMID(int LocationId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadLocationByORMID(session, LocationId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location getLocationByORMID(int LocationId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getLocationByORMID(session, LocationId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location loadLocationByORMID(PersistentSession session, int LocationId) throws PersistentException {
		try {
			return (Location) session.load(eaproject.dao.Location.class, Integer.valueOf(LocationId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location getLocationByORMID(PersistentSession session, int LocationId) throws PersistentException {
		try {
			return (Location) session.get(eaproject.dao.Location.class, Integer.valueOf(LocationId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location loadLocationByORMID(PersistentSession session, int LocationId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Location) session.load(eaproject.dao.Location.class, Integer.valueOf(LocationId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location getLocationByORMID(PersistentSession session, int LocationId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Location) session.get(eaproject.dao.Location.class, Integer.valueOf(LocationId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLocation(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryLocation(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLocation(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryLocation(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location[] listLocationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listLocationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location[] listLocationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listLocationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLocation(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Location as Location");
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
	
	public static List queryLocation(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Location as Location");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Location", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location[] listLocationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLocation(session, condition, orderBy);
			return (Location[]) list.toArray(new Location[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location[] listLocationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLocation(session, condition, orderBy, lockMode);
			return (Location[]) list.toArray(new Location[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location loadLocationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadLocationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location loadLocationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadLocationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location loadLocationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Location[] locations = listLocationByQuery(session, condition, orderBy);
		if (locations != null && locations.length > 0)
			return locations[0];
		else
			return null;
	}
	
	public static Location loadLocationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Location[] locations = listLocationByQuery(session, condition, orderBy, lockMode);
		if (locations != null && locations.length > 0)
			return locations[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateLocationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateLocationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLocationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateLocationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLocationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Location as Location");
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
	
	public static java.util.Iterator iterateLocationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Location as Location");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Location", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location createLocation() {
		return new eaproject.dao.Location();
	}
	
	public static boolean save(eaproject.dao.Location location) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(location);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.Location location) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(location);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.Location location)throws PersistentException {
		try {
			eaproject.dao.Trial[] lTrials = location.trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setLocation(null);
			}
			return delete(location);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.Location location, org.orm.PersistentSession session)throws PersistentException {
		try {
			eaproject.dao.Trial[] lTrials = location.trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setLocation(null);
			}
			try {
				session.delete(location);
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
	
	public static boolean refresh(eaproject.dao.Location location) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(location);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.Location location) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(location);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location loadLocationByCriteria(LocationCriteria locationCriteria) {
		Location[] locations = listLocationByCriteria(locationCriteria);
		if(locations == null || locations.length == 0) {
			return null;
		}
		return locations[0];
	}
	
	public static Location[] listLocationByCriteria(LocationCriteria locationCriteria) {
		return locationCriteria.listLocation();
	}
}
