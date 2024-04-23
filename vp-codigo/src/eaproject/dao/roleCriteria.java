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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class roleCriteria extends AbstractORMCriteria {
	public final IntegerExpression RoleId;
	public final StringExpression Name;
	public final StringExpression Description;
	public final TimestampExpression CreationDate;
	public final CollectionExpression user;
	
	public roleCriteria(Criteria criteria) {
		super(criteria);
		RoleId = new IntegerExpression("RoleId", this);
		Name = new StringExpression("Name", this);
		Description = new StringExpression("Description", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		user = new CollectionExpression("ORM_User", this);
	}
	
	public roleCriteria(PersistentSession session) {
		this(session.createCriteria(role.class));
	}
	
	public roleCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public userCriteria createUserCriteria() {
		return new userCriteria(createCriteria("ORM_User"));
	}
	
	public role uniqueRole() {
		return (role) super.uniqueResult();
	}
	
	public role[] listRole() {
		java.util.List list = super.list();
		return (role[]) list.toArray(new role[list.size()]);
	}
}

