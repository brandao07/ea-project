import BaseInput from "./BaseInput";

export default class CreateCompetitionInput extends BaseInput {
  constructor(name = '', startDate = new Date(), endDate = new Date(), isActive = false, creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.isActive = isActive;
    this.creationDate = creationDate;
  }
}