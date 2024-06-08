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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class RoleDAO {
	public static Role loadRoleByORMID(Integer Id) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadRoleByORMID(session, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role getRoleByORMID(Integer Id) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getRoleByORMID(session, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role loadRoleByORMID(Integer Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadRoleByORMID(session, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role getRoleByORMID(Integer Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getRoleByORMID(session, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role loadRoleByORMID(PersistentSession session, Integer Id) throws PersistentException {
		try {
			return (Role) session.load(eaproject.dao.Role.class, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role getRoleByORMID(PersistentSession session, Integer Id) throws PersistentException {
		try {
			return (Role) session.get(eaproject.dao.Role.class, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role loadRoleByORMID(PersistentSession session, Integer Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Role) session.load(eaproject.dao.Role.class, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role getRoleByORMID(PersistentSession session, Integer Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Role) session.get(eaproject.dao.Role.class, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRole(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryRole(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRole(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryRole(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role[] listRoleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listRoleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role[] listRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listRoleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRole(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Role as Role");
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
	
	public static List queryRole(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Role as Role");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Role", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role[] listRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRole(session, condition, orderBy);
			return (Role[]) list.toArray(new Role[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role[] listRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRole(session, condition, orderBy, lockMode);
			return (Role[]) list.toArray(new Role[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role loadRoleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadRoleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role loadRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadRoleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role loadRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Role[] roles = listRoleByQuery(session, condition, orderBy);
		if (roles != null && roles.length > 0)
			return roles[0];
		else
			return null;
	}
	
	public static Role loadRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Role[] roles = listRoleByQuery(session, condition, orderBy, lockMode);
		if (roles != null && roles.length > 0)
			return roles[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRoleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateRoleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateRoleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Role as Role");
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
	
	public static java.util.Iterator iterateRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Role as Role");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Role", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role createRole() {
		return new eaproject.dao.Role();
	}
	
	public static boolean save(eaproject.dao.Role role) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(role);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.Role role) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(role);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(eaproject.dao.Role role) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(role);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.Role role) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(role);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Role loadRoleByCriteria(RoleCriteria roleCriteria) {
		Role[] roles = listRoleByCriteria(roleCriteria);
		if(roles == null || roles.length == 0) {
			return null;
		}
		return roles[0];
	}
	
	public static Role[] listRoleByCriteria(RoleCriteria roleCriteria) {
		return roleCriteria.listRole();
	}
}
