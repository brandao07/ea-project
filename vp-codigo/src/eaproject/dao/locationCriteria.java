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

public class locationCriteria extends AbstractORMCriteria {
	public final IntegerExpression LocationId;
	public final FloatExpression Latitude;
	public final FloatExpression Longitude;
	public final StringExpression Address;
	public final StringExpression City;
	public final StringExpression Country;
	public final StringExpression PostalCode;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public locationCriteria(Criteria criteria) {
		super(criteria);
		LocationId = new IntegerExpression("LocationId", this);
		Latitude = new FloatExpression("Latitude", this);
		Longitude = new FloatExpression("Longitude", this);
		Address = new StringExpression("Address", this);
		City = new StringExpression("City", this);
		Country = new StringExpression("Country", this);
		PostalCode = new StringExpression("PostalCode", this);
		CreationDate = new TimestampExpression("CreationDate", this);
		trial = new CollectionExpression("ORM_Trial", this);
	}
	
	public locationCriteria(PersistentSession session) {
		this(session.createCriteria(location.class));
	}
	
	public locationCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public trialCriteria createTrialCriteria() {
		return new trialCriteria(createCriteria("ORM_Trial"));
	}
	
	public location uniqueLocation() {
		return (location) super.uniqueResult();
	}
	
	public location[] listLocation() {
		java.util.List list = super.list();
		return (location[]) list.toArray(new location[list.size()]);
	}
}

