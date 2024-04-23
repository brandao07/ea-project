/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: User-PC(University of Minho)
 * License Type: Academic
 */
package eaproject.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class clubDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ClubId;
	public final StringExpression Name;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	public final CollectionExpression team;
	
	public clubDetachedCriteria() {
		super(eaproject.dao.club.class, eaproject.dao.clubCriteria.class);
		ClubId = new IntegerExpression("ClubId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		team = new CollectionExpression("ORM_Team", this.getDetachedCriteria());
	}
	
	public clubDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.clubCriteria.class);
		ClubId = new IntegerExpression("ClubId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		team = new CollectionExpression("ORM_Team", this.getDetachedCriteria());
	}
	
	public teamDetachedCriteria createTeamCriteria() {
		return new teamDetachedCriteria(createCriteria("ORM_Team"));
	}
	
	public club uniqueClub(PersistentSession session) {
		return (club) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public club[] listClub(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (club[]) list.toArray(new club[list.size()]);
	}
}

