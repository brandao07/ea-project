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
public class state implements Serializable {
	public state() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_STATE_TRIAL) {
			return ORM_trial;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int StateId;
	
	private String Nome;
	
	private java.sql.Timestamp CreationDate;
	
	private java.util.Set ORM_trial = new java.util.HashSet();
	
	private void setStateId(int value) {
		this.StateId = value;
	}
	
	public int getStateId() {
		return StateId;
	}
	
	public int getORMID() {
		return getStateId();
	}
	
	public void setNome(String value) {
		this.Nome = value;
	}
	
	public String getNome() {
		return Nome;
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
	
	public final eaproject.dao.trialSetCollection trial = new eaproject.dao.trialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_STATE_TRIAL, orm.ORMConstants.KEY_TRIAL_STATE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getStateId());
	}
	
}
