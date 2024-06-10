import BaseOutput from "./BaseOutput";

export default class GetTeamByIdOutput extends BaseOutput {
  constructor(id = 0, name = '', isActive = false, creationDate = new Date(), club = {}, users = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.isActive = isActive;
    this.creationDate = creationDate;
    this.club = new GetTeamByIdOutput.ClubProperties(club);
    this.users = users.map(item => new GetTeamByIdOutput.UserProperties(item));
  }

  static ClubProperties = class {
    constructor(id = 0, name = '') {
      this.id = id;
      this.name = name;
    }
  };

  static UserProperties = class {
    constructor() {
    }
  };
}