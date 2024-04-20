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
			eaproject.dao.user leaprojectdaouser = eaproject.dao.userDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, IsActive, Weight, Height, Age, team, role
			eaproject.dao.userDAO.save(leaprojectdaouser);
			eaproject.dao.trial leaprojectdaotrial = eaproject.dao.trialDAO.createTrial();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : result, IsActive, NumberOfCheckpoints, Distance, user, location, type, grade, competition, state
			eaproject.dao.trialDAO.save(leaprojectdaotrial);
			eaproject.dao.competition leaprojectdaocompetition = eaproject.dao.competitionDAO.createCompetition();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : notification, trial, IsActive
			eaproject.dao.competitionDAO.save(leaprojectdaocompetition);
			eaproject.dao.result leaprojectdaoresult = eaproject.dao.resultDAO.createResult();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Position, trial
			eaproject.dao.resultDAO.save(leaprojectdaoresult);
			eaproject.dao.grade leaprojectdaograde = eaproject.dao.gradeDAO.createGrade();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, MaxHeight, MinHeight, MaxWeight, MinWeight, MaxAge, MinAge
			eaproject.dao.gradeDAO.save(leaprojectdaograde);
			eaproject.dao.location leaprojectdaolocation = eaproject.dao.locationDAO.createLocation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, Longitude, Latitude
			eaproject.dao.locationDAO.save(leaprojectdaolocation);
			eaproject.dao.notification leaprojectdaonotification = eaproject.dao.notificationDAO.createNotification();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : competition
			eaproject.dao.notificationDAO.save(leaprojectdaonotification);
			eaproject.dao.club leaprojectdaoclub = eaproject.dao.clubDAO.createClub();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : team, IsActive
			eaproject.dao.clubDAO.save(leaprojectdaoclub);
			eaproject.dao.team leaprojectdaoteam = eaproject.dao.teamDAO.createTeam();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user, IsActive, club
			eaproject.dao.teamDAO.save(leaprojectdaoteam);
			eaproject.dao.type leaprojectdaotype = eaproject.dao.typeDAO.createType();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, NumberOfPersons
			eaproject.dao.typeDAO.save(leaprojectdaotype);
			eaproject.dao.state leaprojectdaostate = eaproject.dao.stateDAO.createState();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial
			eaproject.dao.stateDAO.save(leaprojectdaostate);
			eaproject.dao.role leaprojectdaorole = eaproject.dao.roleDAO.createRole();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user
			eaproject.dao.roleDAO.save(leaprojectdaorole);
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
