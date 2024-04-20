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

public class teamDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression TeamId;
	public final IntegerExpression clubId;
	public final AssociationExpression club;
	public final StringExpression Name;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression user;
	
	public teamDetachedCriteria() {
		super(eaproject.dao.team.class, eaproject.dao.teamCriteria.class);
		TeamId = new IntegerExpression("TeamId", this.getDetachedCriteria());
		clubId = new IntegerExpression("club.ClubId", this.getDetachedCriteria());
		club = new AssociationExpression("club", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		user = new CollectionExpression("ORM_User", this.getDetachedCriteria());
	}
	
	public teamDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.teamCriteria.class);
		TeamId = new IntegerExpression("TeamId", this.getDetachedCriteria());
		clubId = new IntegerExpression("club.ClubId", this.getDetachedCriteria());
		club = new AssociationExpression("club", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		user = new CollectionExpression("ORM_User", this.getDetachedCriteria());
	}
	
	public clubDetachedCriteria createClubCriteria() {
		return new clubDetachedCriteria(createCriteria("club"));
	}
	
	public userDetachedCriteria createUserCriteria() {
		return new userDetachedCriteria(createCriteria("ORM_User"));
	}
	
	public team uniqueTeam(PersistentSession session) {
		return (team) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public team[] listTeam(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (team[]) list.toArray(new team[list.size()]);
	}
}

