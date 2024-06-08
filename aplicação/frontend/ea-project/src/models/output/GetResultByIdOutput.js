import BaseOutput from "./BaseOutput";

export default class GetResultByIdOutput extends BaseOutput {
  constructor(
    creationDate = new Date(),
    penaltyTime = new Date(),
    observations = "",
    time = new Date(),
    position = 0,
    id = 0,
    feedbackMessages = []
  ) {
    super(feedbackMessages);
    this.id = id;
    this.position = position;
    this.time = time;
    this.observations = observations;
    this.penaltyTime = penaltyTime;
    this.creationDate = creationDate;
  }
}
