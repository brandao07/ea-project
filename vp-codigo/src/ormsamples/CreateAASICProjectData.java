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
			eaproject.dao.User leaprojectdaoUser = eaproject.dao.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, IsActive, Weight, Height, Age, role
			eaproject.dao.UserDAO.save(leaprojectdaoUser);
			eaproject.dao.Trial leaprojectdaoTrial = eaproject.dao.TrialDAO.createTrial();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : result, IsActive, NumberOfCheckpoints, Distance, user, location, type, grade, competition, state
			eaproject.dao.TrialDAO.save(leaprojectdaoTrial);
			eaproject.dao.Competition leaprojectdaoCompetition = eaproject.dao.CompetitionDAO.createCompetition();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : notification, trial, IsActive
			eaproject.dao.CompetitionDAO.save(leaprojectdaoCompetition);
			eaproject.dao.Result leaprojectdaoResult = eaproject.dao.ResultDAO.createResult();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Position, trial
			eaproject.dao.ResultDAO.save(leaprojectdaoResult);
			eaproject.dao.Grade leaprojectdaoGrade = eaproject.dao.GradeDAO.createGrade();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, MaxHeight, MinHeight, MaxWeight, MinWeight, MaxAge, MinAge
			eaproject.dao.GradeDAO.save(leaprojectdaoGrade);
			eaproject.dao.Location leaprojectdaoLocation = eaproject.dao.LocationDAO.createLocation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, Longitude, Latitude
			eaproject.dao.LocationDAO.save(leaprojectdaoLocation);
			eaproject.dao.Notification leaprojectdaoNotification = eaproject.dao.NotificationDAO.createNotification();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : competition
			eaproject.dao.NotificationDAO.save(leaprojectdaoNotification);
			eaproject.dao.Club leaprojectdaoClub = eaproject.dao.ClubDAO.createClub();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : IsActive
			eaproject.dao.ClubDAO.save(leaprojectdaoClub);
			eaproject.dao.Team leaprojectdaoTeam = eaproject.dao.TeamDAO.createTeam();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : IsActive
			eaproject.dao.TeamDAO.save(leaprojectdaoTeam);
			eaproject.dao.Type leaprojectdaoType = eaproject.dao.TypeDAO.createType();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, NumberOfPersons
			eaproject.dao.TypeDAO.save(leaprojectdaoType);
			eaproject.dao.State leaprojectdaoState = eaproject.dao.StateDAO.createState();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial
			eaproject.dao.StateDAO.save(leaprojectdaoState);
			eaproject.dao.Role leaprojectdaoRole = eaproject.dao.RoleDAO.createRole();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user
			eaproject.dao.RoleDAO.save(leaprojectdaoRole);
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
