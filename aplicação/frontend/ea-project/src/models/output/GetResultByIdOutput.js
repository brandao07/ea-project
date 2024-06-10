import BaseOutput from "./BaseOutput";

export default class GetResultByIdOutput extends BaseOutput {
  constructor(id = 0, position = 0, time = new Date(), observations = '', penaltyTime = new Date(), creationDate = new Date(), feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.position = position;
    this.time = time;
    this.observations = observations;
    this.penaltyTime = penaltyTime;
    this.creationDate = creationDate;
  }
}