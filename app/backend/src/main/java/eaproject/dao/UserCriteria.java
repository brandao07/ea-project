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

public class UserCriteria extends AbstractORMCriteria {
	public final IntegerExpression Id;
	public final IntegerExpression clubId;
	public final AssociationExpression club;
	public final IntegerExpression roleId;
	public final AssociationExpression role;
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
	
	public UserCriteria(Criteria criteria) {
		super(criteria);
		Id = new IntegerExpression("Id", this);
		clubId = new IntegerExpression("club.Id", this);
		club = new AssociationExpression("club", this);
		roleId = new IntegerExpression("role.Id", this);
		role = new AssociationExpression("role", this);
		Name = new StringExpression("Name", this);
		Email = new StringExpression("Email", this);
		Password = new StringExpression("Password", this);
		Gender = new StringExpression("Gender", this);
		Age = new IntegerExpression("Age", this);
		Height = new DoubleExpression("Height", this);
		Weight = new DoubleExpression("Weight", this);
		IsActive = new BooleanExpression("IsActive", this);
		RegisterDate = new TimestampExpression("RegisterDate", this);
		PhotographyPath = new StringExpression("PhotographyPath", this);
	}
	
	public UserCriteria(PersistentSession session) {
		this(session.createCriteria(User.class));
	}
	
	public UserCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public ClubCriteria createClubCriteria() {
		return new ClubCriteria(createCriteria("club"));
	}
	
	public RoleCriteria createRoleCriteria() {
		return new RoleCriteria(createCriteria("role"));
	}
	
	public User uniqueUser() {
		return (User) super.uniqueResult();
	}
	
	public User[] listUser() {
		java.util.List list = super.list();
		return (User[]) list.toArray(new User[list.size()]);
	}
}

