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
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;
import org.orm.criteria.TimestampExpression;

public class GradeCriteria extends AbstractORMCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final IntegerExpression MinAge;
	public final IntegerExpression MaxAge;
	public final TimestampExpression CreationDate;
	
	public GradeCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		Name = new StringExpression("Name", this);
		MinAge = new IntegerExpression("MinAge", this);
		MaxAge = new IntegerExpression("MaxAge", this);
		CreationDate = new TimestampExpression("CreationDate", this);
	}
	
	public GradeCriteria(PersistentSession session) {
		this(session.createCriteria(Grade.class));
	}
	
	public GradeCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public Grade uniqueGrade() {
		return (Grade) super.uniqueResult();
	}
	
	public Grade[] listGrade() {
		java.util.List list = super.list();
		return (Grade[]) list.toArray(new Grade[list.size()]);
	}
}

