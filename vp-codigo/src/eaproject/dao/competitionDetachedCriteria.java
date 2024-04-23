/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: User-PC(University of Minho)
 * License Type: Academic
 */
package eaproject.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class competitionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression CompetitionId;
	public final StringExpression Name;
	public final TimestampExpression StartDate;
	public final TimestampExpression EndDate;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	public final CollectionExpression notification;
	
	public competitionDetachedCriteria() {
		super(eaproject.dao.competition.class, eaproject.dao.competitionCriteria.class);
		CompetitionId = new IntegerExpression("CompetitionId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		EndDate = new TimestampExpression("EndDate", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
		notification = new CollectionExpression("ORM_Notification", this.getDetachedCriteria());
	}
	
	public competitionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.competitionCriteria.class);
		CompetitionId = new IntegerExpression("CompetitionId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		EndDate = new TimestampExpression("EndDate", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
		notification = new CollectionExpression("ORM_Notification", this.getDetachedCriteria());
	}
	
	public trialDetachedCriteria createTrialCriteria() {
		return new trialDetachedCriteria(createCriteria("ORM_Trial"));
	}
	
	public notificationDetachedCriteria createNotificationCriteria() {
		return new notificationDetachedCriteria(createCriteria("ORM_Notification"));
	}
	
	public competition uniqueCompetition(PersistentSession session) {
		return (competition) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public competition[] listCompetition(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (competition[]) list.toArray(new competition[list.size()]);
	}
}

