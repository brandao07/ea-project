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
package dao;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
public class Grade implements Serializable {
	public Grade() {
	}
	
	public static Grade loadGradeByORMID(int GradeId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadGradeByORMID(session, GradeId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade getGradeByORMID(int GradeId) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getGradeByORMID(session, GradeId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByORMID(int GradeId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return loadGradeByORMID(session, GradeId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade getGradeByORMID(int GradeId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AASICProjectPersistentManager.instance().getSession();
			return getGradeByORMID(session, GradeId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByORMID(PersistentSession session, int GradeId) throws PersistentException {
		try {
			return (Grade) session.load(dao.Grade.class, Integer.valueOf(GradeId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade getGradeByORMID(PersistentSession session, int GradeId) throws PersistentException {
		try {
			return (Grade) session.get(dao.Grade.class, Integer.valueOf(GradeId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade loadGradeByORMID(PersistentSession session, int GradeId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Grade) session.load(dao.Grade.class, Integer.valueOf(GradeId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grade getGradeByORMID(PersistentSession session, int GradeId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Grade) session.get(dao.Grade.class, Integer.valueOf(GradeId), lockMode);
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
		StringBuffer sb = new StringBuffer("From dao.Grade as Grade");
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
		StringBuffer sb = new StringBuffer("From dao.Grade as Grade");
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
		StringBuffer sb = new StringBuffer("From dao.Grade as Grade");
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
		StringBuffer sb = new StringBuffer("From dao.Grade as Grade");
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
	
	public static Grade createGrade() {
		return new dao.Grade();
	}
	
	public boolean save() throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			orm.AASICProjectPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			dao.Trial[] lTrials = trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setGrade(null);
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
			dao.Trial[] lTrials = trial.toArray();
			for(int i = 0; i < lTrials.length; i++) {
				lTrials[i].setGrade(null);
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
		if (key == orm.ORMConstants.KEY_GRADE_TRIAL) {
			return ORM_trial;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int GradeId;
	
	private String Name;
	
	private int MinAge;
	
	private int MaxAge;
	
	private double MinWeight;
	
	private double MaxWeight;
	
	private double MinHeight;
	
	private double MaxHeight;
	
	private String Gender;
	
	private java.sql.Timestamp CreationDate;
	
	private java.util.Set ORM_trial = new java.util.HashSet();
	
	private void setGradeId(int value) {
		this.GradeId = value;
	}
	
	public int getGradeId() {
		return GradeId;
	}
	
	public int getORMID() {
		return getGradeId();
	}
	
	public void setName(String value) {
		this.Name = value;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setMinAge(int value) {
		this.MinAge = value;
	}
	
	public int getMinAge() {
		return MinAge;
	}
	
	public void setMaxAge(int value) {
		this.MaxAge = value;
	}
	
	public int getMaxAge() {
		return MaxAge;
	}
	
	public void setMinWeight(double value) {
		this.MinWeight = value;
	}
	
	public double getMinWeight() {
		return MinWeight;
	}
	
	public void setMaxWeight(double value) {
		this.MaxWeight = value;
	}
	
	public double getMaxWeight() {
		return MaxWeight;
	}
	
	public void setMinHeight(double value) {
		this.MinHeight = value;
	}
	
	public double getMinHeight() {
		return MinHeight;
	}
	
	public void setMaxHeight(double value) {
		this.MaxHeight = value;
	}
	
	public double getMaxHeight() {
		return MaxHeight;
	}
	
	public void setGender(String value) {
		this.Gender = value;
	}
	
	public String getGender() {
		return Gender;
	}
	
	public void setCreationDate(java.sql.Timestamp value) {
		this.CreationDate = value;
	}
	
	public java.sql.Timestamp getCreationDate() {
		return CreationDate;
	}
	
	private void setORM_Trial(java.util.Set value) {
		this.ORM_trial = value;
	}
	
	private java.util.Set getORM_Trial() {
		return ORM_trial;
	}
	
	public final dao.TrialSetCollection trial = new dao.TrialSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_GRADE_TRIAL, orm.ORMConstants.KEY_TRIAL_GRADE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getGradeId());
	}
	
}
