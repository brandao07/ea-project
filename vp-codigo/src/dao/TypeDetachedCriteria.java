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
package dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class TypeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression TypeId;
	public final StringExpression Name;
	public final IntegerExpression NumberOfPersons;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public TypeDetachedCriteria() {
		super(dao.Type.class, dao.TypeCriteria.class);
		TypeId = new IntegerExpression("TypeId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		NumberOfPersons = new IntegerExpression("NumberOfPersons", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public TypeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, dao.TypeCriteria.class);
		TypeId = new IntegerExpression("TypeId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		NumberOfPersons = new IntegerExpression("NumberOfPersons", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public TrialDetachedCriteria createTrialCriteria() {
		return new TrialDetachedCriteria(createCriteria("ORM_Trial"));
	}
	
	public Type uniqueType(PersistentSession session) {
		return (Type) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Type[] listType(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Type[]) list.toArray(new Type[list.size()]);
	}
}

