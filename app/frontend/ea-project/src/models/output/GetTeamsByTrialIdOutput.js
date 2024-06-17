import BaseOutput from "./BaseOutput";

export default class GetTeamsByTrialIdOutput extends BaseOutput {
  constructor(teamList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.teamList = Array.isArray(teamList) ? teamList.map(item => new GetTeamsByTrialIdOutput.TeamProperties(item)) : [];
  }

  static TeamProperties = class {
    constructor({id = 0, name = '', isActive = false, creationDate = new Date()}) {
      this.id = id;
      this.name = name;
      this.isActive = isActive;
      this.creationDate = creationDate;
    }
  };
}