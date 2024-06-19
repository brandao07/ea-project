import BaseOutput from "./BaseOutput";

export default class GetUsersByTeamIdOutput extends BaseOutput {
  constructor(usersList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.usersList = Array.isArray(usersList) ? usersList.map(item => new GetUsersByTeamIdOutput.UserProperties(item)) : [];
  }

  static UserProperties = class {
    constructor({id = 0, name = '', isActive = false, creationDate = new Date()}) {
      this.id = id;
      this.name = name;
      this.isActive = isActive;
      this.creationDate = creationDate;
    }
  };
}


