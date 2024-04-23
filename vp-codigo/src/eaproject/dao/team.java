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
public class team implements Serializable {
	public team() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_TEAM_USER) {
			return ORM_user;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_TEAM_CLUB) {
			this.club = (eaproject.dao.club) owner;
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
	
	private int TeamId;
	
	private eaproject.dao.club club;
	
	private String Name;
	
	private boolean IsActive;
	
	private java.sql.Timestamp CreationDate;
	
	private java.util.Set ORM_user = new java.util.HashSet();
	
	private void setTeamId(int value) {
		this.TeamId = value;
	}
	
	public int getTeamId() {
		return TeamId;
	}
	
	public int getORMID() {
		return getTeamId();
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
	
	private void setORM_User(java.util.Set value) {
		this.ORM_user = value;
	}
	
	private java.util.Set getORM_User() {
		return ORM_user;
	}
	
	public final eaproject.dao.userSetCollection user = new eaproject.dao.userSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TEAM_USER, orm.ORMConstants.KEY_USER_TEAM, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setClub(eaproject.dao.club value) {
		if (club != null) {
			club.team.remove(this);
		}
		if (value != null) {
			value.team.add(this);
		}
	}
	
	public eaproject.dao.club getClub() {
		return club;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Club(eaproject.dao.club value) {
		this.club = value;
	}
	
	private eaproject.dao.club getORM_Club() {
		return club;
	}
	
	public String toString() {
		return String.valueOf(getTeamId());
	}
	
}
