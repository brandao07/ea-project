import BaseInput from "./BaseInput";

export default class CreateResultInput extends BaseInput {
  constructor(position = 0, time = new Date(), observations = '', penaltyTime = new Date(), creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.position = position;
    this.time = time;
    this.observations = observations;
    this.penaltyTime = penaltyTime;
    this.creationDate = creationDate;
  }
}