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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class locationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression LocationId;
	public final FloatExpression Latitude;
	public final FloatExpression Longitude;
	public final StringExpression Address;
	public final StringExpression City;
	public final StringExpression Country;
	public final StringExpression PostalCode;
	public final TimestampExpression CreationDate;
	public final CollectionExpression trial;
	
	public locationDetachedCriteria() {
		super(eaproject.dao.location.class, eaproject.dao.locationCriteria.class);
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
	
	public locationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eaproject.dao.locationCriteria.class);
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
	
	public trialDetachedCriteria createTrialCriteria() {
		return new trialDetachedCriteria(createCriteria("ORM_Trial"));
	}
	
	public location uniqueLocation(PersistentSession session) {
		return (location) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public location[] listLocation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (location[]) list.toArray(new location[list.size()]);
	}
}

