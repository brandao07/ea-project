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

public class StateDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression StateId;
	public final StringExpression Nome;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public StateDetachedCriteria() {
		super(eaproject.dao.State.class, eaproject.dao.StateCriteria.class);
		StateId = new IntegerExpression("StateId", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_trial", this.getDetachedCriteria());
	}
	
	public StateDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.StateCriteria.class);
		StateId = new IntegerExpression("StateId", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_trial", this.getDetachedCriteria());
	}
	
	public TrialDetachedCriteria createTrialCriteria() {
		return new TrialDetachedCriteria(createCriteria("ORM_trial"));
	}
	
	public State uniqueState(PersistentSession session) {
		return (State) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public State[] listState(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (State[]) list.toArray(new State[list.size()]);
	}
}

