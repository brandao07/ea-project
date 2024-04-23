/**
 * Licensee: User-PC(University of Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateAASICProjectDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(orm.AASICProjectPersistentManager.instance());
			orm.AASICProjectPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
