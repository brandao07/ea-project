import BaseOutput from "./BaseOutput";

export default class GetTeamsByClubIdOutput extends BaseOutput {
  constructor(teamList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.teamList = Array.isArray(teamList) ? teamList.map(item => new GetTeamsByClubIdOutput.TeamProperties(item)) : [];
  }

  static TeamProperties = class {
    constructor({id = 0, clubid = 0, name = '', isActive = false, creationDate = new Date()}) {
      this.id = id;
      this.clubid = clubid;
      this.name = name;
      this.isActive = isActive;
      this.creationDate = creationDate;
    }
  };
}