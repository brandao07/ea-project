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

public class RoleDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression RoleId;
	public final StringExpression Name;
	public final StringExpression Description;
	public final TimestampExpression CreationDate;
	public final CollectionExpression user;
	
	public RoleDetachedCriteria() {
		super(eaproject.dao.Role.class, eaproject.dao.RoleCriteria.class);
		RoleId = new IntegerExpression("RoleId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Description = new StringExpression("Description", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		user = new CollectionExpression("ORM_user", this.getDetachedCriteria());
	}
	
	public RoleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.RoleCriteria.class);
		RoleId = new IntegerExpression("RoleId", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Description = new StringExpression("Description", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		user = new CollectionExpression("ORM_user", this.getDetachedCriteria());
	}
	
	public UserDetachedCriteria createUserCriteria() {
		return new UserDetachedCriteria(createCriteria("ORM_user"));
	}
	
	public Role uniqueRole(PersistentSession session) {
		return (Role) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Role[] listRole(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Role[]) list.toArray(new Role[list.size()]);
	}
}

