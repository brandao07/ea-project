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

import org.orm.*;

public class NotificationListCollection extends org.orm.util.ORMList {
	public NotificationListCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public NotificationListCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persistent objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMList
	 * @param value the persistent object
	 */
	public void add(Notification value) {
		if (value != null) {
			super.add(value, value._ormAdapter);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMList
	 * @param value the persistent object
	 */
	public void remove(Notification value) {
		super.remove(value, value._ormAdapter);
	}
	
	/**
	 * Return true if ORMList contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Notification value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMList
	 * @return The persistent objects array
	 */
	public Notification[] toArray() {
		return (Notification[]) super.toArray(new Notification[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMList
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>Id</li>
	 * <li>MessageHeader</li>
	 * <li>MessageBody</li>
	 * <li>MessageType</li>
	 * <li>CreationDate</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Notification[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMList
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>Id</li>
	 * <li>MessageHeader</li>
	 * <li>MessageBody</li>
	 * <li>MessageType</li>
	 * <li>CreationDate</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Notification[] toArray(String propertyName, boolean ascending) {
		return (Notification[]) super.toArray(new Notification[size()], propertyName, ascending);
	}
	
	/**
	 * Return the persistent object at the specified position in ORMList.
	 * @param index - The specified position
	 * @return - The persistent object
	 */
	public Notification get(int index) {
		return (Notification) super.getImpl(index);
	}
	
	/**
	 * Remove the persistent object at the specified position in ORMList.
	 * @param index The specified position
	 * @return Removed persistent object
	 */
	public Notification remove(int index) {
		Notification value = get(index);
		if (value != null) {
			return (Notification) super.removeImpl(index, value._ormAdapter);
		}
		return null;
	}
	
	/**
	 * Insert the specified persistent object at the specified position in ORMList.
	 * @param index The specified position
	 * @param value The specified persistent object
	 */
	public void add(int index, Notification value) {
		if (value != null) {
			super.add(index, value, value._ormAdapter);
		}
	}
	
	/**
	 * Find the specified position of specified persistent object ORMList.
	 * @param value The persistent object
	 */
	public int indexOf(Notification value) {
		return super.indexOf(value);
	}
	
	/**
	 * Replace the persistent object at the specified position in ORMList with the specified persistent object.
	 * @param index The specified position
	 * @param value The persistent object
	 * @return Return replaced object
	 */
	public Notification set(int index, Notification value) {
		return (Notification) super.set(index, value);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return orm.AASICProjectPersistentManager.instance();
	}
	
}

