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

public class Type implements Serializable {
    public Type() {
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_TYPE_TRIAL) {
            return ORM_trial;
        }

        return null;
    }

    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };

    private int TypeId;

    private String Name;

    private int NumberOfPersons;

    private java.sql.Timestamp CreationDate;

    private java.util.Set ORM_trial = new java.util.HashSet();

    private void setTypeId(int value) {
        this.TypeId = value;
    }

    public int getTypeId() {
        return TypeId;
    }

    public int getORMID() {
        return getTypeId();
    }

    public void setName(String value) {
        this.Name = value;
    }

    public String getName() {
        return Name;
    }

    public void setNumberOfPersons(int value) {
        this.NumberOfPersons = value;
    }

    public int getNumberOfPersons() {
        return NumberOfPersons;
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

    public final TrialSetCollection trial = new TrialSetCollection(this, _ormAdapter, ORMConstants.KEY_TYPE_TRIAL, ORMConstants.KEY_TRIAL_TYPE, ORMConstants.KEY_MUL_ONE_TO_MANY);

    public String toString() {
        return String.valueOf(getTypeId());
    }

}
