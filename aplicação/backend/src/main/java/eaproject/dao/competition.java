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
@org.hibernate.annotations.Proxy(lazy=true)
@Table(name="competition")
public class Competition implements Serializable {
	public Competition() {
	}
	
	private java.util.List this_getList (int key) {
		if (key == orm.ORMConstants.KEY_COMPETITION_NOTIFICATION) {
			return ORM_notification;
		}
		
		return null;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_COMPETITION_TRIAL) {
			return ORM_trial;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_COMPETITION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_COMPETITION_ID_GENERATOR", strategy="native")	
	private int Id;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="StartDate", nullable=true)	
	private java.sql.Timestamp StartDate;
	
	@Column(name="EndDate", nullable=true)	
	private java.sql.Timestamp EndDate;
	
	@Column(name="IsActive", nullable=false)	
	private boolean IsActive;
	
	@Column(name="CreationDate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	@OneToMany(mappedBy="competition", targetEntity=eaproject.dao.Trial.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_trial = new java.util.HashSet();
	
	@OneToMany(mappedBy="competition", targetEntity=eaproject.dao.Notification.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.IndexColumn(name="competitionIndex")	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.List ORM_notification = new java.util.ArrayList();
	
	private void setId(int value) {
		this.Id = value;
	}
	
	public int getId() {
		return Id;
	}
	
	public int getORMID() {
		return getId();
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
	
	@Transient	
	public final eaproject.dao.TrialSetCollection trial = new eaproject.dao.TrialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_COMPETITION_TRIAL, orm.ORMConstants.KEY_TRIAL_COMPETITION, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Notification(java.util.List value) {
		this.ORM_notification = value;
	}
	
	private java.util.List getORM_Notification() {
		return ORM_notification;
	}
	
	@Transient	
	public final eaproject.dao.NotificationListCollection notification = new eaproject.dao.NotificationListCollection(this, _ormAdapter, orm.ORMConstants.KEY_COMPETITION_NOTIFICATION, orm.ORMConstants.KEY_NOTIFICATION_COMPETITION, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
