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

public class teamCriteria extends AbstractORMCriteria {
	public final IntegerExpression TeamId;
	public final IntegerExpression clubId;
	public final AssociationExpression club;
	public final StringExpression Name;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression user;
	
	public teamCriteria(Criteria criteria) {
		super(criteria);
		TeamId = new IntegerExpression("TeamId", this);
		clubId = new IntegerExpression("club.ClubId", this);
		club = new AssociationExpression("club", this);
		Name = new StringExpression("Name", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		user = new CollectionExpression("ORM_User", this);
	}
	
	public teamCriteria(PersistentSession session) {
		this(session.createCriteria(team.class));
	}
	
	public teamCriteria() throws PersistentException {
		this(AASICProjectPersistentManager.instance().getSession());
	}
	
	public clubCriteria createClubCriteria() {
		return new clubCriteria(createCriteria("club"));
	}
	
	public userCriteria createUserCriteria() {
		return new userCriteria(createCriteria("ORM_User"));
	}
	
	public team uniqueTeam() {
		return (team) super.uniqueResult();
	}
	
	public team[] listTeam() {
		java.util.List list = super.list();
		return (team[]) list.toArray(new team[list.size()]);
	}
}

