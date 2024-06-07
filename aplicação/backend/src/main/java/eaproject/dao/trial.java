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
@Table(name="trial")
public class Trial implements Serializable {
	public Trial() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_TRIAL_RESULT) {
			return ORM_result;
		}
		else if (key == orm.ORMConstants.KEY_TRIAL_TEAM) {
			return ORM_team;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_TRIAL_LOCATION) {
			this.location = (eaproject.dao.Location) owner;
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
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_TRIAL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_TRIAL_ID_GENERATOR", strategy="increment")	
	private int Id;
	
	@ManyToOne(targetEntity=eaproject.dao.State.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="stateId", referencedColumnName="Id", nullable=false) }, foreignKey=@ForeignKey(name="Changes"))	
	private eaproject.dao.State state;
	
	@ManyToOne(targetEntity=eaproject.dao.Competition.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="competitionId", referencedColumnName="Id", nullable=false) }, foreignKey=@ForeignKey(name="Fulfill"))	
	private eaproject.dao.Competition competition;
	
	@ManyToOne(targetEntity=eaproject.dao.Grade.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="gradeId", referencedColumnName="Id", nullable=false) }, foreignKey=@ForeignKey(name="Requires"))	
	private eaproject.dao.Grade grade;
	
	@ManyToOne(targetEntity=eaproject.dao.Type.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="typeId", referencedColumnName="Id", nullable=false) }, foreignKey=@ForeignKey(name="Restricts"))	
	private eaproject.dao.Type type;
	
	@ManyToOne(targetEntity=eaproject.dao.Location.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="locationId", referencedColumnName="Id", nullable=false) }, foreignKey=@ForeignKey(name="Occurs"))	
	private eaproject.dao.Location location;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="Startdate", nullable=true)	
	private java.sql.Timestamp StartDate;
	
	@Column(name="Distance", nullable=false)	
	private double Distance;
	
	@Column(name="Distanceunit", nullable=true, length=255)	
	private String DistanceUnit;
	
	@Column(name="Isactive", nullable=false)	
	private boolean IsActive;
	
	@Column(name="Creationdate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	@ManyToMany(targetEntity=eaproject.dao.Result.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="result_trial", joinColumns={ @JoinColumn(name="TrialId") }, inverseJoinColumns={ @JoinColumn(name="ResultId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_result = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_trial", targetEntity=eaproject.dao.Team.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_team = new java.util.HashSet();
	
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
		this.location = value;
	}
	
	public eaproject.dao.Location getLocation() {
		return location;
	}
	
	private void setORM_Result(java.util.Set value) {
		this.ORM_result = value;
	}
	
	private java.util.Set getORM_Result() {
		return ORM_result;
	}
	
	@Transient	
	public final eaproject.dao.ResultSetCollection result = new eaproject.dao.ResultSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TRIAL_RESULT, orm.ORMConstants.KEY_RESULT_TRIAL, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setType(eaproject.dao.Type value) {
		this.type = value;
	}
	
	public eaproject.dao.Type getType() {
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
		this.state = value;
	}
	
	public eaproject.dao.State getState() {
		return state;
	}
	
	private void setORM_Team(java.util.Set value) {
		this.ORM_team = value;
	}
	
	private java.util.Set getORM_Team() {
		return ORM_team;
	}
	
	@Transient	
	public final eaproject.dao.TeamSetCollection team = new eaproject.dao.TeamSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TRIAL_TEAM, orm.ORMConstants.KEY_TEAM_TRIAL, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
