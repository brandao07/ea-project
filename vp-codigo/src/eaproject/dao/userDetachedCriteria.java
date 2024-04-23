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

public class userDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression UserId;
	public final IntegerExpression roleId;
	public final AssociationExpression role;
	public final IntegerExpression teamId;
	public final AssociationExpression team;
	public final StringExpression Name;
	public final StringExpression Email;
	public final StringExpression Password;
	public final StringExpression Gender;
	public final IntegerExpression Age;
	public final DoubleExpression Height;
	public final DoubleExpression Weight;
	public final BooleanExpression IsActive;
	public final TimestampExpression RegisterDate;
	public final CollectionExpression trial;
	
	public userDetachedCriteria() {
		super(eaproject.dao.user.class, eaproject.dao.userCriteria.class);
		UserId = new IntegerExpression("UserId", this.getDetachedCriteria());
		roleId = new IntegerExpression("role.RoleId", this.getDetachedCriteria());
		role = new AssociationExpression("role", this.getDetachedCriteria());
		teamId = new IntegerExpression("team.TeamId", this.getDetachedCriteria());
		team = new AssociationExpression("team", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Password = new StringExpression("Password", this.getDetachedCriteria());
		Gender = new StringExpression("Gender", this.getDetachedCriteria());
		Age = new IntegerExpression("Age", this.getDetachedCriteria());
		Height = new DoubleExpression("Height", this.getDetachedCriteria());
		Weight = new DoubleExpression("Weight", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		RegisterDate = new TimestampExpression("RegisterDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public userDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.userCriteria.class);
		UserId = new IntegerExpression("UserId", this.getDetachedCriteria());
		roleId = new IntegerExpression("role.RoleId", this.getDetachedCriteria());
		role = new AssociationExpression("role", this.getDetachedCriteria());
		teamId = new IntegerExpression("team.TeamId", this.getDetachedCriteria());
		team = new AssociationExpression("team", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Password = new StringExpression("Password", this.getDetachedCriteria());
		Gender = new StringExpression("Gender", this.getDetachedCriteria());
		Age = new IntegerExpression("Age", this.getDetachedCriteria());
		Height = new DoubleExpression("Height", this.getDetachedCriteria());
		Weight = new DoubleExpression("Weight", this.getDetachedCriteria());
		IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
		RegisterDate = new TimestampExpression("RegisterDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public roleDetachedCriteria createRoleCriteria() {
		return new roleDetachedCriteria(createCriteria("role"));
	}
	
	public teamDetachedCriteria createTeamCriteria() {
		return new teamDetachedCriteria(createCriteria("team"));
	}
	
	public trialDetachedCriteria createTrialCriteria() {
		return new trialDetachedCriteria(createCriteria("ORM_Trial"));
	}
	
	public user uniqueUser(PersistentSession session) {
		return (user) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public user[] listUser(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (user[]) list.toArray(new user[list.size()]);
	}
}

