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

public class ClubCriteria extends AbstractORMCriteria {
	public final IntegerExpression Id;
	public final StringExpression Name;
	public final BooleanExpression IsActive;
	public final TimestampExpression CreationDate;
	
	public ClubCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		Name = new StringExpression("Name", this);
		IsActive = new BooleanExpression("IsActive", this);
		CreationDate = new TimestampExpression("CreationDate", this);
	}
	
	public ClubCriteria(PersistentSession session) {
		this(session.createCriteria(Club.class));
	}
	
	public ClubCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public Club uniqueClub() {
		return (Club) super.uniqueResult();
	}
	
	public Club[] listClub() {
		java.util.List list = super.list();
		return (Club[]) list.toArray(new Club[list.size()]);
	}
}

