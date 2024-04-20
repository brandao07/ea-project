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

public class clubCriteria extends AbstractORMCriteria {
	public final IntegerExpression ClubId;
	public final StringExpression Name;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression team;
	
	public clubCriteria(Criteria criteria) {
		super(criteria);
		ClubId = new IntegerExpression("ClubId", this);
		Name = new StringExpression("Name", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		team = new CollectionExpression("ORM_Team", this);
	}
	
	public clubCriteria(PersistentSession session) {
		this(session.createCriteria(club.class));
	}
	
	public clubCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public teamCriteria createTeamCriteria() {
		return new teamCriteria(createCriteria("ORM_Team"));
	}
	
	public club uniqueClub() {
		return (club) super.uniqueResult();
	}
	
	public club[] listClub() {
		java.util.List list = super.list();
		return (club[]) list.toArray(new club[list.size()]);
	}
}

