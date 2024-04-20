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

public class gradeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression GradeId;
	public final StringExpression Name;
	public final IntegerExpression MinAge;
	public final IntegerExpression MaxAge;
	public final DoubleExpression MinWeight;
	public final DoubleExpression MaxWeight;
	public final DoubleExpression MinHeight;
	public final DoubleExpression MaxHeight;
	public final StringExpression Gender;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public gradeDetachedCriteria() {
		super(eaproject.dao.grade.class, eaproject.dao.gradeCriteria.class);
		GradeId = new IntegerExpression("GradeId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		MinAge = new IntegerExpression("MinAge", this.getDetachedCriteria());
		MaxAge = new IntegerExpression("MaxAge", this.getDetachedCriteria());
		MinWeight = new DoubleExpression("MinWeight", this.getDetachedCriteria());
		MaxWeight = new DoubleExpression("MaxWeight", this.getDetachedCriteria());
		MinHeight = new DoubleExpression("MinHeight", this.getDetachedCriteria());
		MaxHeight = new DoubleExpression("MaxHeight", this.getDetachedCriteria());
		Gender = new StringExpression("Gender", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public gradeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.gradeCriteria.class);
		GradeId = new IntegerExpression("GradeId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		MinAge = new IntegerExpression("MinAge", this.getDetachedCriteria());
		MaxAge = new IntegerExpression("MaxAge", this.getDetachedCriteria());
		MinWeight = new DoubleExpression("MinWeight", this.getDetachedCriteria());
		MaxWeight = new DoubleExpression("MaxWeight", this.getDetachedCriteria());
		MinHeight = new DoubleExpression("MinHeight", this.getDetachedCriteria());
		MaxHeight = new DoubleExpression("MaxHeight", this.getDetachedCriteria());
		Gender = new StringExpression("Gender", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public trialDetachedCriteria createTrialCriteria() {
		return new trialDetachedCriteria(createCriteria("ORM_Trial"));
	}
	
	public grade uniqueGrade(PersistentSession session) {
		return (grade) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public grade[] listGrade(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (grade[]) list.toArray(new grade[list.size()]);
	}
}

