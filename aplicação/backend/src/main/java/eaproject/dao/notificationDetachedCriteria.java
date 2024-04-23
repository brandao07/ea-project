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

public class NotificationDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression NotificationId;
    public final IntegerExpression competitionId;
    public final AssociationExpression competition;
    public final StringExpression MessageHeader;
    public final StringExpression MessageBody;
    public final StringExpression MessageType;
    public final TimestampExpression CreationDate;

    public NotificationDetachedCriteria() {
        super(Notification.class, NotificationCriteria.class);
        NotificationId = new IntegerExpression("NotificationId", this.getDetachedCriteria());
        competitionId = new IntegerExpression("competition.CompetitionId", this.getDetachedCriteria());
        competition = new AssociationExpression("competition", this.getDetachedCriteria());
        MessageHeader = new StringExpression("MessageHeader", this.getDetachedCriteria());
        MessageBody = new StringExpression("MessageBody", this.getDetachedCriteria());
        MessageType = new StringExpression("MessageType", this.getDetachedCriteria());
        CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
    }

    public NotificationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, NotificationCriteria.class);
        NotificationId = new IntegerExpression("NotificationId", this.getDetachedCriteria());
        competitionId = new IntegerExpression("competition.CompetitionId", this.getDetachedCriteria());
        competition = new AssociationExpression("competition", this.getDetachedCriteria());
        MessageHeader = new StringExpression("MessageHeader", this.getDetachedCriteria());
        MessageBody = new StringExpression("MessageBody", this.getDetachedCriteria());
        MessageType = new StringExpression("MessageType", this.getDetachedCriteria());
        CreationDate = new TimestampExpression("CreationDate", this.getDetachedCriteria());
    }

    public CompetitionDetachedCriteria createCompetitionCriteria() {
        return new CompetitionDetachedCriteria(createCriteria("competition"));
    }

    public Notification uniqueNotification(PersistentSession session) {
        return (Notification) super.createExecutableCriteria(session).uniqueResult();
    }

    public Notification[] listNotification(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Notification[]) list.toArray(new Notification[list.size()]);
    }
}

