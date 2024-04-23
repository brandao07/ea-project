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
			dao.User ldaoUser = dao.UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			dao.UserDAO.delete(ldaoUser);
			dao.Trial ldaoTrial = dao.TrialDAO.loadTrialByQuery(null, null);
			// Delete the persistent object
			dao.TrialDAO.delete(ldaoTrial);
			dao.Competition ldaoCompetition = dao.CompetitionDAO.loadCompetitionByQuery(null, null);
			// Delete the persistent object
			dao.CompetitionDAO.delete(ldaoCompetition);
			dao.Result ldaoResult = dao.ResultDAO.loadResultByQuery(null, null);
			// Delete the persistent object
			dao.ResultDAO.delete(ldaoResult);
			dao.Grade ldaoGrade = dao.GradeDAO.loadGradeByQuery(null, null);
			// Delete the persistent object
			dao.GradeDAO.delete(ldaoGrade);
			dao.Location ldaoLocation = dao.LocationDAO.loadLocationByQuery(null, null);
			// Delete the persistent object
			dao.LocationDAO.delete(ldaoLocation);
			dao.Notification ldaoNotification = dao.NotificationDAO.loadNotificationByQuery(null, null);
			// Delete the persistent object
			dao.NotificationDAO.delete(ldaoNotification);
			dao.Club ldaoClub = dao.ClubDAO.loadClubByQuery(null, null);
			// Delete the persistent object
			dao.ClubDAO.delete(ldaoClub);
			dao.Team ldaoTeam = dao.TeamDAO.loadTeamByQuery(null, null);
			// Delete the persistent object
			dao.TeamDAO.delete(ldaoTeam);
			dao.Type ldaoType = dao.TypeDAO.loadTypeByQuery(null, null);
			// Delete the persistent object
			dao.TypeDAO.delete(ldaoType);
			dao.State ldaoState = dao.StateDAO.loadStateByQuery(null, null);
			// Delete the persistent object
			dao.StateDAO.delete(ldaoState);
			dao.Role ldaoRole = dao.RoleDAO.loadRoleByQuery(null, null);
			// Delete the persistent object
			dao.RoleDAO.delete(ldaoRole);
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
