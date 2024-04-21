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

public class stateCriteria extends AbstractORMCriteria {
	public final IntegerExpression StateId;
	public final StringExpression Nome;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public stateCriteria(Criteria criteria) {
		super(criteria);
		StateId = new IntegerExpression("StateId", this);
		Nome = new StringExpression("Nome", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		trial = new CollectionExpression("ORM_Trial", this);
	}
	
	public stateCriteria(PersistentSession session) {
		this(session.createCriteria(state.class));
	}
	
	public stateCriteria() throws PersistentException {
		this(AASICProjectPersistentManager.instance().getSession());
	}
	
	public trialCriteria createTrialCriteria() {
		return new trialCriteria(createCriteria("ORM_Trial"));
	}
	
	public state uniqueState() {
		return (state) super.uniqueResult();
	}
	
	public state[] listState() {
		java.util.List list = super.list();
		return (state[]) list.toArray(new state[list.size()]);
	}
}

