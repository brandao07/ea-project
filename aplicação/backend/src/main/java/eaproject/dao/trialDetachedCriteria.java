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

public class trialDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public trialDetachedCriteria() {
		super(eaproject.dao.trial.class, eaproject.dao.trialCriteria.class);
		TrialId = new IntegerExpression("TrialId", this.getDetachedCriteria());
		stateId = new IntegerExpression("state.StateId", this.getDetachedCriteria());
		state = new AssociationExpression("state", this.getDetachedCriteria());
		competitionId = new IntegerExpression("competition.CompetitionId", this.getDetachedCriteria());
		competition = new AssociationExpression("competition", this.getDetachedCriteria());
		gradeId = new IntegerExpression("grade.GradeId", this.getDetachedCriteria());
		grade = new AssociationExpression("grade", this.getDetachedCriteria());
		typeId = new IntegerExpression("type.TypeId", this.getDetachedCriteria());
		type = new AssociationExpression("type", this.getDetachedCriteria());
		locationId = new IntegerExpression("location.LocationId", this.getDetachedCriteria());
		location = new AssociationExpression("location", this.getDetachedCriteria());
		userId = new IntegerExpression("user.UserId", this.getDetachedCriteria());
		user = new AssociationExpression("user", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		Distance = new DoubleExpression("Distance", this.getDetachedCriteria());
		DistanceUnit = new StringExpression("DistanceUnit", this.getDetachedCriteria());
		NumberOfCheckpoints = new IntegerExpression("NumberOfCheckpoints", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		result = new CollectionExpression("ORM_Result", this.getDetachedCriteria());
	}
	
	public trialDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.trialCriteria.class);
		TrialId = new IntegerExpression("TrialId", this.getDetachedCriteria());
		stateId = new IntegerExpression("state.StateId", this.getDetachedCriteria());
		state = new AssociationExpression("state", this.getDetachedCriteria());
		competitionId = new IntegerExpression("competition.CompetitionId", this.getDetachedCriteria());
		competition = new AssociationExpression("competition", this.getDetachedCriteria());
		gradeId = new IntegerExpression("grade.GradeId", this.getDetachedCriteria());
		grade = new AssociationExpression("grade", this.getDetachedCriteria());
		typeId = new IntegerExpression("type.TypeId", this.getDetachedCriteria());
		type = new AssociationExpression("type", this.getDetachedCriteria());
		locationId = new IntegerExpression("location.LocationId", this.getDetachedCriteria());
		location = new AssociationExpression("location", this.getDetachedCriteria());
		userId = new IntegerExpression("user.UserId", this.getDetachedCriteria());
		user = new AssociationExpression("user", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		Distance = new DoubleExpression("Distance", this.getDetachedCriteria());
		DistanceUnit = new StringExpression("DistanceUnit", this.getDetachedCriteria());
		NumberOfCheckpoints = new IntegerExpression("NumberOfCheckpoints", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		result = new CollectionExpression("ORM_Result", this.getDetachedCriteria());
	}
	
	public stateDetachedCriteria createStateCriteria() {
		return new stateDetachedCriteria(createCriteria("state"));
	}
	
	public competitionDetachedCriteria createCompetitionCriteria() {
		return new competitionDetachedCriteria(createCriteria("competition"));
	}
	
	public gradeDetachedCriteria createGradeCriteria() {
		return new gradeDetachedCriteria(createCriteria("grade"));
	}
	
	public typeDetachedCriteria createTypeCriteria() {
		return new typeDetachedCriteria(createCriteria("type"));
	}
	
	public locationDetachedCriteria createLocationCriteria() {
		return new locationDetachedCriteria(createCriteria("location"));
	}
	
	public userDetachedCriteria createUserCriteria() {
		return new userDetachedCriteria(createCriteria("user"));
	}
	
	public resultDetachedCriteria createResultCriteria() {
		return new resultDetachedCriteria(createCriteria("ORM_Result"));
	}
	
	public trial uniqueTrial(PersistentSession session) {
		return (trial) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public trial[] listTrial(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (trial[]) list.toArray(new trial[list.size()]);
	}
}

