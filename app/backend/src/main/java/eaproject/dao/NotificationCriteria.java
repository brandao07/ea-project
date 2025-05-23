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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class NotificationCriteria extends AbstractORMCriteria {
	public final IntegerExpression Id;
	public final StringExpression MessageHeader;
	public final StringExpression MessageBody;
	public final StringExpression MessageType;
	public final StringExpression PhotographyPath;
	public final TimestampExpression CreationDate;
	
	public NotificationCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		MessageHeader = new StringExpression("MessageHeader", this);
		MessageBody = new StringExpression("MessageBody", this);
		MessageType = new StringExpression("MessageType", this);
		PhotographyPath = new StringExpression("PhotographyPath", this);
		CreationDate = new TimestampExpression("CreationDate", this);
	}
	
	public NotificationCriteria(PersistentSession session) {
		this(session.createCriteria(Notification.class));
	}
	
	public NotificationCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public Notification uniqueNotification() {
		return (Notification) super.uniqueResult();
	}
	
	public Notification[] listNotification() {
		java.util.List list = super.list();
		return (Notification[]) list.toArray(new Notification[list.size()]);
	}
}

