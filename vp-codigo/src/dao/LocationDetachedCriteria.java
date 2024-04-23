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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class LocationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression LocationId;
	public final FloatExpression Latitude;
	public final FloatExpression Longitude;
	public final StringExpression Address;
	public final StringExpression City;
	public final StringExpression Country;
	public final StringExpression PostalCode;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public LocationDetachedCriteria() {
		super(dao.Location.class, dao.LocationCriteria.class);
		LocationId = new IntegerExpression("LocationId", this.getDetachedCriteria());
		Latitude = new FloatExpression("Latitude", this.getDetachedCriteria());
		Longitude = new FloatExpression("Longitude", this.getDetachedCriteria());
		Address = new StringExpression("Address", this.getDetachedCriteria());
		City = new StringExpression("City", this.getDetachedCriteria());
		Country = new StringExpression("Country", this.getDetachedCriteria());
		PostalCode = new StringExpression("PostalCode", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public LocationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, dao.LocationCriteria.class);
		LocationId = new IntegerExpression("LocationId", this.getDetachedCriteria());
		Latitude = new FloatExpression("Latitude", this.getDetachedCriteria());
		Longitude = new FloatExpression("Longitude", this.getDetachedCriteria());
		Address = new StringExpression("Address", this.getDetachedCriteria());
		City = new StringExpression("City", this.getDetachedCriteria());
		Country = new StringExpression("Country", this.getDetachedCriteria());
		PostalCode = new StringExpression("PostalCode", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
		trial = new CollectionExpression("ORM_Trial", this.getDetachedCriteria());
	}
	
	public TrialDetachedCriteria createTrialCriteria() {
		return new TrialDetachedCriteria(createCriteria("ORM_Trial"));
	}
	
	public Location uniqueLocation(PersistentSession session) {
		return (Location) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Location[] listLocation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Location[]) list.toArray(new Location[list.size()]);
	}
}

