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
			dao.User ldaoUser = dao.User.loadUserByQuery(null, null);
			ldaoUser.delete();
			dao.Trial ldaoTrial = dao.Trial.loadTrialByQuery(null, null);
			ldaoTrial.delete();
			dao.Competition ldaoCompetition = dao.Competition.loadCompetitionByQuery(null, null);
			ldaoCompetition.delete();
			dao.Result ldaoResult = dao.Result.loadResultByQuery(null, null);
			ldaoResult.delete();
			dao.Grade ldaoGrade = dao.Grade.loadGradeByQuery(null, null);
			ldaoGrade.delete();
			dao.Location ldaoLocation = dao.Location.loadLocationByQuery(null, null);
			ldaoLocation.delete();
			dao.Notification ldaoNotification = dao.Notification.loadNotificationByQuery(null, null);
			ldaoNotification.delete();
			dao.Club ldaoClub = dao.Club.loadClubByQuery(null, null);
			ldaoClub.delete();
			dao.Team ldaoTeam = dao.Team.loadTeamByQuery(null, null);
			ldaoTeam.delete();
			dao.Type ldaoType = dao.Type.loadTypeByQuery(null, null);
			ldaoType.delete();
			dao.State ldaoState = dao.State.loadStateByQuery(null, null);
			ldaoState.delete();
			dao.Role ldaoRole = dao.Role.loadRoleByQuery(null, null);
			ldaoRole.delete();
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
