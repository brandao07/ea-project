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

public class GradeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final IntegerExpression MinAge;
	public final IntegerExpression MaxAge;
	public final StringExpression Gender;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public GradeDetachedCriteria() {
		super(eaproject.dao.Grade.class, eaproject.dao.GradeCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		MinAge = new IntegerExpression("MinAge", this.getDetachedCriteria());
		MaxAge = new IntegerExpression("MaxAge", this.getDetachedCriteria());
		Gender = new StringExpression("Gender", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_trial", this.getDetachedCriteria());
	}
	
	public GradeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.GradeCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		MinAge = new IntegerExpression("MinAge", this.getDetachedCriteria());
		MaxAge = new IntegerExpression("MaxAge", this.getDetachedCriteria());
		Gender = new StringExpression("Gender", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_trial", this.getDetachedCriteria());
	}
	
	public TrialDetachedCriteria createTrialCriteria() {
		return new TrialDetachedCriteria(createCriteria("ORM_trial"));
	}
	
	public Grade uniqueGrade(PersistentSession session) {
		return (Grade) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Grade[] listGrade(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Grade[]) list.toArray(new Grade[list.size()]);
	}
}

