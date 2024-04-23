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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class resultDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ResultId;
	public final IntegerExpression trialId;
	public final AssociationExpression trial;
	public final IntegerExpression Position;
	public final TimestampExpression Time;
	public final StringExpression Observations;
	public final TimestampExpression PenaltyTime;
	public final TimestampExpression CreationDate;
	
	public resultDetachedCriteria() {
		super(eaproject.dao.result.class, eaproject.dao.resultCriteria.class);
		ResultId = new IntegerExpression("ResultId", this.getDetachedCriteria());
		trialId = new IntegerExpression("trial.TrialId", this.getDetachedCriteria());
		trial = new AssociationExpression("trial", this.getDetachedCriteria());
		Position = new IntegerExpression("Position", this.getDetachedCriteria());
		Time = new TimestampExpression("Time", this.getDetachedCriteria());
		Observations = new StringExpression("Observations", this.getDetachedCriteria());
		PenaltyTime = new TimestampExpression("PenaltyTime", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public resultDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.resultCriteria.class);
		ResultId = new IntegerExpression("ResultId", this.getDetachedCriteria());
		trialId = new IntegerExpression("trial.TrialId", this.getDetachedCriteria());
		trial = new AssociationExpression("trial", this.getDetachedCriteria());
		Position = new IntegerExpression("Position", this.getDetachedCriteria());
		Time = new TimestampExpression("Time", this.getDetachedCriteria());
		Observations = new StringExpression("Observations", this.getDetachedCriteria());
		PenaltyTime = new TimestampExpression("PenaltyTime", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public trialDetachedCriteria createTrialCriteria() {
		return new trialDetachedCriteria(createCriteria("trial"));
	}
	
	public result uniqueResult2(PersistentSession session) {
		return (result) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public result[] listResult(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (result[]) list.toArray(new result[list.size()]);
	}
}

