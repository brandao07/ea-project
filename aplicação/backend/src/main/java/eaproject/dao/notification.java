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
@Table(name="notification")
public class Notification implements Serializable {
	public Notification() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_NOTIFICATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_NOTIFICATION_ID_GENERATOR", strategy="increment")	
	private Integer Id;
	
	@Column(name="Messageheader", nullable=true, length=255)	
	private String MessageHeader;
	
	@Column(name="Messagebody", nullable=true, length=255)	
	private String MessageBody;
	
	@Column(name="Messagetype", nullable=true, length=255)	
	private String MessageType;
	
	@Column(name="Photographypath", nullable=true, length=255)	
	private String PhotographyPath;
	
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
	
	public void setMessageHeader(String value) {
		this.MessageHeader = value;
	}
	
	public String getMessageHeader() {
		return MessageHeader;
	}
	
	public void setMessageBody(String value) {
		this.MessageBody = value;
	}
	
	public String getMessageBody() {
		return MessageBody;
	}
	
	public void setMessageType(String value) {
		this.MessageType = value;
	}
	
	public String getMessageType() {
		return MessageType;
	}
	
	public void setPhotographyPath(String value) {
		this.PhotographyPath = value;
	}
	
	public String getPhotographyPath() {
		return PhotographyPath;
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
