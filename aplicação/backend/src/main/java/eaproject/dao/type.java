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
@Table(name="type")
public class Type implements Serializable {
	public Type() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_TYPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_TYPE_ID_GENERATOR", strategy="increment")	
	private Integer Id;
	
	@Column(name="Name", nullable=true, length=255)	
	private String Name;
	
	@Column(name="Numberofpersons", nullable=true)	
	private Integer NumberOfPersons;
	
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
	
	public void setNumberOfPersons(int value) {
		setNumberOfPersons(Integer.valueOf(value));
	}
	
	public void setNumberOfPersons(Integer value) {
		this.NumberOfPersons = value;
	}
	
	public Integer getNumberOfPersons() {
		return NumberOfPersons;
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
