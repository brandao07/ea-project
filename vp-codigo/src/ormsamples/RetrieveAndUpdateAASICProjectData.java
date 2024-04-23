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
			dao.User ldaoUser = dao.UserDAO.loadUserByQuery(null, null);
			// Update the properties of the persistent object
			dao.UserDAO.save(ldaoUser);
			dao.Trial ldaoTrial = dao.TrialDAO.loadTrialByQuery(null, null);
			// Update the properties of the persistent object
			dao.TrialDAO.save(ldaoTrial);
			dao.Competition ldaoCompetition = dao.CompetitionDAO.loadCompetitionByQuery(null, null);
			// Update the properties of the persistent object
			dao.CompetitionDAO.save(ldaoCompetition);
			dao.Result ldaoResult = dao.ResultDAO.loadResultByQuery(null, null);
			// Update the properties of the persistent object
			dao.ResultDAO.save(ldaoResult);
			dao.Grade ldaoGrade = dao.GradeDAO.loadGradeByQuery(null, null);
			// Update the properties of the persistent object
			dao.GradeDAO.save(ldaoGrade);
			dao.Location ldaoLocation = dao.LocationDAO.loadLocationByQuery(null, null);
			// Update the properties of the persistent object
			dao.LocationDAO.save(ldaoLocation);
			dao.Notification ldaoNotification = dao.NotificationDAO.loadNotificationByQuery(null, null);
			// Update the properties of the persistent object
			dao.NotificationDAO.save(ldaoNotification);
			dao.Club ldaoClub = dao.ClubDAO.loadClubByQuery(null, null);
			// Update the properties of the persistent object
			dao.ClubDAO.save(ldaoClub);
			dao.Team ldaoTeam = dao.TeamDAO.loadTeamByQuery(null, null);
			// Update the properties of the persistent object
			dao.TeamDAO.save(ldaoTeam);
			dao.Type ldaoType = dao.TypeDAO.loadTypeByQuery(null, null);
			// Update the properties of the persistent object
			dao.TypeDAO.save(ldaoType);
			dao.State ldaoState = dao.StateDAO.loadStateByQuery(null, null);
			// Update the properties of the persistent object
			dao.StateDAO.save(ldaoState);
			dao.Role ldaoRole = dao.RoleDAO.loadRoleByQuery(null, null);
			// Update the properties of the persistent object
			dao.RoleDAO.save(ldaoRole);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving User by UserCriteria");
		dao.UserCriteria ldaoUserCriteria = new dao.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoUserCriteria.UserId.eq();
		System.out.println(ldaoUserCriteria.uniqueUser());
		
		System.out.println("Retrieving Trial by TrialCriteria");
		dao.TrialCriteria ldaoTrialCriteria = new dao.TrialCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoTrialCriteria.TrialId.eq();
		System.out.println(ldaoTrialCriteria.uniqueTrial());
		
		System.out.println("Retrieving Competition by CompetitionCriteria");
		dao.CompetitionCriteria ldaoCompetitionCriteria = new dao.CompetitionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoCompetitionCriteria.CompetitionId.eq();
		System.out.println(ldaoCompetitionCriteria.uniqueCompetition());
		
		System.out.println("Retrieving Result by ResultCriteria");
		dao.ResultCriteria ldaoResultCriteria = new dao.ResultCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoResultCriteria.ResultId.eq();
		System.out.println(ldaoResultCriteria.uniqueResult());
		
		System.out.println("Retrieving Grade by GradeCriteria");
		dao.GradeCriteria ldaoGradeCriteria = new dao.GradeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoGradeCriteria.GradeId.eq();
		System.out.println(ldaoGradeCriteria.uniqueGrade());
		
		System.out.println("Retrieving Location by LocationCriteria");
		dao.LocationCriteria ldaoLocationCriteria = new dao.LocationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoLocationCriteria.LocationId.eq();
		System.out.println(ldaoLocationCriteria.uniqueLocation());
		
		System.out.println("Retrieving Notification by NotificationCriteria");
		dao.NotificationCriteria ldaoNotificationCriteria = new dao.NotificationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoNotificationCriteria.NotificationId.eq();
		System.out.println(ldaoNotificationCriteria.uniqueNotification());
		
		System.out.println("Retrieving Club by ClubCriteria");
		dao.ClubCriteria ldaoClubCriteria = new dao.ClubCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoClubCriteria.ClubId.eq();
		System.out.println(ldaoClubCriteria.uniqueClub());
		
		System.out.println("Retrieving Team by TeamCriteria");
		dao.TeamCriteria ldaoTeamCriteria = new dao.TeamCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoTeamCriteria.TeamId.eq();
		System.out.println(ldaoTeamCriteria.uniqueTeam());
		
		System.out.println("Retrieving Type by TypeCriteria");
		dao.TypeCriteria ldaoTypeCriteria = new dao.TypeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoTypeCriteria.TypeId.eq();
		System.out.println(ldaoTypeCriteria.uniqueType());
		
		System.out.println("Retrieving State by StateCriteria");
		dao.StateCriteria ldaoStateCriteria = new dao.StateCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoStateCriteria.StateId.eq();
		System.out.println(ldaoStateCriteria.uniqueState());
		
		System.out.println("Retrieving Role by RoleCriteria");
		dao.RoleCriteria ldaoRoleCriteria = new dao.RoleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldaoRoleCriteria.RoleId.eq();
		System.out.println(ldaoRoleCriteria.uniqueRole());
		
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
