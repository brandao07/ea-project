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

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import java.util.List;

public class CompetitionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final StringExpression Gender;
	public final AssociationExpression grade;
	public final IntegerExpression gradeId;
	public final AssociationExpression type;
	public final IntegerExpression typeId;
	public final IntegerExpression userId;
	public final AssociationExpression user;
	public final TimestampExpression StartDate;
	public final TimestampExpression EndDate;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression notification;
	
	public CompetitionDetachedCriteria() {
		super(eaproject.dao.Competition.class, eaproject.dao.CompetitionCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Gender = new StringExpression("Gender", this.getDetachedCriteria());
		gradeId = new IntegerExpression("grade.Id", this.getDetachedCriteria());
		grade = new AssociationExpression("grade", this.getDetachedCriteria());
		userId = new IntegerExpression("user.Id", this.getDetachedCriteria());
		user = new AssociationExpression("user", this.getDetachedCriteria());
		typeId = new IntegerExpression("type.Id", this.getDetachedCriteria());
		type = new AssociationExpression("type", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		EndDate = new TimestampExpression("EndDate", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		notification = new CollectionExpression("ORM_notification", this.getDetachedCriteria());
	}
	
	public CompetitionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.CompetitionCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Gender = new StringExpression("Gender", this.getDetachedCriteria());
		gradeId = new IntegerExpression("grade.Id", this.getDetachedCriteria());
		grade = new AssociationExpression("grade", this.getDetachedCriteria());
		typeId = new IntegerExpression("type.Id", this.getDetachedCriteria());
		type = new AssociationExpression("type", this.getDetachedCriteria());
		userId = new IntegerExpression("user.Id", this.getDetachedCriteria());
		user = new AssociationExpression("user", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		EndDate = new TimestampExpression("EndDate", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		notification = new CollectionExpression("ORM_notification", this.getDetachedCriteria());
	}
	
	public NotificationDetachedCriteria createNotificationCriteria() {
		return new NotificationDetachedCriteria(createCriteria("ORM_notification"));
	}
	
	public Competition uniqueCompetition(PersistentSession session) {
		return (Competition) super.createExecutableCriteria(session).uniqueResult();
	}

	public TypeDetachedCriteria createTypeCriteria() {
		return new TypeDetachedCriteria(createCriteria("type"));
	}

	public UserDetachedCriteria createUserCriteria() {
		return new UserDetachedCriteria(createCriteria("user"));
	}

	public GradeDetachedCriteria createGradeCriteria() {
		return new GradeDetachedCriteria(createCriteria("grade"));
	}
	
	public Competition[] listCompetition(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Competition[]) list.toArray(new Competition[list.size()]);
	}
}

