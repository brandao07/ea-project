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

import eaproject.constants.ORMConstants;
import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.io.Serializable;
import java.util.List;
public class User implements Serializable {
	public User() {
	}
	
	public static User loadUserByORMID(int UserId) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadUserByORMID(session, UserId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User getUserByORMID(int UserId) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return getUserByORMID(session, UserId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User loadUserByORMID(int UserId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadUserByORMID(session, UserId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User getUserByORMID(int UserId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return getUserByORMID(session, UserId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User loadUserByORMID(PersistentSession session, int UserId) throws PersistentException {
		try {
			return (User) session.load(User.class, Integer.valueOf(UserId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User getUserByORMID(PersistentSession session, int UserId) throws PersistentException {
		try {
			return (User) session.get(User.class, Integer.valueOf(UserId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User loadUserByORMID(PersistentSession session, int UserId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User) session.load(User.class, Integer.valueOf(UserId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User getUserByORMID(PersistentSession session, int UserId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User) session.get(User.class, Integer.valueOf(UserId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryUser(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return queryUser(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryUser(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return queryUser(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User[] listUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return listUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User[] listUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return listUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryUser(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryUser(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("User", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User[] listUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUser(session, condition, orderBy);
			return (User[]) list.toArray(new User[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User[] listUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUser(session, condition, orderBy, lockMode);
			return (User[]) list.toArray(new User[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User loadUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User loadUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User loadUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		User[] users = listUserByQuery(session, condition, orderBy);
		if (users != null && users.length > 0)
			return users[0];
		else
			return null;
	}

	public static User loadUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		User[] users = listUserByQuery(session, condition, orderBy, lockMode);
		if (users != null && users.length > 0)
			return users[0];
		else
			return null;
	}

	public static java.util.Iterator iterateUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return iterateUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return iterateUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("User", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static User loadUserByCriteria(UserCriteria userCriteria) {
		User[] users = listUserByCriteria(userCriteria);
		if(users == null || users.length == 0) {
			return null;
		}
		return users[0];
	}

	public static User[] listUserByCriteria(UserCriteria userCriteria) {
		return userCriteria.listUser();
	}

	public static User createUser() {
		return new User();
	}

	public boolean save() throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public boolean delete() throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public boolean refresh() throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public boolean evict() throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public boolean deleteAndDissociate()throws PersistentException {
		try {
			if(getRole() != null) {
				getRole().user.remove(this);
			}

			if(getTeam() != null) {
				getTeam().user.remove(this);
			}

			Trial[] lTrials = trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setUser(null);
			}
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			if(getRole() != null) {
				getRole().user.remove(this);
			}

			if(getTeam() != null) {
				getTeam().user.remove(this);
			}

			Trial[] lTrials = trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setUser(null);
			}
			try {
				session.delete(this);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USER_TRIAL) {
			return ORM_trial;
		}

		return null;
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_USER_ROLE) {
			this.role = (Role) owner;
		}

		else if (key == ORMConstants.KEY_USER_TEAM) {
			this.team = (Team) owner;
		}
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};

	private int UserId;

	private Role role;

	private Team team;

	private String Name;

	private String Email;

	private String Password;

	private String Gender;

	private int Age;

	private double Height;

	private double Weight;

	private boolean IsActive;

	private java.sql.Timestamp RegisterDate;

	private String Photographypath;

	private java.util.Set ORM_trial = new java.util.HashSet();

	private void setUserId(int value) {
		this.UserId = value;
	}

	public int getUserId() {
		return UserId;
	}

	public int getORMID() {
		return getUserId();
	}

	public void setName(String value) {
		this.Name = value;
	}

	public String getName() {
		return Name;
	}

	public void setEmail(String value) {
		this.Email = value;
	}

	public String getEmail() {
		return Email;
	}

	public void setPassword(String value) {
		this.Password = value;
	}

	public String getPassword() {
		return Password;
	}

	public void setGender(String value) {
		this.Gender = value;
	}

	public String getGender() {
		return Gender;
	}

	public void setAge(int value) {
		this.Age = value;
	}

	public int getAge() {
		return Age;
	}

	public void setHeight(double value) {
		this.Height = value;
	}

	public double getHeight() {
		return Height;
	}

	public void setWeight(double value) {
		this.Weight = value;
	}

	public double getWeight() {
		return Weight;
	}

	public void setIsActive(boolean value) {
		this.IsActive = value;
	}

	public boolean getIsActive() {
		return IsActive;
	}

	public void setRegisterDate(java.sql.Timestamp value) {
		this.RegisterDate = value;
	}

	public java.sql.Timestamp getRegisterDate() {
		return RegisterDate;
	}

	public void setPhotographypath(String value) {
		this.Photographypath = value;
	}

	public String getPhotographypath() {
		return Photographypath;
	}

	public void setRole(Role value) {
		if (role != null) {
			role.user.remove(this);
		}
		if (value != null) {
			value.user.add(this);
		}
	}

	public Role getRole() {
		return role;
	}

	/**
	 * This method is for internal use only.
	 */
	private void setORM_Role(Role value) {
		this.role = value;
	}

	private Role getORM_Role() {
		return role;
	}

	private void setORM_Trial(java.util.Set value) {
		this.ORM_trial = value;
	}

	private java.util.Set getORM_Trial() {
		return ORM_trial;
	}

	public final TrialSetCollection trial = new TrialSetCollection(this, _ormAdapter, ORMConstants.KEY_USER_TRIAL, ORMConstants.KEY_TRIAL_USER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setTeam(Team value) {
		if (team != null) {
			team.user.remove(this);
		}
		if (value != null) {
			value.user.add(this);
		}
	}
	
	public Team getTeam() {
		return team;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Team(Team value) {
		this.team = value;
	}
	
	private Team getORM_Team() {
		return team;
	}
	
	public String toString() {
		return String.valueOf(getUserId());
	}
	
}
