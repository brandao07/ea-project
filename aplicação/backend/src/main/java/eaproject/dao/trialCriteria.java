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

public class TrialCriteria extends AbstractORMCriteria {
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
	
	public TrialCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		stateId = new IntegerExpression("state.Id", this);
		state = new AssociationExpression("state", this);
		competitionId = new IntegerExpression("competition.Id", this);
		competition = new AssociationExpression("competition", this);
		gradeId = new IntegerExpression("grade.Id", this);
		grade = new AssociationExpression("grade", this);
		typeId = new IntegerExpression("type.Id", this);
		type = new AssociationExpression("type", this);
		locationId = new IntegerExpression("location.Id", this);
		location = new AssociationExpression("location", this);
		Name = new StringExpression("Name", this);
		StartDate = new TimestampExpression("StartDate", this);
		Distance = new DoubleExpression("Distance", this);
		DistanceUnit = new StringExpression("DistanceUnit", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		result = new CollectionExpression("ORM_result", this);
		team = new CollectionExpression("ORM_team", this);
	}
	
	public TrialCriteria(PersistentSession session) {
		this(session.createCriteria(Trial.class));
	}
	
	public TrialCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public StateCriteria createStateCriteria() {
		return new StateCriteria(createCriteria("state"));
	}
	
	public CompetitionCriteria createCompetitionCriteria() {
		return new CompetitionCriteria(createCriteria("competition"));
	}
	
	public GradeCriteria createGradeCriteria() {
		return new GradeCriteria(createCriteria("grade"));
	}
	
	public TypeCriteria createTypeCriteria() {
		return new TypeCriteria(createCriteria("type"));
	}
	
	public LocationCriteria createLocationCriteria() {
		return new LocationCriteria(createCriteria("location"));
	}
	
	public ResultCriteria createResultCriteria() {
		return new ResultCriteria(createCriteria("ORM_result"));
	}
	
	public TeamCriteria createTeamCriteria() {
		return new TeamCriteria(createCriteria("ORM_team"));
	}
	
	public Trial uniqueTrial() {
		return (Trial) super.uniqueResult();
	}
	
	public Trial[] listTrial() {
		java.util.List list = super.list();
		return (Trial[]) list.toArray(new Trial[list.size()]);
	}
}

