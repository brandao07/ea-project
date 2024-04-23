/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: User-PC(University of Minho)
 * License Type: Academic
 */
package eaproject.dao;

import java.io.Serializable;
public class trial implements Serializable {
	public trial() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_TRIAL_RESULT) {
			return ORM_result;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_TRIAL_LOCATION) {
			this.location = (eaproject.dao.location) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_USER) {
			this.user = (eaproject.dao.user) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_TYPE) {
			this.type = (eaproject.dao.type) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_GRADE) {
			this.grade = (eaproject.dao.grade) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_COMPETITION) {
			this.competition = (eaproject.dao.competition) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_TRIAL_STATE) {
			this.state = (eaproject.dao.state) owner;
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
	
	private eaproject.dao.state state;
	
	private eaproject.dao.competition competition;
	
	private eaproject.dao.grade grade;
	
	private eaproject.dao.type type;
	
	private eaproject.dao.location location;
	
	private eaproject.dao.user user;
	
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
	
	public void setLocation(eaproject.dao.location value) {
		if (location != null) {
			location.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.location getLocation() {
		return location;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Location(eaproject.dao.location value) {
		this.location = value;
	}
	
	private eaproject.dao.location getORM_Location() {
		return location;
	}
	
	private void setORM_Result(java.util.Set value) {
		this.ORM_result = value;
	}
	
	private java.util.Set getORM_Result() {
		return ORM_result;
	}
	
	public final eaproject.dao.resultSetCollection result = new eaproject.dao.resultSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TRIAL_RESULT, orm.ORMConstants.KEY_RESULT_TRIAL, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setUser(eaproject.dao.user value) {
		if (user != null) {
			user.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.user getUser() {
		return user;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_User(eaproject.dao.user value) {
		this.user = value;
	}
	
	private eaproject.dao.user getORM_User() {
		return user;
	}
	
	public void setType(eaproject.dao.type value) {
		if (type != null) {
			type.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.type getType() {
		return type;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Type(eaproject.dao.type value) {
		this.type = value;
	}
	
	private eaproject.dao.type getORM_Type() {
		return type;
	}
	
	public void setGrade(eaproject.dao.grade value) {
		if (grade != null) {
			grade.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.grade getGrade() {
		return grade;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Grade(eaproject.dao.grade value) {
		this.grade = value;
	}
	
	private eaproject.dao.grade getORM_Grade() {
		return grade;
	}
	
	public void setCompetition(eaproject.dao.competition value) {
		if (competition != null) {
			competition.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.competition getCompetition() {
		return competition;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Competition(eaproject.dao.competition value) {
		this.competition = value;
	}
	
	private eaproject.dao.competition getORM_Competition() {
		return competition;
	}
	
	public void setState(eaproject.dao.state value) {
		if (state != null) {
			state.trial.remove(this);
		}
		if (value != null) {
			value.trial.add(this);
		}
	}
	
	public eaproject.dao.state getState() {
		return state;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_State(eaproject.dao.state value) {
		this.state = value;
	}
	
	private eaproject.dao.state getORM_State() {
		return state;
	}
	
	public String toString() {
		return String.valueOf(getTrialId());
	}
	
}
