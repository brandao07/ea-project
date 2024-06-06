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
@Table(name="role")
public class Role implements Serializable {
	public Role() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_ROLE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_ROLE_ID_GENERATOR", strategy="native")	
	private int Id;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="Description", nullable=true, length=255)	
	private String Description;
	
	@Column(name="CreationDate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
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
	
	public void setDescription(String value) {
		this.Description = value;
	}
	
	public String getDescription() {
		return Description;
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
