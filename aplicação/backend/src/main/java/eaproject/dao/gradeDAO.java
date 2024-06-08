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

public class GradeDAO {
	public static Grade loadGradeByORMID(Integer Id) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadGradeByORMID(session, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade getGradeByORMID(Integer Id) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getGradeByORMID(session, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByORMID(Integer Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadGradeByORMID(session, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade getGradeByORMID(Integer Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getGradeByORMID(session, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByORMID(PersistentSession session, Integer Id) throws PersistentException {
		try {
			return (Grade) session.load(eaproject.dao.Grade.class, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade getGradeByORMID(PersistentSession session, Integer Id) throws PersistentException {
		try {
			return (Grade) session.get(eaproject.dao.Grade.class, Id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByORMID(PersistentSession session, Integer Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Grade) session.load(eaproject.dao.Grade.class, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade getGradeByORMID(PersistentSession session, Integer Id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Grade) session.get(eaproject.dao.Grade.class, Id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGrade(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryGrade(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGrade(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return queryGrade(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade[] listGradeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listGradeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade[] listGradeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return listGradeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGrade(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Grade as Grade");
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
	
	public static List queryGrade(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Grade as Grade");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Grade", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade[] listGradeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGrade(session, condition, orderBy);
			return (Grade[]) list.toArray(new Grade[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade[] listGradeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGrade(session, condition, orderBy, lockMode);
			return (Grade[]) list.toArray(new Grade[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadGradeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadGradeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Grade[] grades = listGradeByQuery(session, condition, orderBy);
		if (grades != null && grades.length > 0)
			return grades[0];
		else
			return null;
	}
	
	public static Grade loadGradeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Grade[] grades = listGradeByQuery(session, condition, orderBy, lockMode);
		if (grades != null && grades.length > 0)
			return grades[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateGradeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateGradeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGradeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return iterateGradeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGradeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Grade as Grade");
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
	
	public static java.util.Iterator iterateGradeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.Grade as Grade");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Grade", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade createGrade() {
		return new eaproject.dao.Grade();
	}
	
	public static boolean save(eaproject.dao.Grade grade) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(grade);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.Grade grade) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(grade);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(eaproject.dao.Grade grade) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(grade);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.Grade grade) throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(grade);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByCriteria(GradeCriteria gradeCriteria) {
		Grade[] grades = listGradeByCriteria(gradeCriteria);
		if(grades == null || grades.length == 0) {
			return null;
		}
		return grades[0];
	}
	
	public static Grade[] listGradeByCriteria(GradeCriteria gradeCriteria) {
		return gradeCriteria.listGrade();
	}
}
