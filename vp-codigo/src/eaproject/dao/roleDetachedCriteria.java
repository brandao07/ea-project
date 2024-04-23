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

public class roleDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression RoleId;
	public final StringExpression Name;
	public final StringExpression Description;
	public final TimestampExpression CreationDate;
	public final CollectionExpression user;
	
	public roleDetachedCriteria() {
		super(eaproject.dao.role.class, eaproject.dao.roleCriteria.class);
		RoleId = new IntegerExpression("RoleId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Description = new StringExpression("Description", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		user = new CollectionExpression("ORM_User", this.getDetachedCriteria());
	}
	
	public roleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.roleCriteria.class);
		RoleId = new IntegerExpression("RoleId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Description = new StringExpression("Description", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		user = new CollectionExpression("ORM_User", this.getDetachedCriteria());
	}
	
	public userDetachedCriteria createUserCriteria() {
		return new userDetachedCriteria(createCriteria("ORM_User"));
	}
	
	public role uniqueRole(PersistentSession session) {
		return (role) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public role[] listRole(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (role[]) list.toArray(new role[list.size()]);
	}
}

