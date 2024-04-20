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

public class typeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression TypeId;
	public final StringExpression Name;
	public final IntegerExpression NumberOfPersons;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public typeDetachedCriteria() {
		super(eaproject.dao.type.class, eaproject.dao.typeCriteria.class);
		TypeId = new IntegerExpression("TypeId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		NumberOfPersons = new IntegerExpression("NumberOfPersons", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public typeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.typeCriteria.class);
		TypeId = new IntegerExpression("TypeId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		NumberOfPersons = new IntegerExpression("NumberOfPersons", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public trialDetachedCriteria createTrialCriteria() {
		return new trialDetachedCriteria(createCriteria("ORM_Trial"));
	}
	
	public type uniqueType(PersistentSession session) {
		return (type) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public type[] listType(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (type[]) list.toArray(new type[list.size()]);
	}
}

