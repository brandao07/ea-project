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
public class Team implements Serializable {
	public Team() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_TEAM_USER) {
			return ORM_user;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_TEAM_CLUB) {
			this.club = (dao.Club) owner;
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
	
	private dao.Club club;
	
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
	
	public final dao.UserSetCollection user = new dao.UserSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TEAM_USER, orm.ORMConstants.KEY_USER_TEAM, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setClub(dao.Club value) {
		if (club != null) {
			club.team.remove(this);
		}
		if (value != null) {
			value.team.add(this);
		}
	}
	
	public dao.Club getClub() {
		return club;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Club(dao.Club value) {
		this.club = value;
	}
	
	private dao.Club getORM_Club() {
		return club;
	}
	
	public String toString() {
		return String.valueOf(getTeamId());
	}
	
}
