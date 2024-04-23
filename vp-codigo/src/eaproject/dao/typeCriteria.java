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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class typeCriteria extends AbstractORMCriteria {
	public final IntegerExpression TypeId;
	public final StringExpression Name;
	public final IntegerExpression NumberOfPersons;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public typeCriteria(Criteria criteria) {
		super(criteria);
		TypeId = new IntegerExpression("TypeId", this);
		Name = new StringExpression("Name", this);
		NumberOfPersons = new IntegerExpression("NumberOfPersons", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		trial = new CollectionExpression("ORM_Trial", this);
	}
	
	public typeCriteria(PersistentSession session) {
		this(session.createCriteria(type.class));
	}
	
	public typeCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public trialCriteria createTrialCriteria() {
		return new trialCriteria(createCriteria("ORM_Trial"));
	}
	
	public type uniqueType() {
		return (type) super.uniqueResult();
	}
	
	public type[] listType() {
		java.util.List list = super.list();
		return (type[]) list.toArray(new type[list.size()]);
	}
}

