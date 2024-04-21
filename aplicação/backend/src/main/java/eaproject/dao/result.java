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
public class result implements Serializable {
	public result() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_RESULT_TRIAL) {
			this.trial = (eaproject.dao.trial) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ResultId;
	
	private eaproject.dao.trial trial;
	
	private int Position;
	
	private java.sql.Timestamp Time;
	
	private String Observations;
	
	private java.sql.Timestamp PenaltyTime;
	
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
	
	public void setTrial(eaproject.dao.trial value) {
		if (trial != null) {
			trial.result.remove(this);
		}
		if (value != null) {
			value.result.add(this);
		}
	}
	
	public eaproject.dao.trial getTrial() {
		return trial;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Trial(eaproject.dao.trial value) {
		this.trial = value;
	}
	
	private eaproject.dao.trial getORM_Trial() {
		return trial;
	}
	
	public String toString() {
		return String.valueOf(getResultId());
	}
	
}
