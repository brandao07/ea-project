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
@Table(name="result")
public class Result implements Serializable {
	public Result() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_RESULT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_RESULT_ID_GENERATOR", strategy="increment")	
	private int Id;
	
	@Column(name="Position", nullable=false, length=10)	
	private int Position;
	
	@Column(name="Time", nullable=true)	
	private java.sql.Timestamp Time;
	
	@Column(name="Observations", nullable=true, length=255)	
	private String Observations;
	
	@Column(name="Penaltytime", nullable=true)	
	private java.sql.Timestamp PenaltyTime;
	
	@Column(name="Creationdate", nullable=true)	
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
	
	public void setPosition(int value) {
		this.Position = value;
	}
	
	public int getPosition() {
		return Position;
	}
	
	public void setTime(java.sql.Timestamp value) {
		this.Time = value;
	}
	
	public java.sql.Timestamp getTime() {
		return Time;
	}
	
	public void setObservations(String value) {
		this.Observations = value;
	}
	
	public String getObservations() {
		return Observations;
	}
	
	public void setPenaltyTime(java.sql.Timestamp value) {
		this.PenaltyTime = value;
	}
	
	public java.sql.Timestamp getPenaltyTime() {
		return PenaltyTime;
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
