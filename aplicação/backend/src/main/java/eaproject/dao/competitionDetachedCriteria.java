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

public class CompetitionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final TimestampExpression StartDate;
	public final TimestampExpression EndDate;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	public final CollectionExpression notification;
	
	public CompetitionDetachedCriteria() {
		super(eaproject.dao.Competition.class, eaproject.dao.CompetitionCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		EndDate = new TimestampExpression("EndDate", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_trial", this.getDetachedCriteria());
		notification = new CollectionExpression("ORM_notification", this.getDetachedCriteria());
	}
	
	public CompetitionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.CompetitionCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		EndDate = new TimestampExpression("EndDate", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_trial", this.getDetachedCriteria());
		notification = new CollectionExpression("ORM_notification", this.getDetachedCriteria());
	}
	
	public TrialDetachedCriteria createTrialCriteria() {
		return new TrialDetachedCriteria(createCriteria("ORM_trial"));
	}
	
	public NotificationDetachedCriteria createNotificationCriteria() {
		return new NotificationDetachedCriteria(createCriteria("ORM_notification"));
	}
	
	public Competition uniqueCompetition(PersistentSession session) {
		return (Competition) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Competition[] listCompetition(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Competition[]) list.toArray(new Competition[list.size()]);
	}
}

