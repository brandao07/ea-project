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

public class competitionCriteria extends AbstractORMCriteria {
	public final IntegerExpression CompetitionId;
	public final StringExpression Name;
	public final TimestampExpression StartDate;
	public final TimestampExpression EndDate;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	public final CollectionExpression notification;
	
	public competitionCriteria(Criteria criteria) {
		super(criteria);
		CompetitionId = new IntegerExpression("CompetitionId", this);
		Name = new StringExpression("Name", this);
		StartDate = new TimestampExpression("StartDate", this);
		EndDate = new TimestampExpression("EndDate", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		trial = new CollectionExpression("ORM_Trial", this);
		notification = new CollectionExpression("ORM_Notification", this);
	}
	
	public competitionCriteria(PersistentSession session) {
		this(session.createCriteria(competition.class));
	}
	
	public competitionCriteria() throws PersistentException {
		this(AASICProjectPersistentManager.instance().getSession());
	}
	
	public trialCriteria createTrialCriteria() {
		return new trialCriteria(createCriteria("ORM_Trial"));
	}
	
	public notificationCriteria createNotificationCriteria() {
		return new notificationCriteria(createCriteria("ORM_Notification"));
	}
	
	public competition uniqueCompetition() {
		return (competition) super.uniqueResult();
	}
	
	public competition[] listCompetition() {
		java.util.List list = super.list();
		return (competition[]) list.toArray(new competition[list.size()]);
	}
}

