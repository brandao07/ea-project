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

public class LocationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression Id;
	public final DoubleExpression Latitude;
	public final DoubleExpression Longitude;
	public final StringExpression Address;
	public final StringExpression City;
	public final StringExpression Country;
	public final StringExpression PostalCode;
	public final TimestampExpression CreationDate;
	
	public LocationDetachedCriteria() {
		super(eaproject.dao.Location.class, eaproject.dao.LocationCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Latitude = new DoubleExpression("Latitude", this.getDetachedCriteria());
		Longitude = new DoubleExpression("Longitude", this.getDetachedCriteria());
		Address = new StringExpression("Address", this.getDetachedCriteria());
		City = new StringExpression("City", this.getDetachedCriteria());
		Country = new StringExpression("Country", this.getDetachedCriteria());
		PostalCode = new StringExpression("PostalCode", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public LocationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.LocationCriteria.class);
		Id = new IntegerExpression("Id", this.getDetachedCriteria());
		Latitude = new DoubleExpression("Latitude", this.getDetachedCriteria());
		Longitude = new DoubleExpression("Longitude", this.getDetachedCriteria());
		Address = new StringExpression("Address", this.getDetachedCriteria());
		City = new StringExpression("City", this.getDetachedCriteria());
		Country = new StringExpression("Country", this.getDetachedCriteria());
		PostalCode = new StringExpression("PostalCode", this.getDetachedCriteria());
		CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
	}
	
	public Location uniqueLocation(PersistentSession session) {
		return (Location) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Location[] listLocation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Location[]) list.toArray(new Location[list.size()]);
	}
}

