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

public class TeamCriteria extends AbstractORMCriteria {
	public final IntegerExpression TeamId;
	public final IntegerExpression clubId;
	public final AssociationExpression club;
	public final StringExpression Name;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression user;
	
	public TeamCriteria(Criteria criteria) {
		super(criteria);
		TeamId = new IntegerExpression("TeamId", this);
		clubId = new IntegerExpression("club.ClubId", this);
		club = new AssociationExpression("club", this);
		Name = new StringExpression("Name", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		user = new CollectionExpression("ORM_User", this);
	}
	
	public TeamCriteria(PersistentSession session) {
		this(session.createCriteria(Team.class));
	}
	
	public TeamCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public ClubCriteria createClubCriteria() {
		return new ClubCriteria(createCriteria("club"));
	}
	
	public UserCriteria createUserCriteria() {
		return new UserCriteria(createCriteria("ORM_User"));
	}
	
	public Team uniqueTeam() {
		return (Team) super.uniqueResult();
	}
	
	public Team[] listTeam() {
		java.util.List list = super.list();
		return (Team[]) list.toArray(new Team[list.size()]);
	}
}

