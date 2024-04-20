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
			eaproject.dao.user leaprojectdaouser = eaproject.dao.userDAO.loadUserByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.userDAO.save(leaprojectdaouser);
			eaproject.dao.trial leaprojectdaotrial = eaproject.dao.trialDAO.loadTrialByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.trialDAO.save(leaprojectdaotrial);
			eaproject.dao.competition leaprojectdaocompetition = eaproject.dao.competitionDAO.loadCompetitionByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.competitionDAO.save(leaprojectdaocompetition);
			eaproject.dao.result leaprojectdaoresult = eaproject.dao.resultDAO.loadResultByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.resultDAO.save(leaprojectdaoresult);
			eaproject.dao.grade leaprojectdaograde = eaproject.dao.gradeDAO.loadGradeByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.gradeDAO.save(leaprojectdaograde);
			eaproject.dao.location leaprojectdaolocation = eaproject.dao.locationDAO.loadLocationByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.locationDAO.save(leaprojectdaolocation);
			eaproject.dao.notification leaprojectdaonotification = eaproject.dao.notificationDAO.loadNotificationByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.notificationDAO.save(leaprojectdaonotification);
			eaproject.dao.club leaprojectdaoclub = eaproject.dao.clubDAO.loadClubByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.clubDAO.save(leaprojectdaoclub);
			eaproject.dao.team leaprojectdaoteam = eaproject.dao.teamDAO.loadTeamByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.teamDAO.save(leaprojectdaoteam);
			eaproject.dao.type leaprojectdaotype = eaproject.dao.typeDAO.loadTypeByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.typeDAO.save(leaprojectdaotype);
			eaproject.dao.state leaprojectdaostate = eaproject.dao.stateDAO.loadStateByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.stateDAO.save(leaprojectdaostate);
			eaproject.dao.role leaprojectdaorole = eaproject.dao.roleDAO.loadRoleByQuery(null, null);
			// Update the properties of the persistent object
			eaproject.dao.roleDAO.save(leaprojectdaorole);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving user by userCriteria");
		eaproject.dao.userCriteria leaprojectdaouserCriteria = new eaproject.dao.userCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaouserCriteria.UserId.eq();
		System.out.println(leaprojectdaouserCriteria.uniqueUser());
		
		System.out.println("Retrieving trial by trialCriteria");
		eaproject.dao.trialCriteria leaprojectdaotrialCriteria = new eaproject.dao.trialCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaotrialCriteria.TrialId.eq();
		System.out.println(leaprojectdaotrialCriteria.uniqueTrial());
		
		System.out.println("Retrieving competition by competitionCriteria");
		eaproject.dao.competitionCriteria leaprojectdaocompetitionCriteria = new eaproject.dao.competitionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaocompetitionCriteria.CompetitionId.eq();
		System.out.println(leaprojectdaocompetitionCriteria.uniqueCompetition());
		
		System.out.println("Retrieving result by resultCriteria");
		eaproject.dao.resultCriteria leaprojectdaoresultCriteria = new eaproject.dao.resultCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoresultCriteria.ResultId.eq();
		System.out.println(leaprojectdaoresultCriteria.uniqueResult());
		
		System.out.println("Retrieving grade by gradeCriteria");
		eaproject.dao.gradeCriteria leaprojectdaogradeCriteria = new eaproject.dao.gradeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaogradeCriteria.GradeId.eq();
		System.out.println(leaprojectdaogradeCriteria.uniqueGrade());
		
		System.out.println("Retrieving location by locationCriteria");
		eaproject.dao.locationCriteria leaprojectdaolocationCriteria = new eaproject.dao.locationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaolocationCriteria.LocationId.eq();
		System.out.println(leaprojectdaolocationCriteria.uniqueLocation());
		
		System.out.println("Retrieving notification by notificationCriteria");
		eaproject.dao.notificationCriteria leaprojectdaonotificationCriteria = new eaproject.dao.notificationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaonotificationCriteria.NotificationId.eq();
		System.out.println(leaprojectdaonotificationCriteria.uniqueNotification());
		
		System.out.println("Retrieving club by clubCriteria");
		eaproject.dao.clubCriteria leaprojectdaoclubCriteria = new eaproject.dao.clubCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoclubCriteria.ClubId.eq();
		System.out.println(leaprojectdaoclubCriteria.uniqueClub());
		
		System.out.println("Retrieving team by teamCriteria");
		eaproject.dao.teamCriteria leaprojectdaoteamCriteria = new eaproject.dao.teamCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoteamCriteria.TeamId.eq();
		System.out.println(leaprojectdaoteamCriteria.uniqueTeam());
		
		System.out.println("Retrieving type by typeCriteria");
		eaproject.dao.typeCriteria leaprojectdaotypeCriteria = new eaproject.dao.typeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaotypeCriteria.TypeId.eq();
		System.out.println(leaprojectdaotypeCriteria.uniqueType());
		
		System.out.println("Retrieving state by stateCriteria");
		eaproject.dao.stateCriteria leaprojectdaostateCriteria = new eaproject.dao.stateCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaostateCriteria.StateId.eq();
		System.out.println(leaprojectdaostateCriteria.uniqueState());
		
		System.out.println("Retrieving role by roleCriteria");
		eaproject.dao.roleCriteria leaprojectdaoroleCriteria = new eaproject.dao.roleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leaprojectdaoroleCriteria.RoleId.eq();
		System.out.println(leaprojectdaoroleCriteria.uniqueRole());
		
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
