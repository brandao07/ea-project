/**
 * Licensee: User-PC(University of Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListAASICProjectData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing user...");
		eaproject.dao.user[] eaprojectdaousers = eaproject.dao.userDAO.listUserByQuery(null, null);
		int length = Math.min(eaprojectdaousers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaousers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing trial...");
		eaproject.dao.trial[] eaprojectdaotrials = eaproject.dao.trialDAO.listTrialByQuery(null, null);
		length = Math.min(eaprojectdaotrials.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaotrials[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing competition...");
		eaproject.dao.competition[] eaprojectdaocompetitions = eaproject.dao.competitionDAO.listCompetitionByQuery(null, null);
		length = Math.min(eaprojectdaocompetitions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaocompetitions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing result...");
		eaproject.dao.result[] eaprojectdaoresults = eaproject.dao.resultDAO.listResultByQuery(null, null);
		length = Math.min(eaprojectdaoresults.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoresults[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing grade...");
		eaproject.dao.grade[] eaprojectdaogrades = eaproject.dao.gradeDAO.listGradeByQuery(null, null);
		length = Math.min(eaprojectdaogrades.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaogrades[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing location...");
		eaproject.dao.location[] eaprojectdaolocations = eaproject.dao.locationDAO.listLocationByQuery(null, null);
		length = Math.min(eaprojectdaolocations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaolocations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing notification...");
		eaproject.dao.notification[] eaprojectdaonotifications = eaproject.dao.notificationDAO.listNotificationByQuery(null, null);
		length = Math.min(eaprojectdaonotifications.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaonotifications[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing club...");
		eaproject.dao.club[] eaprojectdaoclubs = eaproject.dao.clubDAO.listClubByQuery(null, null);
		length = Math.min(eaprojectdaoclubs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoclubs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing team...");
		eaproject.dao.team[] eaprojectdaoteams = eaproject.dao.teamDAO.listTeamByQuery(null, null);
		length = Math.min(eaprojectdaoteams.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoteams[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing type...");
		eaproject.dao.type[] eaprojectdaotypes = eaproject.dao.typeDAO.listTypeByQuery(null, null);
		length = Math.min(eaprojectdaotypes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaotypes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing state...");
		eaproject.dao.state[] eaprojectdaostates = eaproject.dao.stateDAO.listStateByQuery(null, null);
		length = Math.min(eaprojectdaostates.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaostates[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing role...");
		eaproject.dao.role[] eaprojectdaoroles = eaproject.dao.roleDAO.listRoleByQuery(null, null);
		length = Math.min(eaprojectdaoroles.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eaprojectdaoroles[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing user by Criteria...");
		eaproject.dao.userCriteria leaprojectdaouserCriteria = new eaproject.dao.userCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaouserCriteria.UserId.eq();
		leaprojectdaouserCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.user[] eaprojectdaousers = leaprojectdaouserCriteria.listUser();
		int length =eaprojectdaousers== null ? 0 : Math.min(eaprojectdaousers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaousers[i]);
		}
		System.out.println(length + " user record(s) retrieved."); 
		
		System.out.println("Listing trial by Criteria...");
		eaproject.dao.trialCriteria leaprojectdaotrialCriteria = new eaproject.dao.trialCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaotrialCriteria.TrialId.eq();
		leaprojectdaotrialCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.trial[] eaprojectdaotrials = leaprojectdaotrialCriteria.listTrial();
		length =eaprojectdaotrials== null ? 0 : Math.min(eaprojectdaotrials.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaotrials[i]);
		}
		System.out.println(length + " trial record(s) retrieved."); 
		
		System.out.println("Listing competition by Criteria...");
		eaproject.dao.competitionCriteria leaprojectdaocompetitionCriteria = new eaproject.dao.competitionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaocompetitionCriteria.CompetitionId.eq();
		leaprojectdaocompetitionCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.competition[] eaprojectdaocompetitions = leaprojectdaocompetitionCriteria.listCompetition();
		length =eaprojectdaocompetitions== null ? 0 : Math.min(eaprojectdaocompetitions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaocompetitions[i]);
		}
		System.out.println(length + " competition record(s) retrieved."); 
		
		System.out.println("Listing result by Criteria...");
		eaproject.dao.resultCriteria leaprojectdaoresultCriteria = new eaproject.dao.resultCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoresultCriteria.ResultId.eq();
		leaprojectdaoresultCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.result[] eaprojectdaoresults = leaprojectdaoresultCriteria.listResult();
		length =eaprojectdaoresults== null ? 0 : Math.min(eaprojectdaoresults.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoresults[i]);
		}
		System.out.println(length + " result record(s) retrieved."); 
		
		System.out.println("Listing grade by Criteria...");
		eaproject.dao.gradeCriteria leaprojectdaogradeCriteria = new eaproject.dao.gradeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaogradeCriteria.GradeId.eq();
		leaprojectdaogradeCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.grade[] eaprojectdaogrades = leaprojectdaogradeCriteria.listGrade();
		length =eaprojectdaogrades== null ? 0 : Math.min(eaprojectdaogrades.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaogrades[i]);
		}
		System.out.println(length + " grade record(s) retrieved."); 
		
		System.out.println("Listing location by Criteria...");
		eaproject.dao.locationCriteria leaprojectdaolocationCriteria = new eaproject.dao.locationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaolocationCriteria.LocationId.eq();
		leaprojectdaolocationCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.location[] eaprojectdaolocations = leaprojectdaolocationCriteria.listLocation();
		length =eaprojectdaolocations== null ? 0 : Math.min(eaprojectdaolocations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaolocations[i]);
		}
		System.out.println(length + " location record(s) retrieved."); 
		
		System.out.println("Listing notification by Criteria...");
		eaproject.dao.notificationCriteria leaprojectdaonotificationCriteria = new eaproject.dao.notificationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaonotificationCriteria.NotificationId.eq();
		leaprojectdaonotificationCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.notification[] eaprojectdaonotifications = leaprojectdaonotificationCriteria.listNotification();
		length =eaprojectdaonotifications== null ? 0 : Math.min(eaprojectdaonotifications.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaonotifications[i]);
		}
		System.out.println(length + " notification record(s) retrieved."); 
		
		System.out.println("Listing club by Criteria...");
		eaproject.dao.clubCriteria leaprojectdaoclubCriteria = new eaproject.dao.clubCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoclubCriteria.ClubId.eq();
		leaprojectdaoclubCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.club[] eaprojectdaoclubs = leaprojectdaoclubCriteria.listClub();
		length =eaprojectdaoclubs== null ? 0 : Math.min(eaprojectdaoclubs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoclubs[i]);
		}
		System.out.println(length + " club record(s) retrieved."); 
		
		System.out.println("Listing team by Criteria...");
		eaproject.dao.teamCriteria leaprojectdaoteamCriteria = new eaproject.dao.teamCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoteamCriteria.TeamId.eq();
		leaprojectdaoteamCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.team[] eaprojectdaoteams = leaprojectdaoteamCriteria.listTeam();
		length =eaprojectdaoteams== null ? 0 : Math.min(eaprojectdaoteams.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoteams[i]);
		}
		System.out.println(length + " team record(s) retrieved."); 
		
		System.out.println("Listing type by Criteria...");
		eaproject.dao.typeCriteria leaprojectdaotypeCriteria = new eaproject.dao.typeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaotypeCriteria.TypeId.eq();
		leaprojectdaotypeCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.type[] eaprojectdaotypes = leaprojectdaotypeCriteria.listType();
		length =eaprojectdaotypes== null ? 0 : Math.min(eaprojectdaotypes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaotypes[i]);
		}
		System.out.println(length + " type record(s) retrieved."); 
		
		System.out.println("Listing state by Criteria...");
		eaproject.dao.stateCriteria leaprojectdaostateCriteria = new eaproject.dao.stateCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaostateCriteria.StateId.eq();
		leaprojectdaostateCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.state[] eaprojectdaostates = leaprojectdaostateCriteria.listState();
		length =eaprojectdaostates== null ? 0 : Math.min(eaprojectdaostates.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaostates[i]);
		}
		System.out.println(length + " state record(s) retrieved."); 
		
		System.out.println("Listing role by Criteria...");
		eaproject.dao.roleCriteria leaprojectdaoroleCriteria = new eaproject.dao.roleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leaprojectdaoroleCriteria.RoleId.eq();
		leaprojectdaoroleCriteria.setMaxResults(ROW_COUNT);
		eaproject.dao.role[] eaprojectdaoroles = leaprojectdaoroleCriteria.listRole();
		length =eaprojectdaoroles== null ? 0 : Math.min(eaprojectdaoroles.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eaprojectdaoroles[i]);
		}
		System.out.println(length + " role record(s) retrieved."); 
		
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
