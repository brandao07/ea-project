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

public class StateCriteria extends AbstractORMCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final TimestampExpression CreationDate;
	
	public StateCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		Name = new StringExpression("Name", this);
		CreationDate = new TimestampExpression("CreationDate", this);
	}
	
	public StateCriteria(PersistentSession session) {
		this(session.createCriteria(State.class));
	}
	
	public StateCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public State uniqueState() {
		return (State) super.uniqueResult();
	}
	
	public State[] listState() {
		java.util.List list = super.list();
		return (State[]) list.toArray(new State[list.size()]);
	}
}

