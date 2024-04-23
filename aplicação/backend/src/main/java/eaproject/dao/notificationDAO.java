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

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.List;

public class NotificationDAO {
    public static Notification loadNotificationByORMID(int NotificationId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadNotificationByORMID(session, NotificationId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification getNotificationByORMID(int NotificationId) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getNotificationByORMID(session, NotificationId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification loadNotificationByORMID(int NotificationId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadNotificationByORMID(session, NotificationId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification getNotificationByORMID(int NotificationId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return getNotificationByORMID(session, NotificationId, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification loadNotificationByORMID(PersistentSession session, int NotificationId) throws PersistentException {
        try {
            return (Notification) session.load(Notification.class, Integer.valueOf(NotificationId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification getNotificationByORMID(PersistentSession session, int NotificationId) throws PersistentException {
        try {
            return (Notification) session.get(Notification.class, Integer.valueOf(NotificationId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification loadNotificationByORMID(PersistentSession session, int NotificationId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Notification) session.load(Notification.class, Integer.valueOf(NotificationId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification getNotificationByORMID(PersistentSession session, int NotificationId, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            return (Notification) session.get(Notification.class, Integer.valueOf(NotificationId), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryNotification(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryNotification(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryNotification(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return queryNotification(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification[] listNotificationByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listNotificationByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification[] listNotificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return listNotificationByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryNotification(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Notification as Notification");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static List queryNotification(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Notification as Notification");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Notification", lockMode);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification[] listNotificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        try {
            List list = queryNotification(session, condition, orderBy);
            return (Notification[]) list.toArray(new Notification[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification[] listNotificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            List list = queryNotification(session, condition, orderBy, lockMode);
            return (Notification[]) list.toArray(new Notification[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification loadNotificationByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadNotificationByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification loadNotificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return loadNotificationByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification loadNotificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        Notification[] notifications = listNotificationByQuery(session, condition, orderBy);
        if (notifications != null && notifications.length > 0)
            return notifications[0];
        else
            return null;
    }

    public static Notification loadNotificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        Notification[] notifications = listNotificationByQuery(session, condition, orderBy, lockMode);
        if (notifications != null && notifications.length > 0)
            return notifications[0];
        else
            return null;
    }

    public static java.util.Iterator iterateNotificationByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateNotificationByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateNotificationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = AASICProjectPersistentManager.instance().getSession();
            return iterateNotificationByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateNotificationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Notification as Notification");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static java.util.Iterator iterateNotificationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From Notification as Notification");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("Notification", lockMode);
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification createNotification() {
        return new Notification();
    }

    public static boolean save(Notification notification) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().saveObject(notification);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean delete(Notification notification) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().deleteObject(notification);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Notification notification) throws PersistentException {
        try {
            if (notification.getCompetition() != null) {
                notification.getCompetition().notification.remove(notification);
            }

            return delete(notification);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean deleteAndDissociate(Notification notification, org.orm.PersistentSession session) throws PersistentException {
        try {
            if (notification.getCompetition() != null) {
                notification.getCompetition().notification.remove(notification);
            }

            try {
                session.delete(notification);
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean refresh(Notification notification) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().refresh(notification);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static boolean evict(Notification notification) throws PersistentException {
        try {
            AASICProjectPersistentManager.instance().getSession().evict(notification);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public static Notification loadNotificationByCriteria(NotificationCriteria notificationCriteria) {
        Notification[] notifications = listNotificationByCriteria(notificationCriteria);
        if (notifications == null || notifications.length == 0) {
            return null;
        }
        return notifications[0];
    }

    public static Notification[] listNotificationByCriteria(NotificationCriteria notificationCriteria) {
        return notificationCriteria.listNotification();
    }
}
