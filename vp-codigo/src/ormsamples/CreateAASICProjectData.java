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
			dao.User ldaoUser = dao.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, IsActive, Weight, Height, Age, team, role
			dao.UserDAO.save(ldaoUser);
			dao.Trial ldaoTrial = dao.TrialDAO.createTrial();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : result, IsActive, NumberOfCheckpoints, Distance, user, location, type, grade, competition, state
			dao.TrialDAO.save(ldaoTrial);
			dao.Competition ldaoCompetition = dao.CompetitionDAO.createCompetition();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : notification, trial, IsActive
			dao.CompetitionDAO.save(ldaoCompetition);
			dao.Result ldaoResult = dao.ResultDAO.createResult();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Position, trial
			dao.ResultDAO.save(ldaoResult);
			dao.Grade ldaoGrade = dao.GradeDAO.createGrade();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, MaxHeight, MinHeight, MaxWeight, MinWeight, MaxAge, MinAge
			dao.GradeDAO.save(ldaoGrade);
			dao.Location ldaoLocation = dao.LocationDAO.createLocation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, Longitude, Latitude
			dao.LocationDAO.save(ldaoLocation);
			dao.Notification ldaoNotification = dao.NotificationDAO.createNotification();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : competition
			dao.NotificationDAO.save(ldaoNotification);
			dao.Club ldaoClub = dao.ClubDAO.createClub();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : team, IsActive
			dao.ClubDAO.save(ldaoClub);
			dao.Team ldaoTeam = dao.TeamDAO.createTeam();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user, IsActive, club
			dao.TeamDAO.save(ldaoTeam);
			dao.Type ldaoType = dao.TypeDAO.createType();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial, NumberOfPersons
			dao.TypeDAO.save(ldaoType);
			dao.State ldaoState = dao.StateDAO.createState();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : trial
			dao.StateDAO.save(ldaoState);
			dao.Role ldaoRole = dao.RoleDAO.createRole();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user
			dao.RoleDAO.save(ldaoRole);
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
