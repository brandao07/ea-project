import BaseOutput from "./BaseOutput";

export default class GetRoleByIdOutput extends BaseOutput {
  constructor(id = 0, name = '', description = '', creationDate = new Date(), feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.description = description;
    this.creationDate = creationDate;
  }
}