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
public class user implements Serializable {
	public user() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_USER_TRIAL) {
			return ORM_trial;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_USER_ROLE) {
			this.role = (eaproject.dao.role) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_USER_TEAM) {
			this.team = (eaproject.dao.team) owner;
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
	
	private int UserId;
	
	private eaproject.dao.role role;
	
	private eaproject.dao.team team;
	
	private String Name;
	
	private String Email;
	
	private String Password;
	
	private String Gender;
	
	private int Age;
	
	private double Height;
	
	private double Weight;
	
	private boolean IsActive;
	
	private java.sql.Timestamp RegisterDate;
	
	private java.util.Set ORM_trial = new java.util.HashSet();
	
	private void setUserId(int value) {
		this.UserId = value;
	}
	
	public int getUserId() {
		return UserId;
	}
	
	public int getORMID() {
		return getUserId();
	}
	
	public void setName(String value) {
		this.Name = value;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setEmail(String value) {
		this.Email = value;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setPassword(String value) {
		this.Password = value;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setGender(String value) {
		this.Gender = value;
	}
	
	public String getGender() {
		return Gender;
	}
	
	public void setAge(int value) {
		this.Age = value;
	}
	
	public int getAge() {
		return Age;
	}
	
	public void setHeight(double value) {
		this.Height = value;
	}
	
	public double getHeight() {
		return Height;
	}
	
	public void setWeight(double value) {
		this.Weight = value;
	}
	
	public double getWeight() {
		return Weight;
	}
	
	public void setIsActive(boolean value) {
		this.IsActive = value;
	}
	
	public boolean getIsActive() {
		return IsActive;
	}
	
	public void setRegisterDate(java.sql.Timestamp value) {
		this.RegisterDate = value;
	}
	
	public java.sql.Timestamp getRegisterDate() {
		return RegisterDate;
	}
	
	public void setRole(eaproject.dao.role value) {
		if (role != null) {
			role.user.remove(this);
		}
		if (value != null) {
			value.user.add(this);
		}
	}
	
	public eaproject.dao.role getRole() {
		return role;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Role(eaproject.dao.role value) {
		this.role = value;
	}
	
	private eaproject.dao.role getORM_Role() {
		return role;
	}
	
	private void setORM_Trial(java.util.Set value) {
		this.ORM_trial = value;
	}
	
	private java.util.Set getORM_Trial() {
		return ORM_trial;
	}
	
	public final eaproject.dao.trialSetCollection trial = new eaproject.dao.trialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_USER_TRIAL, orm.ORMConstants.KEY_TRIAL_USER, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setTeam(eaproject.dao.team value) {
		if (team != null) {
			team.user.remove(this);
		}
		if (value != null) {
			value.user.add(this);
		}
	}
	
	public eaproject.dao.team getTeam() {
		return team;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Team(eaproject.dao.team value) {
		this.team = value;
	}
	
	private eaproject.dao.team getORM_Team() {
		return team;
	}
	
	public String toString() {
		return String.valueOf(getUserId());
	}
	
}
