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
public class Grade implements Serializable {
	public Grade() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_GRADE_TRIAL) {
			return ORM_trial;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int GradeId;
	
	private String Name;
	
	private int MinAge;
	
	private int MaxAge;
	
	private double MinWeight;
	
	private double MaxWeight;
	
	private double MinHeight;
	
	private double MaxHeight;
	
	private String Gender;
	
	private java.sql.Timestamp CreationDate;
	
	private java.util.Set ORM_trial = new java.util.HashSet();
	
	private void setGradeId(int value) {
		this.GradeId = value;
	}
	
	public int getGradeId() {
		return GradeId;
	}
	
	public int getORMID() {
		return getGradeId();
	}
	
	public void setName(String value) {
		this.Name = value;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setMinAge(int value) {
		this.MinAge = value;
	}
	
	public int getMinAge() {
		return MinAge;
	}
	
	public void setMaxAge(int value) {
		this.MaxAge = value;
	}
	
	public int getMaxAge() {
		return MaxAge;
	}
	
	public void setMinWeight(double value) {
		this.MinWeight = value;
	}
	
	public double getMinWeight() {
		return MinWeight;
	}
	
	public void setMaxWeight(double value) {
		this.MaxWeight = value;
	}
	
	public double getMaxWeight() {
		return MaxWeight;
	}
	
	public void setMinHeight(double value) {
		this.MinHeight = value;
	}
	
	public double getMinHeight() {
		return MinHeight;
	}
	
	public void setMaxHeight(double value) {
		this.MaxHeight = value;
	}
	
	public double getMaxHeight() {
		return MaxHeight;
	}
	
	public void setGender(String value) {
		this.Gender = value;
	}
	
	public String getGender() {
		return Gender;
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
	
	public final eaproject.dao.TrialSetCollection trial = new eaproject.dao.TrialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_GRADE_TRIAL, orm.ORMConstants.KEY_TRIAL_GRADE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getGradeId());
	}
	
}
