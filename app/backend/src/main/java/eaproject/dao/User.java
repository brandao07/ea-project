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
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_USER_ROLE) {
			this.role = (eaproject.dao.Role) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_USER_CLUB) {
			this.club = (eaproject.dao.Club) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_USER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_USER_ID_GENERATOR", strategy="increment")	
	private Integer Id;
	
	@ManyToOne(targetEntity=eaproject.dao.Club.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="clubId", referencedColumnName="Id") }, foreignKey=@ForeignKey(name="Owns2"))	
	private eaproject.dao.Club club;
	
	@ManyToOne(targetEntity=eaproject.dao.Role.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="roleId", referencedColumnName="Id", nullable=false) }, foreignKey=@ForeignKey(name="Belongs"))	
	private eaproject.dao.Role role;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="Email", nullable=true, length=255)	
	private String Email;
	
	@Column(name="Password", nullable=true, length=255)	
	private String Password;
	
	@Column(name="Gender", nullable=true, length=255)	
	private String Gender;
	
	@Column(name="Age", nullable=false, length=10)	
	private Integer Age;
	
	@Column(name="Height", nullable=false)	
	private Double Height;
	
	@Column(name="Weight", nullable=false)	
	private Double Weight;
	
	@Column(name="Isactive", nullable=false)	
	private boolean IsActive;
	
	@Column(name="Registerdate", nullable=true)	
	private java.sql.Timestamp RegisterDate;
	
	@Column(name="Photographypath", nullable=true, length=255)	
	private String PhotographyPath;
	
	private void setId(int value) {
		setId(Integer.valueOf(value));
	}
	
	private void setId(Integer value) {
		this.Id = value;
	}
	
	public Integer getId() {
		return Id;
	}
	
	public Integer getORMID() {
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
		setAge(Integer.valueOf(value));
	}
	
	public void setAge(Integer value) {
		this.Age = value;
	}
	
	public Integer getAge() {
		return Age;
	}
	
	public void setHeight(double value) {
		setHeight(Double.valueOf(value));
	}
	
	public void setHeight(Double value) {
		this.Height = value;
	}
	
	public Double getHeight() {
		return Height;
	}
	
	public void setWeight(double value) {
		setWeight(Double.valueOf(value));
	}
	
	public void setWeight(Double value) {
		this.Weight = value;
	}
	
	public Double getWeight() {
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
	
	public String getPhotographyPath() { return PhotographyPath; }
	
	public void setRole(eaproject.dao.Role value) {
		this.role = value;
	}
	
	public eaproject.dao.Role getRole() {
		return role;
	}
	
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
