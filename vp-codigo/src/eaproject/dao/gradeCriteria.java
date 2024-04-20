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

public class gradeCriteria extends AbstractORMCriteria {
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
	
	public gradeCriteria(Criteria criteria) {
		super(criteria);
		GradeId = new IntegerExpression("GradeId", this);
		Name = new StringExpression("Name", this);
		MinAge = new IntegerExpression("MinAge", this);
		MaxAge = new IntegerExpression("MaxAge", this);
		MinWeight = new DoubleExpression("MinWeight", this);
		MaxWeight = new DoubleExpression("MaxWeight", this);
		MinHeight = new DoubleExpression("MinHeight", this);
		MaxHeight = new DoubleExpression("MaxHeight", this);
		Gender = new StringExpression("Gender", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		trial = new CollectionExpression("ORM_Trial", this);
	}
	
	public gradeCriteria(PersistentSession session) {
		this(session.createCriteria(grade.class));
	}
	
	public gradeCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public trialCriteria createTrialCriteria() {
		return new trialCriteria(createCriteria("ORM_Trial"));
	}
	
	public grade uniqueGrade() {
		return (grade) super.uniqueResult();
	}
	
	public grade[] listGrade() {
		java.util.List list = super.list();
		return (grade[]) list.toArray(new grade[list.size()]);
	}
}

