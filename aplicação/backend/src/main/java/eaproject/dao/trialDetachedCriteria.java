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

public class TrialDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression Id;
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
	public final StringExpression Name;
	public final TimestampExpression StartDate;
	public final DoubleExpression Distance;
	public final StringExpression DistanceUnit;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression result;
	public final CollectionExpression team;
	
	public TrialDetachedCriteria() {
		super(eaproject.dao.Trial.class, eaproject.dao.TrialCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		stateId = new IntegerExpression("state.Id", this.getDetachedCriteria());
		state = new AssociationExpression("state", this.getDetachedCriteria());
		competitionId = new IntegerExpression("competition.Id", this.getDetachedCriteria());
		competition = new AssociationExpression("competition", this.getDetachedCriteria());
		gradeId = new IntegerExpression("grade.Id", this.getDetachedCriteria());
		grade = new AssociationExpression("grade", this.getDetachedCriteria());
		typeId = new IntegerExpression("type.Id", this.getDetachedCriteria());
		type = new AssociationExpression("type", this.getDetachedCriteria());
		locationId = new IntegerExpression("location.Id", this.getDetachedCriteria());
		location = new AssociationExpression("location", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		Distance = new DoubleExpression("Distance", this.getDetachedCriteria());
		DistanceUnit = new StringExpression("DistanceUnit", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		result = new CollectionExpression("ORM_result", this.getDetachedCriteria());
		team = new CollectionExpression("ORM_team", this.getDetachedCriteria());
	}
	
	public TrialDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.TrialCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		stateId = new IntegerExpression("state.Id", this.getDetachedCriteria());
		state = new AssociationExpression("state", this.getDetachedCriteria());
		competitionId = new IntegerExpression("competition.Id", this.getDetachedCriteria());
		competition = new AssociationExpression("competition", this.getDetachedCriteria());
		gradeId = new IntegerExpression("grade.Id", this.getDetachedCriteria());
		grade = new AssociationExpression("grade", this.getDetachedCriteria());
		typeId = new IntegerExpression("type.Id", this.getDetachedCriteria());
		type = new AssociationExpression("type", this.getDetachedCriteria());
		locationId = new IntegerExpression("location.Id", this.getDetachedCriteria());
		location = new AssociationExpression("location", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		StartDate = new TimestampExpression("StartDate", this.getDetachedCriteria());
		Distance = new DoubleExpression("Distance", this.getDetachedCriteria());
		DistanceUnit = new StringExpression("DistanceUnit", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		result = new CollectionExpression("ORM_result", this.getDetachedCriteria());
		team = new CollectionExpression("ORM_team", this.getDetachedCriteria());
	}
	
	public StateDetachedCriteria createStateCriteria() {
		return new StateDetachedCriteria(createCriteria("state"));
	}
	
	public CompetitionDetachedCriteria createCompetitionCriteria() {
		return new CompetitionDetachedCriteria(createCriteria("competition"));
	}
	
	public GradeDetachedCriteria createGradeCriteria() {
		return new GradeDetachedCriteria(createCriteria("grade"));
	}
	
	public TypeDetachedCriteria createTypeCriteria() {
		return new TypeDetachedCriteria(createCriteria("type"));
	}
	
	public LocationDetachedCriteria createLocationCriteria() {
		return new LocationDetachedCriteria(createCriteria("location"));
	}
	
	public ResultDetachedCriteria createResultCriteria() {
		return new ResultDetachedCriteria(createCriteria("ORM_result"));
	}
	
	public TeamDetachedCriteria createTeamCriteria() {
		return new TeamDetachedCriteria(createCriteria("ORM_team"));
	}
	
	public Trial uniqueTrial(PersistentSession session) {
		return (Trial) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Trial[] listTrial(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Trial[]) list.toArray(new Trial[list.size()]);
	}
}

