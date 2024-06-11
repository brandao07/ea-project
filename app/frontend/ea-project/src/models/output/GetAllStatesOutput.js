import BaseOutput from "./BaseOutput";

export default class GetAllStatesOutput extends BaseOutput {
  constructor(stateList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.stateList = stateList.map(item => new GetAllStatesOutput.StateProperties(item));
  }

  static StateProperties = class {
    constructor(id = 0, name = '', creationDate = new Date()) {
      this.id = id;
      this.name = name;
      this.creationDate = creationDate;
    }
  };
}