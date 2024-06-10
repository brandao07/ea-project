import BaseOutput from "./BaseOutput";

export default class GetTypeByIdOutput extends BaseOutput {
  constructor(id = 0, name = '', numberOfPersons = 0, creationDate = new Date(), feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.numberOfPersons = numberOfPersons;
    this.creationDate = creationDate;
  }
}