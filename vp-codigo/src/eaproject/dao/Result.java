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
@Table(name="result")
public class Result implements Serializable {
	public Result() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_RESULT_TRIAL) {
			this.trial = (eaproject.dao.Trial) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ResultId", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_RESULT_RESULTID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_RESULT_RESULTID_GENERATOR", strategy="native")	
	private int ResultId;
	
	@ManyToOne(targetEntity=eaproject.dao.Trial.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TrialTrialId", referencedColumnName="TrialId", nullable=false) }, foreignKey=@ForeignKey(name="Publish"))	
	private eaproject.dao.Trial trial;
	
	@Column(name="Position", nullable=false, length=10)	
	private int Position;
	
	@Column(name="Time", nullable=true)	
	private java.sql.Timestamp Time;
	
	@Column(name="Observations", nullable=true, length=255)	
	private String Observations;
	
	@Column(name="PenaltyTime", nullable=true)	
	private java.sql.Timestamp PenaltyTime;
	
	@Column(name="CreationDate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	private void setResultId(int value) {
		this.ResultId = value;
	}
	
	public int getResultId() {
		return ResultId;
	}
	
	public int getORMID() {
		return getResultId();
	}
	
	public void setPosition(int value) {
		this.Position = value;
	}
	
	public int getPosition() {
		return Position;
	}
	
	public void setTime(java.sql.Timestamp value) {
		this.Time = value;
	}
	
	public java.sql.Timestamp getTime() {
		return Time;
	}
	
	public void setObservations(String value) {
		this.Observations = value;
	}
	
	public String getObservations() {
		return Observations;
	}
	
	public void setPenaltyTime(java.sql.Timestamp value) {
		this.PenaltyTime = value;
	}
	
	public java.sql.Timestamp getPenaltyTime() {
		return PenaltyTime;
	}
	
	public void setCreationDate(java.sql.Timestamp value) {
		this.CreationDate = value;
	}
	
	public java.sql.Timestamp getCreationDate() {
		return CreationDate;
	}
	
	public void setTrial(eaproject.dao.Trial value) {
		if (trial != null) {
			trial.result.remove(this);
		}
		if (value != null) {
			value.result.add(this);
		}
	}
	
	public eaproject.dao.Trial getTrial() {
		return trial;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Trial(eaproject.dao.Trial value) {
		this.trial = value;
	}
	
	private eaproject.dao.Trial getORM_Trial() {
		return trial;
	}
	
	public String toString() {
		return String.valueOf(getResultId());
	}
	
}
