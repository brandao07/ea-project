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
	public final StringExpression Gender;
	public final StringExpression Category;
	public final AssociationExpression grade;
	public final IntegerExpression gradeId;
	public final IntegerExpression userId;
	public final AssociationExpression user;
	public final AssociationExpression type;
	public final IntegerExpression typeId;
	public final TimestampExpression StartDate;
	public final TimestampExpression EndDate;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression notification;
	
	public CompetitionCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		Name = new StringExpression("Name", this);
		Gender = new StringExpression("Gender", this);
		Category = new StringExpression("Category", this);
		gradeId = new IntegerExpression("grade.Id", this);
		grade = new AssociationExpression("grade", this);
		userId = new IntegerExpression("user.Id", this);
		user = new AssociationExpression("user", this);
		typeId = new IntegerExpression("type.Id", this);
		type = new AssociationExpression("type", this);
		StartDate = new TimestampExpression("StartDate", this);
		EndDate = new TimestampExpression("EndDate", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		notification = new CollectionExpression("ORM_notification", this);
	}
	
	public CompetitionCriteria(PersistentSession session) {
		this(session.createCriteria(Competition.class));
	}
	
	public CompetitionCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
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

