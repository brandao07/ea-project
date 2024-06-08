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
@Table(name="grade")
public class Grade implements Serializable {
	public Grade() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_GRADE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_GRADE_ID_GENERATOR", strategy="increment")	
	private Integer Id;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="Minage", nullable=false, length=10)	
	private Integer MinAge;
	
	@Column(name="Maxage", nullable=false, length=10)	
	private Integer MaxAge;
	
	@Column(name="Gender", nullable=true, length=255)	
	private String Gender;
	
	@Column(name="Creationdate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
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
	
	public void setMinAge(int value) {
		setMinAge(Integer.valueOf(value));
	}
	
	public void setMinAge(Integer value) {
		this.MinAge = value;
	}
	
	public Integer getMinAge() {
		return MinAge;
	}
	
	public void setMaxAge(int value) {
		setMaxAge(Integer.valueOf(value));
	}
	
	public void setMaxAge(Integer value) {
		this.MaxAge = value;
	}
	
	public Integer getMaxAge() {
		return MaxAge;
	}
	
	public void setGender(String value) {
		this.Gender = value;
	}
	
	public String getGender() {
		return Gender;
	}
	
	public void setCreationDate(java.sql.Timestamp value) {
		this.CreationDate = value;
	}
	
	public java.sql.Timestamp getCreationDate() {
		return CreationDate;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
