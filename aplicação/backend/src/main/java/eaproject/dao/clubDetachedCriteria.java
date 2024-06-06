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

public class ClubDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	
	public ClubDetachedCriteria() {
		super(eaproject.dao.Club.class, eaproject.dao.ClubCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public ClubDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.ClubCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public Club uniqueClub(PersistentSession session) {
		return (Club) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Club[] listClub(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Club[]) list.toArray(new Club[list.size()]);
	}
}

