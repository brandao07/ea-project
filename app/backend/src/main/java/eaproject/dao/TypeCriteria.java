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

public class TypeCriteria extends AbstractORMCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final IntegerExpression NumberOfPersons;
	public final TimestampExpression CreationDate;
	
	public TypeCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		Name = new StringExpression("Name", this);
		NumberOfPersons = new IntegerExpression("NumberOfPersons", this);
		CreationDate = new TimestampExpression("CreationDate", this);
	}
	
	public TypeCriteria(PersistentSession session) {
		this(session.createCriteria(Type.class));
	}
	
	public TypeCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public Type uniqueType() {
		return (Type) super.uniqueResult();
	}
	
	public Type[] listType() {
		java.util.List list = super.list();
		return (Type[]) list.toArray(new Type[list.size()]);
	}
}

