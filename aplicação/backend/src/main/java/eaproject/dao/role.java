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

public class Role implements Serializable {
    public Role() {
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_ROLE_USER) {
            return ORM_user;
        }

        return null;
    }

    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };

    private int RoleId;

    private String Name;

    private String Description;

    private java.sql.Timestamp CreationDate;

    private java.util.Set ORM_user = new java.util.HashSet();

    private void setRoleId(int value) {
        this.RoleId = value;
    }

    public int getRoleId() {
        return RoleId;
    }

    public int getORMID() {
        return getRoleId();
    }

    public void setName(String value) {
        this.Name = value;
    }

    public String getName() {
        return Name;
    }

    public void setDescription(String value) {
        this.Description = value;
    }

    public String getDescription() {
        return Description;
    }

    public void setCreationDate(java.sql.Timestamp value) {
        this.CreationDate = value;
    }

    public java.sql.Timestamp getCreationDate() {
        return CreationDate;
    }

    private void setORM_User(java.util.Set value) {
        this.ORM_user = value;
    }

    private java.util.Set getORM_User() {
        return ORM_user;
    }

    public final UserSetCollection user = new UserSetCollection(this, _ormAdapter, ORMConstants.KEY_ROLE_USER, ORMConstants.KEY_USER_ROLE, ORMConstants.KEY_MUL_ONE_TO_MANY);

    public String toString() {
        return String.valueOf(getRoleId());
    }

}
