import BaseOutput from "./BaseOutput";

export default class GetAllResultsOutput extends BaseOutput {
  constructor(getallresultList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.getallresultList = getallresultList.map(
      (getallresult) =>
        new GetAllResultsOutput.GetAllResultProperties(
          getallresult.id,
          getallresult.position,
          getallresult.time,
          getallresult.observations,
          getallresult.penaltyTime,
          getallresult.creationDate
        )
    );
  }

  static GetAllResultProperties = class {
    constructor(id, position, time, observations, penaltyTime, creationDate) {
      this.id = id;
      this.position = position;
      this.time = time;
      this.observations = observations;
      this.penaltyTime = penaltyTime;
      this.creationDate = creationDate;
    }
  };
}
