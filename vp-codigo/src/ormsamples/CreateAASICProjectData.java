/**
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateAASICProjectData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.AASICProjectPersistentManager.instance().getSession().beginTransaction();
		try {
			dao.User ldaoUser = dao.User.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, IsActive, Weight, Height, Age, team, role
			ldaoUser.save();
			dao.Trial ldaoTrial = dao.Trial.createTrial();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : result, IsActive, NumberOfCheckpoints, Distance, user, location, type, grade, competition, state
			ldaoTrial.save();
			dao.Competition ldaoCompetition = dao.Competition.createCompetition();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : notification, trial, IsActive
			ldaoCompetition.save();
			dao.Result ldaoResult = dao.Result.createResult();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Position, trial
			ldaoResult.save();
			dao.Grade ldaoGrade = dao.Grade.createGrade();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, MaxHeight, MinHeight, MaxWeight, MinWeight, MaxAge, MinAge
			ldaoGrade.save();
			dao.Location ldaoLocation = dao.Location.createLocation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, Longitude, Latitude
			ldaoLocation.save();
			dao.Notification ldaoNotification = dao.Notification.createNotification();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : competition
			ldaoNotification.save();
			dao.Club ldaoClub = dao.Club.createClub();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : team, IsActive
			ldaoClub.save();
			dao.Team ldaoTeam = dao.Team.createTeam();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user, IsActive, club
			ldaoTeam.save();
			dao.Type ldaoType = dao.Type.createType();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, NumberOfPersons
			ldaoType.save();
			dao.State ldaoState = dao.State.createState();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial
			ldaoState.save();
			dao.Role ldaoRole = dao.Role.createRole();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user
			ldaoRole.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateAASICProjectData createAASICProjectData = new CreateAASICProjectData();
			try {
				createAASICProjectData.createTestData();
			}
			finally {
				orm.AASICProjectPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
