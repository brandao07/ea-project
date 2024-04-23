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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class LocationCriteria extends AbstractORMCriteria {
	public final IntegerExpression LocationId;
	public final FloatExpression Latitude;
	public final FloatExpression Longitude;
	public final StringExpression Address;
	public final StringExpression City;
	public final StringExpression Country;
	public final StringExpression PostalCode;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public LocationCriteria(Criteria criteria) {
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
	
	public LocationCriteria(PersistentSession session) {
		this(session.createCriteria(Location.class));
	}
	
	public LocationCriteria() throws PersistentException {
		this(orm.AASICProjectPersistentManager.instance().getSession());
	}
	
	public TrialCriteria createTrialCriteria() {
		return new TrialCriteria(createCriteria("ORM_Trial"));
	}
	
	public Location uniqueLocation() {
		return (Location) super.uniqueResult();
	}
	
	public Location[] listLocation() {
		java.util.List list = super.list();
		return (Location[]) list.toArray(new Location[list.size()]);
	}
}

