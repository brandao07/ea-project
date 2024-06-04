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
@Table(name="grade")
public class Grade implements Serializable {
	public Grade() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_GRADE_TRIAL) {
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
	
	@Column(name="GradeId", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_GRADE_GRADEID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_GRADE_GRADEID_GENERATOR", strategy="native")	
	private int GradeId;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="MinAge", nullable=false, length=10)	
	private int MinAge;
	
	@Column(name="MaxAge", nullable=false, length=10)	
	private int MaxAge;
	
	@Column(name="MinWeight", nullable=false)	
	private double MinWeight;
	
	@Column(name="MaxWeight", nullable=false)	
	private double MaxWeight;
	
	@Column(name="MinHeight", nullable=false)	
	private double MinHeight;
	
	@Column(name="MaxHeight", nullable=false)	
	private double MaxHeight;
	
	@Column(name="Gender", nullable=true, length=255)	
	private String Gender;
	
	@Column(name="CreationDate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	@OneToMany(mappedBy="grade", targetEntity=eaproject.dao.Trial.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
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
	
	@Transient	
	public final eaproject.dao.TrialSetCollection trial = new eaproject.dao.TrialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_GRADE_TRIAL, orm.ORMConstants.KEY_TRIAL_GRADE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getGradeId());
	}
	
}
