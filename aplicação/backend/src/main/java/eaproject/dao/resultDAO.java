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

public class resultDAO {
	public static result loadResultByORMID(int ResultId) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadResultByORMID(session, ResultId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result getResultByORMID(int ResultId) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return getResultByORMID(session, ResultId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result loadResultByORMID(int ResultId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadResultByORMID(session, ResultId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result getResultByORMID(int ResultId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return getResultByORMID(session, ResultId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result loadResultByORMID(PersistentSession session, int ResultId) throws PersistentException {
		try {
			return (result) session.load(eaproject.dao.result.class, Integer.valueOf(ResultId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result getResultByORMID(PersistentSession session, int ResultId) throws PersistentException {
		try {
			return (result) session.get(eaproject.dao.result.class, Integer.valueOf(ResultId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result loadResultByORMID(PersistentSession session, int ResultId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (result) session.load(eaproject.dao.result.class, Integer.valueOf(ResultId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result getResultByORMID(PersistentSession session, int ResultId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (result) session.get(eaproject.dao.result.class, Integer.valueOf(ResultId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResult(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return queryResult(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResult(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return queryResult(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result[] listResultByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return listResultByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result[] listResultByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return listResultByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResult(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.result as result");
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
	
	public static List queryResult(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.result as result");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("result", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result[] listResultByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryResult(session, condition, orderBy);
			return (result[]) list.toArray(new result[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result[] listResultByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryResult(session, condition, orderBy, lockMode);
			return (result[]) list.toArray(new result[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result loadResultByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadResultByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result loadResultByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return loadResultByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result loadResultByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		result[] results = listResultByQuery(session, condition, orderBy);
		if (results != null && results.length > 0)
			return results[0];
		else
			return null;
	}
	
	public static result loadResultByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		result[] results = listResultByQuery(session, condition, orderBy, lockMode);
		if (results != null && results.length > 0)
			return results[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateResultByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return iterateResultByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResultByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AASICProjectPersistentManager.instance().getSession();
			return iterateResultByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResultByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.result as result");
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
	
	public static java.util.Iterator iterateResultByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eaproject.dao.result as result");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("result", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result createResult() {
		return new eaproject.dao.result();
	}
	
	public static boolean save(eaproject.dao.result lresult) throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().saveObject(lresult);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(eaproject.dao.result lresult) throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().deleteObject(lresult);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.result lresult)throws PersistentException {
		try {
			if (lresult.getTrial() != null) {
				lresult.getTrial().result.remove(lresult);
			}
			
			return delete(lresult);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(eaproject.dao.result lresult, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (lresult.getTrial() != null) {
				lresult.getTrial().result.remove(lresult);
			}
			
			try {
				session.delete(lresult);
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
	
	public static boolean refresh(eaproject.dao.result lresult) throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().getSession().refresh(lresult);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(eaproject.dao.result lresult) throws PersistentException {
		try {
			AASICProjectPersistentManager.instance().getSession().evict(lresult);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static result loadResultByCriteria(resultCriteria resultCriteria) {
		result[] results = listResultByCriteria(resultCriteria);
		if(results == null || results.length == 0) {
			return null;
		}
		return results[0];
	}
	
	public static result[] listResultByCriteria(resultCriteria resultCriteria) {
		return resultCriteria.listResult();
	}
}
