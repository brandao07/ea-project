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

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=true)
@Table(name="competition")
public class Competition implements Serializable {
	public Competition() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_COMPETITION_NOTIFICATION) {
			return ORM_notification;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_COMPETITION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_COMPETITION_ID_GENERATOR", strategy="increment")	
	private Integer Id;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;

	@Column(name = "Gender", nullable = true, length = 255)
	private String Gender;

	@ManyToOne(targetEntity = eaproject.dao.Grade.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns(value = {@JoinColumn(name = "gradeId", referencedColumnName = "Id", nullable = false)}, foreignKey = @ForeignKey(name = "Requires"))
	private eaproject.dao.Grade grade;

	@ManyToOne(targetEntity = eaproject.dao.Type.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns(value = {@JoinColumn(name = "typeId", referencedColumnName = "Id", nullable = false)}, foreignKey = @ForeignKey(name = "Requires"))
	private eaproject.dao.Type type;

	@ManyToOne(targetEntity = eaproject.dao.User.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns(value = {@JoinColumn(name = "userId", referencedColumnName = "Id", nullable = false)}, foreignKey = @ForeignKey(name = "Requires"))
	private eaproject.dao.User user;

	@Column(name="Startdate", nullable=true)	
	private java.sql.Timestamp StartDate;
	
	@Column(name="Enddate", nullable=true)	
	private java.sql.Timestamp EndDate;
	
	@Column(name="Isactive", nullable=false)	
	private boolean IsActive;
	
	@Column(name="Creationdate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	@OneToMany(targetEntity=eaproject.dao.Notification.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="competitionId", nullable=false) })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_notification = new java.util.HashSet();

	private void setId(int value) {
		setId(Integer.valueOf(value));
	}
	
	private void setId(Integer value) {
		this.Id = value;
	}
	
	public Integer getId() {
		return Id;
	}
	
	public Integer getORMID() {
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
	
	private void setORM_Notification(java.util.Set value) {
		this.ORM_notification = value;
	}
	
	private java.util.Set getORM_Notification() {
		return ORM_notification;
	}
	
	@Transient	
	public final eaproject.dao.NotificationSetCollection notification = new eaproject.dao.NotificationSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_COMPETITION_NOTIFICATION, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}

	public eaproject.dao.Grade getGrade() {
		return grade;
	}

	public void setGrade(eaproject.dao.Grade value) {
		this.grade = value;
	}

	public eaproject.dao.Type getType() {
		return type;
	}

	public void setType(eaproject.dao.Type type) {
		this.type = type;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
