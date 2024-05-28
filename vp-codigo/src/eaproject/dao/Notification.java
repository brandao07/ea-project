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
public class Notification implements Serializable {
	public Notification() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_NOTIFICATION_COMPETITION) {
			this.competition = (eaproject.dao.Competition) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int NotificationId;
	
	private eaproject.dao.Competition competition;
	
	private String MessageHeader;
	
	private String MessageBody;
	
	private String MessageType;
	
	private java.sql.Timestamp CreationDate;
	
	private void setNotificationId(int value) {
		this.NotificationId = value;
	}
	
	public int getNotificationId() {
		return NotificationId;
	}
	
	public int getORMID() {
		return getNotificationId();
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
	
	public void setCreationDate(java.sql.Timestamp value) {
		this.CreationDate = value;
	}
	
	public java.sql.Timestamp getCreationDate() {
		return CreationDate;
	}
	
	public void setCompetition(eaproject.dao.Competition value) {
		if (competition != null) {
			competition.notification.remove(this);
		}
		if (value != null) {
			value.notification.add(this);
		}
	}
	
	public eaproject.dao.Competition getCompetition() {
		return competition;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Competition(eaproject.dao.Competition value) {
		this.competition = value;
	}
	
	private eaproject.dao.Competition getORM_Competition() {
		return competition;
	}
	
	public String toString() {
		return String.valueOf(getNotificationId());
	}
	
}
