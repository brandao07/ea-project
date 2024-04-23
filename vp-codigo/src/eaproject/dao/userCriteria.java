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

public class userCriteria extends AbstractORMCriteria {
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
	
	public userCriteria(Criteria criteria) {
		super(criteria);
		UserId = new IntegerExpression("UserId", this);
		roleId = new IntegerExpression("role.RoleId", this);
		role = new AssociationExpression("role", this);
		teamId = new IntegerExpression("team.TeamId", this);
		team = new AssociationExpression("team", this);
		Name = new StringExpression("Name", this);
		Email = new StringExpression("Email", this);
		Password = new StringExpression("Password", this);
		Gender = new StringExpression("Gender", this);
		Age = new IntegerExpression("Age", this);
		Height = new DoubleExpression("Height", this);
		Weight = new DoubleExpression("Weight", this);
		IsActive = new BooleanExpression("IsActive", this);
		RegisterDate = new TimestampExpression("RegisterDate", this);
		trial = new CollectionExpression("ORM_Trial", this);
	}
	
	public userCriteria(PersistentSession session) {
		this(session.createCriteria(user.class));
	}
	
	public userCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public roleCriteria createRoleCriteria() {
		return new roleCriteria(createCriteria("role"));
	}
	
	public teamCriteria createTeamCriteria() {
		return new teamCriteria(createCriteria("team"));
	}
	
	public trialCriteria createTrialCriteria() {
		return new trialCriteria(createCriteria("ORM_Trial"));
	}
	
	public user uniqueUser() {
		return (user) super.uniqueResult();
	}
	
	public user[] listUser() {
		java.util.List list = super.list();
		return (user[]) list.toArray(new user[list.size()]);
	}
}

