import BaseInput from "./BaseInput";

export default class UpdateResultInput extends BaseInput {
  constructor(
    id = 0,
    position = 0,
    time = new Date(),
    observations = "",
    penaltyTime = new Date(),
    creationDate = new Date()
  ) {
    super();
    this.id = id;
    this.position = position;
    this.time = time;
    this.observations = observations;
    this.penaltyTime = penaltyTime;
    this.creationDate = creationDate;
  }
}
