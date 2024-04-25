/**
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListAASICProjectData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing User...");
		dao.User[] daoUsers = dao.User.listUserByQuery(null, null);
		int length = Math.min(daoUsers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoUsers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Trial...");
		dao.Trial[] daoTrials = dao.Trial.listTrialByQuery(null, null);
		length = Math.min(daoTrials.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoTrials[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Competition...");
		dao.Competition[] daoCompetitions = dao.Competition.listCompetitionByQuery(null, null);
		length = Math.min(daoCompetitions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoCompetitions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Result...");
		dao.Result[] daoResults = dao.Result.listResultByQuery(null, null);
		length = Math.min(daoResults.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoResults[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Grade...");
		dao.Grade[] daoGrades = dao.Grade.listGradeByQuery(null, null);
		length = Math.min(daoGrades.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoGrades[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Location...");
		dao.Location[] daoLocations = dao.Location.listLocationByQuery(null, null);
		length = Math.min(daoLocations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoLocations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Notification...");
		dao.Notification[] daoNotifications = dao.Notification.listNotificationByQuery(null, null);
		length = Math.min(daoNotifications.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoNotifications[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Club...");
		dao.Club[] daoClubs = dao.Club.listClubByQuery(null, null);
		length = Math.min(daoClubs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoClubs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Team...");
		dao.Team[] daoTeams = dao.Team.listTeamByQuery(null, null);
		length = Math.min(daoTeams.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoTeams[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Type...");
		dao.Type[] daoTypes = dao.Type.listTypeByQuery(null, null);
		length = Math.min(daoTypes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoTypes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing State...");
		dao.State[] daoStates = dao.State.listStateByQuery(null, null);
		length = Math.min(daoStates.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoStates[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Role...");
		dao.Role[] daoRoles = dao.Role.listRoleByQuery(null, null);
		length = Math.min(daoRoles.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(daoRoles[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing User by Criteria...");
		dao.UserCriteria ldaoUserCriteria = new dao.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoUserCriteria.UserId.eq();
		ldaoUserCriteria.setMaxResults(ROW_COUNT);
		dao.User[] daoUsers = ldaoUserCriteria.listUser();
		int length =daoUsers== null ? 0 : Math.min(daoUsers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoUsers[i]);
		}
		System.out.println(length + " User record(s) retrieved."); 
		
		System.out.println("Listing Trial by Criteria...");
		dao.TrialCriteria ldaoTrialCriteria = new dao.TrialCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoTrialCriteria.TrialId.eq();
		ldaoTrialCriteria.setMaxResults(ROW_COUNT);
		dao.Trial[] daoTrials = ldaoTrialCriteria.listTrial();
		length =daoTrials== null ? 0 : Math.min(daoTrials.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoTrials[i]);
		}
		System.out.println(length + " Trial record(s) retrieved."); 
		
		System.out.println("Listing Competition by Criteria...");
		dao.CompetitionCriteria ldaoCompetitionCriteria = new dao.CompetitionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoCompetitionCriteria.CompetitionId.eq();
		ldaoCompetitionCriteria.setMaxResults(ROW_COUNT);
		dao.Competition[] daoCompetitions = ldaoCompetitionCriteria.listCompetition();
		length =daoCompetitions== null ? 0 : Math.min(daoCompetitions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoCompetitions[i]);
		}
		System.out.println(length + " Competition record(s) retrieved."); 
		
		System.out.println("Listing Result by Criteria...");
		dao.ResultCriteria ldaoResultCriteria = new dao.ResultCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoResultCriteria.ResultId.eq();
		ldaoResultCriteria.setMaxResults(ROW_COUNT);
		dao.Result[] daoResults = ldaoResultCriteria.listResult();
		length =daoResults== null ? 0 : Math.min(daoResults.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoResults[i]);
		}
		System.out.println(length + " Result record(s) retrieved."); 
		
		System.out.println("Listing Grade by Criteria...");
		dao.GradeCriteria ldaoGradeCriteria = new dao.GradeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoGradeCriteria.GradeId.eq();
		ldaoGradeCriteria.setMaxResults(ROW_COUNT);
		dao.Grade[] daoGrades = ldaoGradeCriteria.listGrade();
		length =daoGrades== null ? 0 : Math.min(daoGrades.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoGrades[i]);
		}
		System.out.println(length + " Grade record(s) retrieved."); 
		
		System.out.println("Listing Location by Criteria...");
		dao.LocationCriteria ldaoLocationCriteria = new dao.LocationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoLocationCriteria.LocationId.eq();
		ldaoLocationCriteria.setMaxResults(ROW_COUNT);
		dao.Location[] daoLocations = ldaoLocationCriteria.listLocation();
		length =daoLocations== null ? 0 : Math.min(daoLocations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoLocations[i]);
		}
		System.out.println(length + " Location record(s) retrieved."); 
		
		System.out.println("Listing Notification by Criteria...");
		dao.NotificationCriteria ldaoNotificationCriteria = new dao.NotificationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoNotificationCriteria.NotificationId.eq();
		ldaoNotificationCriteria.setMaxResults(ROW_COUNT);
		dao.Notification[] daoNotifications = ldaoNotificationCriteria.listNotification();
		length =daoNotifications== null ? 0 : Math.min(daoNotifications.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoNotifications[i]);
		}
		System.out.println(length + " Notification record(s) retrieved."); 
		
		System.out.println("Listing Club by Criteria...");
		dao.ClubCriteria ldaoClubCriteria = new dao.ClubCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoClubCriteria.ClubId.eq();
		ldaoClubCriteria.setMaxResults(ROW_COUNT);
		dao.Club[] daoClubs = ldaoClubCriteria.listClub();
		length =daoClubs== null ? 0 : Math.min(daoClubs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoClubs[i]);
		}
		System.out.println(length + " Club record(s) retrieved."); 
		
		System.out.println("Listing Team by Criteria...");
		dao.TeamCriteria ldaoTeamCriteria = new dao.TeamCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoTeamCriteria.TeamId.eq();
		ldaoTeamCriteria.setMaxResults(ROW_COUNT);
		dao.Team[] daoTeams = ldaoTeamCriteria.listTeam();
		length =daoTeams== null ? 0 : Math.min(daoTeams.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoTeams[i]);
		}
		System.out.println(length + " Team record(s) retrieved."); 
		
		System.out.println("Listing Type by Criteria...");
		dao.TypeCriteria ldaoTypeCriteria = new dao.TypeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoTypeCriteria.TypeId.eq();
		ldaoTypeCriteria.setMaxResults(ROW_COUNT);
		dao.Type[] daoTypes = ldaoTypeCriteria.listType();
		length =daoTypes== null ? 0 : Math.min(daoTypes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoTypes[i]);
		}
		System.out.println(length + " Type record(s) retrieved."); 
		
		System.out.println("Listing State by Criteria...");
		dao.StateCriteria ldaoStateCriteria = new dao.StateCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoStateCriteria.StateId.eq();
		ldaoStateCriteria.setMaxResults(ROW_COUNT);
		dao.State[] daoStates = ldaoStateCriteria.listState();
		length =daoStates== null ? 0 : Math.min(daoStates.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoStates[i]);
		}
		System.out.println(length + " State record(s) retrieved."); 
		
		System.out.println("Listing Role by Criteria...");
		dao.RoleCriteria ldaoRoleCriteria = new dao.RoleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldaoRoleCriteria.RoleId.eq();
		ldaoRoleCriteria.setMaxResults(ROW_COUNT);
		dao.Role[] daoRoles = ldaoRoleCriteria.listRole();
		length =daoRoles== null ? 0 : Math.min(daoRoles.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(daoRoles[i]);
		}
		System.out.println(length + " Role record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListAASICProjectData listAASICProjectData = new ListAASICProjectData();
			try {
				listAASICProjectData.listTestData();
				//listAASICProjectData.listByCriteria();
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
