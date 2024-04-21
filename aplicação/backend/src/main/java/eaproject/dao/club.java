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
import java.util.Set;

public class club implements Serializable {
	public club() {
	}
	
	private Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CLUB_TEAM) {
			return ORM_team;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ClubId;
	
	private String Name;
	
	private boolean IsActive;
	
	private java.sql.Timestamp CreationDate;
	
	private java.util.Set ORM_team = new java.util.HashSet();
	
	private void setClubId(int value) {
		this.ClubId = value;
	}
	
	public int getClubId() {
		return ClubId;
	}
	
	public int getORMID() {
		return getClubId();
	}
	
	public void setName(String value) {
		this.Name = value;
	}
	
	public String getName() {
		return Name;
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
	
	private void setORM_Team(java.util.Set value) {
		this.ORM_team = value;
	}
	
	private java.util.Set getORM_Team() {
		return ORM_team;
	}
	
	public final eaproject.dao.teamSetCollection team = new eaproject.dao.teamSetCollection(this, _ormAdapter, ORMConstants.KEY_CLUB_TEAM, ORMConstants.KEY_TEAM_CLUB, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getClubId());
	}
	
}
