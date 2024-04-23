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
package dao;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RoleCriteria extends AbstractORMCriteria {
	public final IntegerExpression RoleId;
	public final StringExpression Name;
	public final StringExpression Description;
	public final TimestampExpression CreationDate;
	public final CollectionExpression user;
	
	public RoleCriteria(Criteria criteria) {
		super(criteria);
		RoleId = new IntegerExpression("RoleId", this);
		Name = new StringExpression("Name", this);
		Description = new StringExpression("Description", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		user = new CollectionExpression("ORM_User", this);
	}
	
	public RoleCriteria(PersistentSession session) {
		this(session.createCriteria(Role.class));
	}
	
	public RoleCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public UserCriteria createUserCriteria() {
		return new UserCriteria(createCriteria("ORM_User"));
	}
	
	public Role uniqueRole() {
		return (Role) super.uniqueResult();
	}
	
	public Role[] listRole() {
		java.util.List list = super.list();
		return (Role[]) list.toArray(new Role[list.size()]);
	}
}

