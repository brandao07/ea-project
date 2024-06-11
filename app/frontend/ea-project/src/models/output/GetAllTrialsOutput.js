import BaseOutput from "./BaseOutput";

export default class GetAllTrialsOutput extends BaseOutput {
  constructor(trials = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.trials = trials.map(item => new GetAllTrialsOutput.TrialProperties(item));
  }

  static TrialProperties = class {
    constructor({id = 0, name = '', startDate = new Date(), distance = 0.0, distanceUnit = '', isActive = false, creationDate = new Date()}) {
      this.id = id;
      this.name = name;
      this.startDate = startDate;
      this.distance = distance;
      this.distanceUnit = distanceUnit;
      this.isActive = isActive;
      this.creationDate = creationDate;
    }
  };
}