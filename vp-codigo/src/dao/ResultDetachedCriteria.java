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

public class ResultDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ResultId;
	public final IntegerExpression trialId;
	public final AssociationExpression trial;
	public final IntegerExpression Position;
	public final TimestampExpression Time;
	public final StringExpression Observations;
	public final TimestampExpression PenaltyTime;
	public final TimestampExpression CreationDate;
	
	public ResultDetachedCriteria() {
		super(dao.Result.class, dao.ResultCriteria.class);
		ResultId = new IntegerExpression("ResultId", this.getDetachedCriteria());
		trialId = new IntegerExpression("trial.TrialId", this.getDetachedCriteria());
		trial = new AssociationExpression("trial", this.getDetachedCriteria());
		Position = new IntegerExpression("Position", this.getDetachedCriteria());
		Time = new TimestampExpression("Time", this.getDetachedCriteria());
		Observations = new StringExpression("Observations", this.getDetachedCriteria());
		PenaltyTime = new TimestampExpression("PenaltyTime", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public ResultDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, dao.ResultCriteria.class);
		ResultId = new IntegerExpression("ResultId", this.getDetachedCriteria());
		trialId = new IntegerExpression("trial.TrialId", this.getDetachedCriteria());
		trial = new AssociationExpression("trial", this.getDetachedCriteria());
		Position = new IntegerExpression("Position", this.getDetachedCriteria());
		Time = new TimestampExpression("Time", this.getDetachedCriteria());
		Observations = new StringExpression("Observations", this.getDetachedCriteria());
		PenaltyTime = new TimestampExpression("PenaltyTime", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public TrialDetachedCriteria createTrialCriteria() {
		return new TrialDetachedCriteria(createCriteria("trial"));
	}
	
	public Result uniqueResult2(PersistentSession session) {
		return (Result) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Result[] listResult(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Result[]) list.toArray(new Result[list.size()]);
	}
}

