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

import eaproject.constants.ORMConstants;

import java.io.Serializable;

public class Competition implements Serializable {
    public Competition() {
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_COMPETITION_TRIAL) {
            return ORM_trial;
        } else if (key == ORMConstants.KEY_COMPETITION_NOTIFICATION) {
            return ORM_notification;
        }

        return null;
    }

    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };

    private int CompetitionId;

    private String Name;

    private java.sql.Timestamp StartDate;

    private java.sql.Timestamp EndDate;

    private boolean IsActive;

    private java.sql.Timestamp CreationDate;

    private java.util.Set ORM_trial = new java.util.HashSet();

    private java.util.Set ORM_notification = new java.util.HashSet();

    private void setCompetitionId(int value) {
        this.CompetitionId = value;
    }

    public int getCompetitionId() {
        return CompetitionId;
    }

    public int getORMID() {
        return getCompetitionId();
    }

    public void setName(String value) {
        this.Name = value;
    }

    public String getName() {
        return Name;
    }

    public void setStartDate(java.sql.Timestamp value) {
        this.StartDate = value;
    }

    public java.sql.Timestamp getStartDate() {
        return StartDate;
    }

    public void setEndDate(java.sql.Timestamp value) {
        this.EndDate = value;
    }

    public java.sql.Timestamp getEndDate() {
        return EndDate;
    }

    public void setIsActive(boolean value) {
        this.IsActive = value;
    }

    public boolean getIsActive() {
        return IsActive;
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

    public final TrialSetCollection trial = new TrialSetCollection(this, _ormAdapter, ORMConstants.KEY_COMPETITION_TRIAL, ORMConstants.KEY_TRIAL_COMPETITION, ORMConstants.KEY_MUL_ONE_TO_MANY);

    private void setORM_Notification(java.util.Set value) {
        this.ORM_notification = value;
    }

    private java.util.Set getORM_Notification() {
        return ORM_notification;
    }

    public final NotificationSetCollection notification = new NotificationSetCollection(this, _ormAdapter, ORMConstants.KEY_COMPETITION_NOTIFICATION, ORMConstants.KEY_NOTIFICATION_COMPETITION, ORMConstants.KEY_MUL_ONE_TO_MANY);

    public String toString() {
        return String.valueOf(getCompetitionId());
    }

}
