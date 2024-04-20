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

public class stateDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression StateId;
	public final StringExpression Nome;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public stateDetachedCriteria() {
		super(eaproject.dao.state.class, eaproject.dao.stateCriteria.class);
		StateId = new IntegerExpression("StateId", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public stateDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.stateCriteria.class);
		StateId = new IntegerExpression("StateId", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public trialDetachedCriteria createTrialCriteria() {
		return new trialDetachedCriteria(createCriteria("ORM_Trial"));
	}
	
	public state uniqueState(PersistentSession session) {
		return (state) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public state[] listState(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (state[]) list.toArray(new state[list.size()]);
	}
}

