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
@Table(name="team")
public class Team implements Serializable {
	public Team() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_TEAM_USER) {
			return ORM_user;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_TEAM_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_TEAM_ID_GENERATOR", strategy="native")	
	private int Id;
	
	@ManyToOne(targetEntity=eaproject.dao.Club.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ClubClubId", referencedColumnName="id") }, foreignKey=@ForeignKey(name="Owns"))	
	private eaproject.dao.Club club;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="IsActive", nullable=false)	
	private boolean IsActive;
	
	@Column(name="CreationDate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	@OneToMany(mappedBy="team", targetEntity=eaproject.dao.User.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_user = new java.util.HashSet();
	
	private void setId(int value) {
		this.Id = value;
	}
	
	public int getId() {
		return Id;
	}
	
	public int getORMID() {
		return getId();
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
	
	@Transient	
	public final eaproject.dao.UserSetCollection user = new eaproject.dao.UserSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TEAM_USER, orm.ORMConstants.KEY_USER_TEAM, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setClub(eaproject.dao.Club value) {
		this.club = value;
	}
	
	public eaproject.dao.Club getClub() {
		return club;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
