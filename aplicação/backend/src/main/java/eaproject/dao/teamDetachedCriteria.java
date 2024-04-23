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

public class TeamDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression TeamId;
    public final IntegerExpression clubId;
    public final AssociationExpression club;
    public final StringExpression Name;
    public final BooleanExpression IsActive;
    public final TimestampExpression CreationDate;
    public final CollectionExpression user;

    public TeamDetachedCriteria() {
        super(Team.class, TeamCriteria.class);
        TeamId = new IntegerExpression("TeamId", this.getDetachedCriteria());
        clubId = new IntegerExpression("club.ClubId", this.getDetachedCriteria());
        club = new AssociationExpression("club", this.getDetachedCriteria());
        Name = new StringExpression("Name", this.getDetachedCriteria());
        IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
        CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
        user = new CollectionExpression("ORM_User", this.getDetachedCriteria());
    }

    public TeamDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, TeamCriteria.class);
        TeamId = new IntegerExpression("TeamId", this.getDetachedCriteria());
        clubId = new IntegerExpression("club.ClubId", this.getDetachedCriteria());
        club = new AssociationExpression("club", this.getDetachedCriteria());
        Name = new StringExpression("Name", this.getDetachedCriteria());
        IsActive = new BooleanExpression("IsActive", this.getDetachedCriteria());
        CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
        user = new CollectionExpression("ORM_User", this.getDetachedCriteria());
    }

    public ClubDetachedCriteria createClubCriteria() {
        return new ClubDetachedCriteria(createCriteria("club"));
    }

    public UserDetachedCriteria createUserCriteria() {
        return new UserDetachedCriteria(createCriteria("ORM_User"));
    }

    public Team uniqueTeam(PersistentSession session) {
        return (Team) super.createExecutableCriteria(session).uniqueResult();
    }

    public Team[] listTeam(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Team[]) list.toArray(new Team[list.size()]);
    }
}

