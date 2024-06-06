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
@Table(name="`user`")
public class User implements Serializable {
	public User() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_USER_TRIAL) {
			return ORM_trial;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_USER_ROLE) {
			this.role = (eaproject.dao.Role) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_USER_TEAM) {
			this.team = (eaproject.dao.Team) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_USER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_USER_ID_GENERATOR", strategy="native")	
	private int Id;
	
	@ManyToOne(targetEntity=eaproject.dao.Role.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="RoleRoleId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="Belongs"))	
	private eaproject.dao.Role role;
	
	@ManyToOne(targetEntity=eaproject.dao.Team.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TeamTeamId", referencedColumnName="id") }, foreignKey=@ForeignKey(name="Federated"))	
	private eaproject.dao.Team team;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="Email", nullable=true, length=255)	
	private String Email;
	
	@Column(name="Password", nullable=true, length=255)	
	private String Password;
	
	@Column(name="Gender", nullable=true, length=255)	
	private String Gender;
	
	@Column(name="Age", nullable=false, length=10)	
	private int Age;
	
	@Column(name="Height", nullable=false)	
	private double Height;
	
	@Column(name="Weight", nullable=false)	
	private double Weight;
	
	@Column(name="IsActive", nullable=false)	
	private boolean IsActive;
	
	@Column(name="RegisterDate", nullable=true)	
	private java.sql.Timestamp RegisterDate;
	
	@Column(name="PhotographyPath", nullable=true, length=255)	
	private String PhotographyPath;
	
	@ManyToMany(targetEntity=eaproject.dao.Trial.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="trial_user", joinColumns={ @JoinColumn(name="userid") }, inverseJoinColumns={ @JoinColumn(name="trialid") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_trial = new java.util.HashSet();
	
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
	
	public void setEmail(String value) {
		this.Email = value;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setPassword(String value) {
		this.Password = value;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setGender(String value) {
		this.Gender = value;
	}
	
	public String getGender() {
		return Gender;
	}
	
	public void setAge(int value) {
		this.Age = value;
	}
	
	public int getAge() {
		return Age;
	}
	
	public void setHeight(double value) {
		this.Height = value;
	}
	
	public double getHeight() {
		return Height;
	}
	
	public void setWeight(double value) {
		this.Weight = value;
	}
	
	public double getWeight() {
		return Weight;
	}
	
	public void setIsActive(boolean value) {
		this.IsActive = value;
	}
	
	public boolean getIsActive() {
		return IsActive;
	}
	
	public void setRegisterDate(java.sql.Timestamp value) {
		this.RegisterDate = value;
	}
	
	public java.sql.Timestamp getRegisterDate() {
		return RegisterDate;
	}
	
	public void setPhotographyPath(String value) {
		this.PhotographyPath = value;
	}
	
	public String getPhotographyPath() {
		return PhotographyPath;
	}
	
	public void setRole(eaproject.dao.Role value) {
		this.role = value;
	}
	
	public eaproject.dao.Role getRole() {
		return role;
	}
	
	private void setORM_Trial(java.util.Set value) {
		this.ORM_trial = value;
	}
	
	private java.util.Set getORM_Trial() {
		return ORM_trial;
	}
	
	@Transient	
	public final eaproject.dao.TrialSetCollection trial = new eaproject.dao.TrialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_USER_TRIAL, orm.ORMConstants.KEY_TRIAL_USER, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setTeam(eaproject.dao.Team value) {
		if (team != null) {
			team.user.remove(this);
		}
		if (value != null) {
			value.user.add(this);
		}
	}
	
	public eaproject.dao.Team getTeam() {
		return team;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Team(eaproject.dao.Team value) {
		this.team = value;
	}
	
	private eaproject.dao.Team getORM_Team() {
		return team;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
