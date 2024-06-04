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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="location")
public class Location implements Serializable {
	public Location() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_LOCATION_TRIAL) {
			return ORM_trial;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="LocationId", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_LOCATION_LOCATIONID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_LOCATION_LOCATIONID_GENERATOR", strategy="native")	
	private int LocationId;
	
	@Column(name="Latitude", nullable=false)	
	private float Latitude;
	
	@Column(name="Longitude", nullable=false)	
	private float Longitude;
	
	@Column(name="Address", nullable=true, length=255)	
	private String Address;
	
	@Column(name="City", nullable=true, length=255)	
	private String City;
	
	@Column(name="Country", nullable=true, length=255)	
	private String Country;
	
	@Column(name="PostalCode", nullable=true, length=255)	
	private String PostalCode;
	
	@Column(name="CreationDate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	@OneToMany(mappedBy="location", targetEntity=eaproject.dao.Trial.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
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
	
	@Transient	
	public final eaproject.dao.TrialSetCollection trial = new eaproject.dao.TrialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_LOCATION_TRIAL, orm.ORMConstants.KEY_TRIAL_LOCATION, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getLocationId());
	}
	
}
