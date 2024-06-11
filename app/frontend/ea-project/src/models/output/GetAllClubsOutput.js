import BaseOutput from "./BaseOutput";

export default class GetAllClubsOutput extends BaseOutput {
  constructor(clubList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.clubList = clubList.map(item => new GetAllClubsOutput.ClubProperties(item));
  }

  static ClubProperties = class {
    constructor({id = 0, name = '', isActive = false, creationDate = new Date()}) {
      this.id = id;
      this.name = name;
      this.isActive = isActive;
      this.creationDate = creationDate;
    }
  };
}