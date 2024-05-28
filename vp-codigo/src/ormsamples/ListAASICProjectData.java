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
		eaproject.dao.User[] eaprojectdaoUsers = eaproject.dao.UserDAO.listUserByQuery(null, null);
		int length = Math.min(eaprojectdaoUsers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoUsers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Trial...");
		eaproject.dao.Trial[] eaprojectdaoTrials = eaproject.dao.TrialDAO.listTrialByQuery(null, null);
		length = Math.min(eaprojectdaoTrials.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoTrials[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Competition...");
		eaproject.dao.Competition[] eaprojectdaoCompetitions = eaproject.dao.CompetitionDAO.listCompetitionByQuery(null, null);
		length = Math.min(eaprojectdaoCompetitions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoCompetitions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Result...");
		eaproject.dao.Result[] eaprojectdaoResults = eaproject.dao.ResultDAO.listResultByQuery(null, null);
		length = Math.min(eaprojectdaoResults.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoResults[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Grade...");
		eaproject.dao.Grade[] eaprojectdaoGrades = eaproject.dao.GradeDAO.listGradeByQuery(null, null);
		length = Math.min(eaprojectdaoGrades.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoGrades[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Location...");
		eaproject.dao.Location[] eaprojectdaoLocations = eaproject.dao.LocationDAO.listLocationByQuery(null, null);
		length = Math.min(eaprojectdaoLocations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoLocations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Notification...");
		eaproject.dao.Notification[] eaprojectdaoNotifications = eaproject.dao.NotificationDAO.listNotificationByQuery(null, null);
		length = Math.min(eaprojectdaoNotifications.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoNotifications[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Club...");
		eaproject.dao.Club[] eaprojectdaoClubs = eaproject.dao.ClubDAO.listClubByQuery(null, null);
		length = Math.min(eaprojectdaoClubs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoClubs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Team...");
		eaproject.dao.Team[] eaprojectdaoTeams = eaproject.dao.TeamDAO.listTeamByQuery(null, null);
		length = Math.min(eaprojectdaoTeams.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoTeams[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Type...");
		eaproject.dao.Type[] eaprojectdaoTypes = eaproject.dao.TypeDAO.listTypeByQuery(null, null);
		length = Math.min(eaprojectdaoTypes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoTypes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing State...");
		eaproject.dao.State[] eaprojectdaoStates = eaproject.dao.StateDAO.listStateByQuery(null, null);
		length = Math.min(eaprojectdaoStates.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoStates[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Role...");
		eaproject.dao.Role[] eaprojectdaoRoles = eaproject.dao.RoleDAO.listRoleByQuery(null, null);
		length = Math.min(eaprojectdaoRoles.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoRoles[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing User by Criteria...");
		eaproject.dao.UserCriteria leaprojectdaoUserCriteria = new eaproject.dao.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoUserCriteria.UserId.eq();
		leaprojectdaoUserCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.User[] eaprojectdaoUsers = leaprojectdaoUserCriteria.listUser();
		int length =eaprojectdaoUsers== null ? 0 : Math.min(eaprojectdaoUsers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoUsers[i]);
		}
		System.out.println(length + " User record(s) retrieved."); 
		
		System.out.println("Listing Trial by Criteria...");
		eaproject.dao.TrialCriteria leaprojectdaoTrialCriteria = new eaproject.dao.TrialCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoTrialCriteria.TrialId.eq();
		leaprojectdaoTrialCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Trial[] eaprojectdaoTrials = leaprojectdaoTrialCriteria.listTrial();
		length =eaprojectdaoTrials== null ? 0 : Math.min(eaprojectdaoTrials.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoTrials[i]);
		}
		System.out.println(length + " Trial record(s) retrieved."); 
		
		System.out.println("Listing Competition by Criteria...");
		eaproject.dao.CompetitionCriteria leaprojectdaoCompetitionCriteria = new eaproject.dao.CompetitionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoCompetitionCriteria.CompetitionId.eq();
		leaprojectdaoCompetitionCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Competition[] eaprojectdaoCompetitions = leaprojectdaoCompetitionCriteria.listCompetition();
		length =eaprojectdaoCompetitions== null ? 0 : Math.min(eaprojectdaoCompetitions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoCompetitions[i]);
		}
		System.out.println(length + " Competition record(s) retrieved."); 
		
		System.out.println("Listing Result by Criteria...");
		eaproject.dao.ResultCriteria leaprojectdaoResultCriteria = new eaproject.dao.ResultCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoResultCriteria.ResultId.eq();
		leaprojectdaoResultCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Result[] eaprojectdaoResults = leaprojectdaoResultCriteria.listResult();
		length =eaprojectdaoResults== null ? 0 : Math.min(eaprojectdaoResults.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoResults[i]);
		}
		System.out.println(length + " Result record(s) retrieved."); 
		
		System.out.println("Listing Grade by Criteria...");
		eaproject.dao.GradeCriteria leaprojectdaoGradeCriteria = new eaproject.dao.GradeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoGradeCriteria.GradeId.eq();
		leaprojectdaoGradeCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Grade[] eaprojectdaoGrades = leaprojectdaoGradeCriteria.listGrade();
		length =eaprojectdaoGrades== null ? 0 : Math.min(eaprojectdaoGrades.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoGrades[i]);
		}
		System.out.println(length + " Grade record(s) retrieved."); 
		
		System.out.println("Listing Location by Criteria...");
		eaproject.dao.LocationCriteria leaprojectdaoLocationCriteria = new eaproject.dao.LocationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoLocationCriteria.LocationId.eq();
		leaprojectdaoLocationCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Location[] eaprojectdaoLocations = leaprojectdaoLocationCriteria.listLocation();
		length =eaprojectdaoLocations== null ? 0 : Math.min(eaprojectdaoLocations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoLocations[i]);
		}
		System.out.println(length + " Location record(s) retrieved."); 
		
		System.out.println("Listing Notification by Criteria...");
		eaproject.dao.NotificationCriteria leaprojectdaoNotificationCriteria = new eaproject.dao.NotificationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoNotificationCriteria.NotificationId.eq();
		leaprojectdaoNotificationCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Notification[] eaprojectdaoNotifications = leaprojectdaoNotificationCriteria.listNotification();
		length =eaprojectdaoNotifications== null ? 0 : Math.min(eaprojectdaoNotifications.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoNotifications[i]);
		}
		System.out.println(length + " Notification record(s) retrieved."); 
		
		System.out.println("Listing Club by Criteria...");
		eaproject.dao.ClubCriteria leaprojectdaoClubCriteria = new eaproject.dao.ClubCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoClubCriteria.ClubId.eq();
		leaprojectdaoClubCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Club[] eaprojectdaoClubs = leaprojectdaoClubCriteria.listClub();
		length =eaprojectdaoClubs== null ? 0 : Math.min(eaprojectdaoClubs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoClubs[i]);
		}
		System.out.println(length + " Club record(s) retrieved."); 
		
		System.out.println("Listing Team by Criteria...");
		eaproject.dao.TeamCriteria leaprojectdaoTeamCriteria = new eaproject.dao.TeamCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoTeamCriteria.TeamId.eq();
		leaprojectdaoTeamCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Team[] eaprojectdaoTeams = leaprojectdaoTeamCriteria.listTeam();
		length =eaprojectdaoTeams== null ? 0 : Math.min(eaprojectdaoTeams.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoTeams[i]);
		}
		System.out.println(length + " Team record(s) retrieved."); 
		
		System.out.println("Listing Type by Criteria...");
		eaproject.dao.TypeCriteria leaprojectdaoTypeCriteria = new eaproject.dao.TypeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoTypeCriteria.TypeId.eq();
		leaprojectdaoTypeCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Type[] eaprojectdaoTypes = leaprojectdaoTypeCriteria.listType();
		length =eaprojectdaoTypes== null ? 0 : Math.min(eaprojectdaoTypes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoTypes[i]);
		}
		System.out.println(length + " Type record(s) retrieved."); 
		
		System.out.println("Listing State by Criteria...");
		eaproject.dao.StateCriteria leaprojectdaoStateCriteria = new eaproject.dao.StateCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoStateCriteria.StateId.eq();
		leaprojectdaoStateCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.State[] eaprojectdaoStates = leaprojectdaoStateCriteria.listState();
		length =eaprojectdaoStates== null ? 0 : Math.min(eaprojectdaoStates.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoStates[i]);
		}
		System.out.println(length + " State record(s) retrieved."); 
		
		System.out.println("Listing Role by Criteria...");
		eaproject.dao.RoleCriteria leaprojectdaoRoleCriteria = new eaproject.dao.RoleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoRoleCriteria.RoleId.eq();
		leaprojectdaoRoleCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.Role[] eaprojectdaoRoles = leaprojectdaoRoleCriteria.listRole();
		length =eaprojectdaoRoles== null ? 0 : Math.min(eaprojectdaoRoles.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoRoles[i]);
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
