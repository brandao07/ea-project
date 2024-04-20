/**
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteAASICProjectData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = orm.AASICProjectPersistentManager.instance().getSession().beginTransaction();
		try {
			eaproject.dao.user leaprojectdaouser = eaproject.dao.userDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.userDAO.delete(leaprojectdaouser);
			eaproject.dao.trial leaprojectdaotrial = eaproject.dao.trialDAO.loadTrialByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.trialDAO.delete(leaprojectdaotrial);
			eaproject.dao.competition leaprojectdaocompetition = eaproject.dao.competitionDAO.loadCompetitionByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.competitionDAO.delete(leaprojectdaocompetition);
			eaproject.dao.result leaprojectdaoresult = eaproject.dao.resultDAO.loadResultByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.resultDAO.delete(leaprojectdaoresult);
			eaproject.dao.grade leaprojectdaograde = eaproject.dao.gradeDAO.loadGradeByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.gradeDAO.delete(leaprojectdaograde);
			eaproject.dao.location leaprojectdaolocation = eaproject.dao.locationDAO.loadLocationByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.locationDAO.delete(leaprojectdaolocation);
			eaproject.dao.notification leaprojectdaonotification = eaproject.dao.notificationDAO.loadNotificationByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.notificationDAO.delete(leaprojectdaonotification);
			eaproject.dao.club leaprojectdaoclub = eaproject.dao.clubDAO.loadClubByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.clubDAO.delete(leaprojectdaoclub);
			eaproject.dao.team leaprojectdaoteam = eaproject.dao.teamDAO.loadTeamByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.teamDAO.delete(leaprojectdaoteam);
			eaproject.dao.type leaprojectdaotype = eaproject.dao.typeDAO.loadTypeByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.typeDAO.delete(leaprojectdaotype);
			eaproject.dao.state leaprojectdaostate = eaproject.dao.stateDAO.loadStateByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.stateDAO.delete(leaprojectdaostate);
			eaproject.dao.role leaprojectdaorole = eaproject.dao.roleDAO.loadRoleByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.roleDAO.delete(leaprojectdaorole);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteAASICProjectData deleteAASICProjectData = new DeleteAASICProjectData();
			try {
				deleteAASICProjectData.deleteTestData();
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
