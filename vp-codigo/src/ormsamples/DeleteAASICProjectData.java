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
			eaproject.dao.User leaprojectdaoUser = eaproject.dao.UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.UserDAO.delete(leaprojectdaoUser);
			eaproject.dao.Trial leaprojectdaoTrial = eaproject.dao.TrialDAO.loadTrialByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.TrialDAO.delete(leaprojectdaoTrial);
			eaproject.dao.Competition leaprojectdaoCompetition = eaproject.dao.CompetitionDAO.loadCompetitionByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.CompetitionDAO.delete(leaprojectdaoCompetition);
			eaproject.dao.Result leaprojectdaoResult = eaproject.dao.ResultDAO.loadResultByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.ResultDAO.delete(leaprojectdaoResult);
			eaproject.dao.Grade leaprojectdaoGrade = eaproject.dao.GradeDAO.loadGradeByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.GradeDAO.delete(leaprojectdaoGrade);
			eaproject.dao.Location leaprojectdaoLocation = eaproject.dao.LocationDAO.loadLocationByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.LocationDAO.delete(leaprojectdaoLocation);
			eaproject.dao.Notification leaprojectdaoNotification = eaproject.dao.NotificationDAO.loadNotificationByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.NotificationDAO.delete(leaprojectdaoNotification);
			eaproject.dao.Club leaprojectdaoClub = eaproject.dao.ClubDAO.loadClubByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.ClubDAO.delete(leaprojectdaoClub);
			eaproject.dao.Team leaprojectdaoTeam = eaproject.dao.TeamDAO.loadTeamByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.TeamDAO.delete(leaprojectdaoTeam);
			eaproject.dao.Type leaprojectdaoType = eaproject.dao.TypeDAO.loadTypeByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.TypeDAO.delete(leaprojectdaoType);
			eaproject.dao.State leaprojectdaoState = eaproject.dao.StateDAO.loadStateByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.StateDAO.delete(leaprojectdaoState);
			eaproject.dao.Role leaprojectdaoRole = eaproject.dao.RoleDAO.loadRoleByQuery(null, null);
			// Delete the persistent object
			eaproject.dao.RoleDAO.delete(leaprojectdaoRole);
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
