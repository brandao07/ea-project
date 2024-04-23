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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ResultCriteria extends AbstractORMCriteria {
	public final IntegerExpression ResultId;
	public final IntegerExpression trialId;
	public final AssociationExpression trial;
	public final IntegerExpression Position;
	public final TimestampExpression Time;
	public final StringExpression Observations;
	public final TimestampExpression PenaltyTime;
	public final TimestampExpression CreationDate;
	
	public ResultCriteria(Criteria criteria) {
		super(criteria);
		ResultId = new IntegerExpression("ResultId", this);
		trialId = new IntegerExpression("trial.TrialId", this);
		trial = new AssociationExpression("trial", this);
		Position = new IntegerExpression("Position", this);
		Time = new TimestampExpression("Time", this);
		Observations = new StringExpression("Observations", this);
		PenaltyTime = new TimestampExpression("PenaltyTime", this);
		CreationDate = new TimestampExpression("CreationDate", this);
	}
	
	public ResultCriteria(PersistentSession session) {
		this(session.createCriteria(Result.class));
	}
	
	public ResultCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public TrialCriteria createTrialCriteria() {
		return new TrialCriteria(createCriteria("trial"));
	}
	
	public Result uniqueResult2() {
		return (Result) super.uniqueResult();
	}
	
	public Result[] listResult() {
		java.util.List list = super.list();
		return (Result[]) list.toArray(new Result[list.size()]);
	}
}

