import BaseOutput from "./BaseOutput";

export default class GetAllTypesOutput extends BaseOutput {
  constructor(types = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.types = types.map(item => new GetAllTypesOutput.TypeProperties(item));
  }

  static TypeProperties = class {
    constructor({id = 0, name = '', numberOfPersons = 0, creationDate = new Date()}) {
      this.id = id;
      this.name = name;
      this.numberOfPersons = numberOfPersons;
      this.creationDate = creationDate;
    }
  };
}