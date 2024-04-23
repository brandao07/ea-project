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

import java.io.Serializable;
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
			this.location = (dao.Location) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_USER) {
			this.user = (dao.User) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_TYPE) {
			this.type = (dao.Type) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_GRADE) {
			this.grade = (dao.Grade) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_COMPETITION) {
			this.competition = (dao.Competition) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_STATE) {
			this.state = (dao.State) owner;
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
	
	private int TrialId;
	
	private dao.State state;
	
	private dao.Competition competition;
	
	private dao.Grade grade;
	
	private dao.Type type;
	
	private dao.Location location;
	
	private dao.User user;
	
	private String Name;
	
	private java.sql.Timestamp StartDate;
	
	private double Distance;
	
	private String DistanceUnit;
	
	private int NumberOfCheckpoints;
	
	private boolean IsActive;
	
	private java.sql.Timestamp CreationDate;
	
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
	
	public void setLocation(dao.Location value) {
		if (location != null) {
			location.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public dao.Location getLocation() {
		return location;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Location(dao.Location value) {
		this.location = value;
	}
	
	private dao.Location getORM_Location() {
		return location;
	}
	
	private void setORM_Result(java.util.Set value) {
		this.ORM_result = value;
	}
	
	private java.util.Set getORM_Result() {
		return ORM_result;
	}
	
	public final dao.ResultSetCollection result = new dao.ResultSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TRIAL_RESULT, orm.ORMConstants.KEY_RESULT_TRIAL, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setUser(dao.User value) {
		if (user != null) {
			user.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public dao.User getUser() {
		return user;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_User(dao.User value) {
		this.user = value;
	}
	
	private dao.User getORM_User() {
		return user;
	}
	
	public void setType(dao.Type value) {
		if (type != null) {
			type.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public dao.Type getType() {
		return type;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Type(dao.Type value) {
		this.type = value;
	}
	
	private dao.Type getORM_Type() {
		return type;
	}
	
	public void setGrade(dao.Grade value) {
		if (grade != null) {
			grade.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public dao.Grade getGrade() {
		return grade;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Grade(dao.Grade value) {
		this.grade = value;
	}
	
	private dao.Grade getORM_Grade() {
		return grade;
	}
	
	public void setCompetition(dao.Competition value) {
		if (competition != null) {
			competition.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public dao.Competition getCompetition() {
		return competition;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Competition(dao.Competition value) {
		this.competition = value;
	}
	
	private dao.Competition getORM_Competition() {
		return competition;
	}
	
	public void setState(dao.State value) {
		if (state != null) {
			state.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public dao.State getState() {
		return state;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_State(dao.State value) {
		this.state = value;
	}
	
	private dao.State getORM_State() {
		return state;
	}
	
	public String toString() {
		return String.valueOf(getTrialId());
	}
	
}
