import BaseOutput from "./BaseOutput";

export default class GetStateByIdOutput extends BaseOutput {
  constructor(id = 0, name = '', creationDate = new Date(), feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.creationDate = creationDate;
  }
}