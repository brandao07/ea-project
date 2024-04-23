/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */

/**
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */
package eaproject.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import java.util.List;

public class ClubDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression ClubId;
    public final StringExpression Name;
    public final BooleanExpression IsActive;
    public final TimestampExpression CreationDate;
    public final CollectionExpression team;

    public ClubDetachedCriteria() {
        super(Club.class, ClubCriteria.class);
        ClubId = new IntegerExpression("ClubId", this.getDetachedCriteria());
        Name = new StringExpression("Name", this.getDetachedCriteria());
        IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
        CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
        team = new CollectionExpression("ORM_Team", this.getDetachedCriteria());
    }

    public ClubDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, ClubCriteria.class);
        ClubId = new IntegerExpression("ClubId", this.getDetachedCriteria());
        Name = new StringExpression("Name", this.getDetachedCriteria());
        IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
        CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
        team = new CollectionExpression("ORM_Team", this.getDetachedCriteria());
    }

    public TeamDetachedCriteria createTeamCriteria() {
        return new TeamDetachedCriteria(createCriteria("ORM_Team"));
    }

    public Club uniqueClub(PersistentSession session) {
        return (Club) super.createExecutableCriteria(session).uniqueResult();
    }

    public Club[] listClub(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Club[]) list.toArray(new Club[list.size()]);
    }
}

