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

public class UserDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression Id;
	public final IntegerExpression clubId;
	public final AssociationExpression club;
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
	public final StringExpression PhotographyPath;
	
	public UserDetachedCriteria() {
		super(eaproject.dao.User.class, eaproject.dao.UserCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		clubId = new IntegerExpression("club.Id", this.getDetachedCriteria());
		club = new AssociationExpression("club", this.getDetachedCriteria());
		roleId = new IntegerExpression("role.Id", this.getDetachedCriteria());
		role = new AssociationExpression("role", this.getDetachedCriteria());
		teamId = new IntegerExpression("team.Id", this.getDetachedCriteria());
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
		PhotographyPath = new StringExpression("PhotographyPath", this.getDetachedCriteria());
	}
	
	public UserDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.UserCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		clubId = new IntegerExpression("club.Id", this.getDetachedCriteria());
		club = new AssociationExpression("club", this.getDetachedCriteria());
		roleId = new IntegerExpression("role.Id", this.getDetachedCriteria());
		role = new AssociationExpression("role", this.getDetachedCriteria());
		teamId = new IntegerExpression("team.Id", this.getDetachedCriteria());
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
		PhotographyPath = new StringExpression("PhotographyPath", this.getDetachedCriteria());
	}
	
	public ClubDetachedCriteria createClubCriteria() {
		return new ClubDetachedCriteria(createCriteria("club"));
	}
	
	public RoleDetachedCriteria createRoleCriteria() {
		return new RoleDetachedCriteria(createCriteria("role"));
	}
	
	public TeamDetachedCriteria createTeamCriteria() {
		return new TeamDetachedCriteria(createCriteria("team"));
	}
	
	public User uniqueUser(PersistentSession session) {
		return (User) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public User[] listUser(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (User[]) list.toArray(new User[list.size()]);
	}
}

