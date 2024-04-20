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

public class trialCriteria extends AbstractORMCriteria {
	public final IntegerExpression TrialId;
	public final IntegerExpression stateId;
	public final AssociationExpression state;
	public final IntegerExpression competitionId;
	public final AssociationExpression competition;
	public final IntegerExpression gradeId;
	public final AssociationExpression grade;
	public final IntegerExpression typeId;
	public final AssociationExpression type;
	public final IntegerExpression locationId;
	public final AssociationExpression location;
	public final IntegerExpression userId;
	public final AssociationExpression user;
	public final StringExpression Name;
	public final TimestampExpression StartDate;
	public final DoubleExpression Distance;
	public final StringExpression DistanceUnit;
	public final IntegerExpression NumberOfCheckpoints;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression result;
	
	public trialCriteria(Criteria criteria) {
		super(criteria);
		TrialId = new IntegerExpression("TrialId", this);
		stateId = new IntegerExpression("state.StateId", this);
		state = new AssociationExpression("state", this);
		competitionId = new IntegerExpression("competition.CompetitionId", this);
		competition = new AssociationExpression("competition", this);
		gradeId = new IntegerExpression("grade.GradeId", this);
		grade = new AssociationExpression("grade", this);
		typeId = new IntegerExpression("type.TypeId", this);
		type = new AssociationExpression("type", this);
		locationId = new IntegerExpression("location.LocationId", this);
		location = new AssociationExpression("location", this);
		userId = new IntegerExpression("user.UserId", this);
		user = new AssociationExpression("user", this);
		Name = new StringExpression("Name", this);
		StartDate = new TimestampExpression("StartDate", this);
		Distance = new DoubleExpression("Distance", this);
		DistanceUnit = new StringExpression("DistanceUnit", this);
		NumberOfCheckpoints = new IntegerExpression("NumberOfCheckpoints", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		result = new CollectionExpression("ORM_Result", this);
	}
	
	public trialCriteria(PersistentSession session) {
		this(session.createCriteria(trial.class));
	}
	
	public trialCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public stateCriteria createStateCriteria() {
		return new stateCriteria(createCriteria("state"));
	}
	
	public competitionCriteria createCompetitionCriteria() {
		return new competitionCriteria(createCriteria("competition"));
	}
	
	public gradeCriteria createGradeCriteria() {
		return new gradeCriteria(createCriteria("grade"));
	}
	
	public typeCriteria createTypeCriteria() {
		return new typeCriteria(createCriteria("type"));
	}
	
	public locationCriteria createLocationCriteria() {
		return new locationCriteria(createCriteria("location"));
	}
	
	public userCriteria createUserCriteria() {
		return new userCriteria(createCriteria("user"));
	}
	
	public resultCriteria createResultCriteria() {
		return new resultCriteria(createCriteria("ORM_Result"));
	}
	
	public trial uniqueTrial() {
		return (trial) super.uniqueResult();
	}
	
	public trial[] listTrial() {
		java.util.List list = super.list();
		return (trial[]) list.toArray(new trial[list.size()]);
	}
}

