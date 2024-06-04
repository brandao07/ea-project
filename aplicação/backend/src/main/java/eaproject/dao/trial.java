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
@Table(name="trial")
public class Trial implements Serializable {
	public Trial() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_TRIAL_RESULT) {
			return ORM_result;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_TRIAL_LOCATION) {
			this.location = (eaproject.dao.Location) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_USER) {
			this.user = (eaproject.dao.User) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_TYPE) {
			this.type = (eaproject.dao.Type) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_GRADE) {
			this.grade = (eaproject.dao.Grade) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_COMPETITION) {
			this.competition = (eaproject.dao.Competition) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_STATE) {
			this.state = (eaproject.dao.State) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="TrialId", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_TRIAL_TRIALID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_TRIAL_TRIALID_GENERATOR", strategy="native")	
	private int TrialId;
	
	@ManyToOne(targetEntity=eaproject.dao.State.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="StateStateId", referencedColumnName="StateId", nullable=false) }, foreignKey=@ForeignKey(name="Changes"))	
	private eaproject.dao.State state;
	
	@ManyToOne(targetEntity=eaproject.dao.Competition.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="CompetitionCompetitionId", referencedColumnName="CompetitionId", nullable=false) }, foreignKey=@ForeignKey(name="Fulfill"))	
	private eaproject.dao.Competition competition;
	
	@ManyToOne(targetEntity=eaproject.dao.Grade.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="GradeGradeId", referencedColumnName="GradeId", nullable=false) }, foreignKey=@ForeignKey(name="Requires"))	
	private eaproject.dao.Grade grade;
	
	@ManyToOne(targetEntity=eaproject.dao.Type.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TypeTypeId", referencedColumnName="TypeId", nullable=false) }, foreignKey=@ForeignKey(name="Restricts"))	
	private eaproject.dao.Type type;
	
	@ManyToOne(targetEntity=eaproject.dao.Location.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="LocationLocationId", referencedColumnName="LocationId", nullable=false) }, foreignKey=@ForeignKey(name="Occurs"))	
	private eaproject.dao.Location location;
	
	@ManyToOne(targetEntity=eaproject.dao.User.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UserUserId", referencedColumnName="UserId", nullable=false) }, foreignKey=@ForeignKey(name="Participates"))	
	private eaproject.dao.User user;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="StartDate", nullable=true)	
	private java.sql.Timestamp StartDate;
	
	@Column(name="Distance", nullable=false)	
	private double Distance;
	
	@Column(name="DistanceUnit", nullable=true, length=255)	
	private String DistanceUnit;
	
	@Column(name="NumberOfCheckpoints", nullable=false, length=10)	
	private int NumberOfCheckpoints;
	
	@Column(name="IsActive", nullable=false)	
	private boolean IsActive;
	
	@Column(name="CreationDate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	@OneToMany(mappedBy="trial", targetEntity=eaproject.dao.Result.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_result = new java.util.HashSet();
	
	private void setTrialId(int value) {
		this.TrialId = value;
	}
	
	public int getTrialId() {
		return TrialId;
	}
	
	public int getORMID() {
		return getTrialId();
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
	
	public void setDistance(double value) {
		this.Distance = value;
	}
	
	public double getDistance() {
		return Distance;
	}
	
	public void setDistanceUnit(String value) {
		this.DistanceUnit = value;
	}
	
	public String getDistanceUnit() {
		return DistanceUnit;
	}
	
	public void setNumberOfCheckpoints(int value) {
		this.NumberOfCheckpoints = value;
	}
	
	public int getNumberOfCheckpoints() {
		return NumberOfCheckpoints;
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
	
	public void setLocation(eaproject.dao.Location value) {
		if (location != null) {
			location.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.Location getLocation() {
		return location;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Location(eaproject.dao.Location value) {
		this.location = value;
	}
	
	private eaproject.dao.Location getORM_Location() {
		return location;
	}
	
	private void setORM_Result(java.util.Set value) {
		this.ORM_result = value;
	}
	
	private java.util.Set getORM_Result() {
		return ORM_result;
	}
	
	@Transient	
	public final eaproject.dao.ResultSetCollection result = new eaproject.dao.ResultSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TRIAL_RESULT, orm.ORMConstants.KEY_RESULT_TRIAL, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setUser(eaproject.dao.User value) {
		if (user != null) {
			user.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.User getUser() {
		return user;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_User(eaproject.dao.User value) {
		this.user = value;
	}
	
	private eaproject.dao.User getORM_User() {
		return user;
	}
	
	public void setType(eaproject.dao.Type value) {
		if (type != null) {
			type.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.Type getType() {
		return type;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Type(eaproject.dao.Type value) {
		this.type = value;
	}
	
	private eaproject.dao.Type getORM_Type() {
		return type;
	}
	
	public void setGrade(eaproject.dao.Grade value) {
		if (grade != null) {
			grade.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.Grade getGrade() {
		return grade;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Grade(eaproject.dao.Grade value) {
		this.grade = value;
	}
	
	private eaproject.dao.Grade getORM_Grade() {
		return grade;
	}
	
	public void setCompetition(eaproject.dao.Competition value) {
		if (competition != null) {
			competition.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.Competition getCompetition() {
		return competition;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Competition(eaproject.dao.Competition value) {
		this.competition = value;
	}
	
	private eaproject.dao.Competition getORM_Competition() {
		return competition;
	}
	
	public void setState(eaproject.dao.State value) {
		if (state != null) {
			state.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.State getState() {
		return state;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_State(eaproject.dao.State value) {
		this.state = value;
	}
	
	private eaproject.dao.State getORM_State() {
		return state;
	}
	
	public String toString() {
		return String.valueOf(getTrialId());
	}
	
}
