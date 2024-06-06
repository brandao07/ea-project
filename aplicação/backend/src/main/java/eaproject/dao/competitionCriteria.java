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

public class CompetitionCriteria extends AbstractORMCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final TimestampExpression StartDate;
	public final TimestampExpression EndDate;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	public final CollectionExpression notification;
	
	public CompetitionCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		Name = new StringExpression("Name", this);
		StartDate = new TimestampExpression("StartDate", this);
		EndDate = new TimestampExpression("EndDate", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		trial = new CollectionExpression("ORM_trial", this);
		notification = new CollectionExpression("ORM_notification", this);
	}
	
	public CompetitionCriteria(PersistentSession session) {
		this(session.createCriteria(Competition.class));
	}
	
	public CompetitionCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public TrialCriteria createTrialCriteria() {
		return new TrialCriteria(createCriteria("ORM_trial"));
	}
	
	public NotificationCriteria createNotificationCriteria() {
		return new NotificationCriteria(createCriteria("ORM_notification"));
	}
	
	public Competition uniqueCompetition() {
		return (Competition) super.uniqueResult();
	}
	
	public Competition[] listCompetition() {
		java.util.List list = super.list();
		return (Competition[]) list.toArray(new Competition[list.size()]);
	}
}

