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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class NotificationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression Id;
	public final StringExpression MessageHeader;
	public final StringExpression MessageBody;
	public final StringExpression MessageType;
	public final StringExpression PhotographyPath;
	public final TimestampExpression CreationDate;
	
	public NotificationDetachedCriteria() {
		super(eaproject.dao.Notification.class, eaproject.dao.NotificationCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		MessageHeader = new StringExpression("MessageHeader", this.getDetachedCriteria());
		MessageBody = new StringExpression("MessageBody", this.getDetachedCriteria());
		MessageType = new StringExpression("MessageType", this.getDetachedCriteria());
		PhotographyPath = new StringExpression("PhotographyPath", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public NotificationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.NotificationCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		MessageHeader = new StringExpression("MessageHeader", this.getDetachedCriteria());
		MessageBody = new StringExpression("MessageBody", this.getDetachedCriteria());
		MessageType = new StringExpression("MessageType", this.getDetachedCriteria());
		PhotographyPath = new StringExpression("PhotographyPath", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public Notification uniqueNotification(PersistentSession session) {
		return (Notification) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Notification[] listNotification(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Notification[]) list.toArray(new Notification[list.size()]);
	}
}

