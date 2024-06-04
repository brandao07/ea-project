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
@Table(name="club")
public class Club implements Serializable {
	public Club() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_CLUB_TEAM) {
			return ORM_team;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="ClubId", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_CLUB_CLUBID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_CLUB_CLUBID_GENERATOR", strategy="native")	
	private int ClubId;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="IsActive", nullable=false)	
	private boolean IsActive;
	
	@Column(name="CreationDate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	@OneToMany(mappedBy="club", targetEntity=eaproject.dao.Team.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
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
	
	@Transient	
	public final eaproject.dao.TeamSetCollection team = new eaproject.dao.TeamSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CLUB_TEAM, orm.ORMConstants.KEY_TEAM_CLUB, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getClubId());
	}
	
}
