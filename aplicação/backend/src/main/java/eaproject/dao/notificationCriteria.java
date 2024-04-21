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

public class notificationCriteria extends AbstractORMCriteria {
	public final IntegerExpression NotificationId;
	public final IntegerExpression competitionId;
	public final AssociationExpression competition;
	public final StringExpression MessageHeader;
	public final StringExpression MessageBody;
	public final StringExpression MessageType;
	public final TimestampExpression CreationDate;
	
	public notificationCriteria(Criteria criteria) {
		super(criteria);
		NotificationId = new IntegerExpression("NotificationId", this);
		competitionId = new IntegerExpression("competition.CompetitionId", this);
		competition = new AssociationExpression("competition", this);
		MessageHeader = new StringExpression("MessageHeader", this);
		MessageBody = new StringExpression("MessageBody", this);
		MessageType = new StringExpression("MessageType", this);
		CreationDate = new TimestampExpression("CreationDate", this);
	}
	
	public notificationCriteria(PersistentSession session) {
		this(session.createCriteria(notification.class));
	}
	
	public notificationCriteria() throws PersistentException {
		this(AASICProjectPersistentManager.instance().getSession());
	}
	
	public competitionCriteria createCompetitionCriteria() {
		return new competitionCriteria(createCriteria("competition"));
	}
	
	public notification uniqueNotification() {
		return (notification) super.uniqueResult();
	}
	
	public notification[] listNotification() {
		java.util.List list = super.list();
		return (notification[]) list.toArray(new notification[list.size()]);
	}
}

