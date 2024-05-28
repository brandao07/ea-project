/**
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateAASICProjectData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = orm.AASICProjectPersistentManager.instance().getSession().beginTransaction();
		try {
			eaproject.dao.User leaprojectdaoUser = eaproject.dao.UserDAO.loadUserByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.UserDAO.save(leaprojectdaoUser);
			eaproject.dao.Trial leaprojectdaoTrial = eaproject.dao.TrialDAO.loadTrialByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.TrialDAO.save(leaprojectdaoTrial);
			eaproject.dao.Competition leaprojectdaoCompetition = eaproject.dao.CompetitionDAO.loadCompetitionByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.CompetitionDAO.save(leaprojectdaoCompetition);
			eaproject.dao.Result leaprojectdaoResult = eaproject.dao.ResultDAO.loadResultByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.ResultDAO.save(leaprojectdaoResult);
			eaproject.dao.Grade leaprojectdaoGrade = eaproject.dao.GradeDAO.loadGradeByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.GradeDAO.save(leaprojectdaoGrade);
			eaproject.dao.Location leaprojectdaoLocation = eaproject.dao.LocationDAO.loadLocationByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.LocationDAO.save(leaprojectdaoLocation);
			eaproject.dao.Notification leaprojectdaoNotification = eaproject.dao.NotificationDAO.loadNotificationByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.NotificationDAO.save(leaprojectdaoNotification);
			eaproject.dao.Club leaprojectdaoClub = eaproject.dao.ClubDAO.loadClubByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.ClubDAO.save(leaprojectdaoClub);
			eaproject.dao.Team leaprojectdaoTeam = eaproject.dao.TeamDAO.loadTeamByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.TeamDAO.save(leaprojectdaoTeam);
			eaproject.dao.Type leaprojectdaoType = eaproject.dao.TypeDAO.loadTypeByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.TypeDAO.save(leaprojectdaoType);
			eaproject.dao.State leaprojectdaoState = eaproject.dao.StateDAO.loadStateByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.StateDAO.save(leaprojectdaoState);
			eaproject.dao.Role leaprojectdaoRole = eaproject.dao.RoleDAO.loadRoleByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.RoleDAO.save(leaprojectdaoRole);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving User by UserCriteria");
		eaproject.dao.UserCriteria leaprojectdaoUserCriteria = new eaproject.dao.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoUserCriteria.UserId.eq();
		System.out.println(leaprojectdaoUserCriteria.uniqueUser());
		
		System.out.println("Retrieving Trial by TrialCriteria");
		eaproject.dao.TrialCriteria leaprojectdaoTrialCriteria = new eaproject.dao.TrialCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoTrialCriteria.TrialId.eq();
		System.out.println(leaprojectdaoTrialCriteria.uniqueTrial());
		
		System.out.println("Retrieving Competition by CompetitionCriteria");
		eaproject.dao.CompetitionCriteria leaprojectdaoCompetitionCriteria = new eaproject.dao.CompetitionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoCompetitionCriteria.CompetitionId.eq();
		System.out.println(leaprojectdaoCompetitionCriteria.uniqueCompetition());
		
		System.out.println("Retrieving Result by ResultCriteria");
		eaproject.dao.ResultCriteria leaprojectdaoResultCriteria = new eaproject.dao.ResultCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoResultCriteria.ResultId.eq();
		System.out.println(leaprojectdaoResultCriteria.uniqueResult());
		
		System.out.println("Retrieving Grade by GradeCriteria");
		eaproject.dao.GradeCriteria leaprojectdaoGradeCriteria = new eaproject.dao.GradeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoGradeCriteria.GradeId.eq();
		System.out.println(leaprojectdaoGradeCriteria.uniqueGrade());
		
		System.out.println("Retrieving Location by LocationCriteria");
		eaproject.dao.LocationCriteria leaprojectdaoLocationCriteria = new eaproject.dao.LocationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoLocationCriteria.LocationId.eq();
		System.out.println(leaprojectdaoLocationCriteria.uniqueLocation());
		
		System.out.println("Retrieving Notification by NotificationCriteria");
		eaproject.dao.NotificationCriteria leaprojectdaoNotificationCriteria = new eaproject.dao.NotificationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoNotificationCriteria.NotificationId.eq();
		System.out.println(leaprojectdaoNotificationCriteria.uniqueNotification());
		
		System.out.println("Retrieving Club by ClubCriteria");
		eaproject.dao.ClubCriteria leaprojectdaoClubCriteria = new eaproject.dao.ClubCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoClubCriteria.ClubId.eq();
		System.out.println(leaprojectdaoClubCriteria.uniqueClub());
		
		System.out.println("Retrieving Team by TeamCriteria");
		eaproject.dao.TeamCriteria leaprojectdaoTeamCriteria = new eaproject.dao.TeamCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoTeamCriteria.TeamId.eq();
		System.out.println(leaprojectdaoTeamCriteria.uniqueTeam());
		
		System.out.println("Retrieving Type by TypeCriteria");
		eaproject.dao.TypeCriteria leaprojectdaoTypeCriteria = new eaproject.dao.TypeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoTypeCriteria.TypeId.eq();
		System.out.println(leaprojectdaoTypeCriteria.uniqueType());
		
		System.out.println("Retrieving State by StateCriteria");
		eaproject.dao.StateCriteria leaprojectdaoStateCriteria = new eaproject.dao.StateCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoStateCriteria.StateId.eq();
		System.out.println(leaprojectdaoStateCriteria.uniqueState());
		
		System.out.println("Retrieving Role by RoleCriteria");
		eaproject.dao.RoleCriteria leaprojectdaoRoleCriteria = new eaproject.dao.RoleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoRoleCriteria.RoleId.eq();
		System.out.println(leaprojectdaoRoleCriteria.uniqueRole());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateAASICProjectData retrieveAndUpdateAASICProjectData = new RetrieveAndUpdateAASICProjectData();
			try {
				retrieveAndUpdateAASICProjectData.retrieveAndUpdateTestData();
				//retrieveAndUpdateAASICProjectData.retrieveByCriteria();
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
