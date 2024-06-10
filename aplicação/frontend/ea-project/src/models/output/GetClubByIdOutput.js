import BaseOutput from "./BaseOutput";

export default class GetClubByIdOutput extends BaseOutput {
  constructor(id = 0, name = '', isActive = false, creationDate = new Date(), feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.isActive = isActive;
    this.creationDate = creationDate;
  }
}