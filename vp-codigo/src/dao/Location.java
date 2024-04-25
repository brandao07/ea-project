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
public class Location implements Serializable {
	public Location() {
	}
	
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
			return (Location) session.load(dao.Location.class, Integer.valueOf(LocationId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location getLocationByORMID(PersistentSession session, int LocationId) throws PersistentException {
		try {
			return (Location) session.get(dao.Location.class, Integer.valueOf(LocationId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location loadLocationByORMID(PersistentSession session, int LocationId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Location) session.load(dao.Location.class, Integer.valueOf(LocationId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Location getLocationByORMID(PersistentSession session, int LocationId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Location) session.get(dao.Location.class, Integer.valueOf(LocationId), lockMode);
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
		StringBuffer sb = new StringBuffer("From dao.Location as Location");
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
		StringBuffer sb = new StringBuffer("From dao.Location as Location");
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
		StringBuffer sb = new StringBuffer("From dao.Location as Location");
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
		StringBuffer sb = new StringBuffer("From dao.Location as Location");
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
	
	public static Location createLocation() {
		return new dao.Location();
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
				lTrials[i].setLocation(null);
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
				lTrials[i].setLocation(null);
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
		if (key == orm.ORMConstants.KEY_LOCATION_TRIAL) {
			return ORM_trial;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int LocationId;
	
	private float Latitude;
	
	private float Longitude;
	
	private String Address;
	
	private String City;
	
	private String Country;
	
	private String PostalCode;
	
	private java.sql.Timestamp CreationDate;
	
	private java.util.Set ORM_trial = new java.util.HashSet();
	
	private void setLocationId(int value) {
		this.LocationId = value;
	}
	
	public int getLocationId() {
		return LocationId;
	}
	
	public int getORMID() {
		return getLocationId();
	}
	
	public void setLatitude(float value) {
		this.Latitude = value;
	}
	
	public float getLatitude() {
		return Latitude;
	}
	
	public void setLongitude(float value) {
		this.Longitude = value;
	}
	
	public float getLongitude() {
		return Longitude;
	}
	
	public void setAddress(String value) {
		this.Address = value;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setCity(String value) {
		this.City = value;
	}
	
	public String getCity() {
		return City;
	}
	
	public void setCountry(String value) {
		this.Country = value;
	}
	
	public String getCountry() {
		return Country;
	}
	
	public void setPostalCode(String value) {
		this.PostalCode = value;
	}
	
	public String getPostalCode() {
		return PostalCode;
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
	
	public final dao.TrialSetCollection trial = new dao.TrialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_LOCATION_TRIAL, orm.ORMConstants.KEY_TRIAL_LOCATION, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getLocationId());
	}
	
}
