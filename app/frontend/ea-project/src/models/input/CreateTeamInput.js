import BaseInput from "./BaseInput";

export default class CreateTeamInput extends BaseInput {
  constructor(name = '', isActive = false, creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.name = name;
    this.isActive = isActive;
    this.creationDate = creationDate;
  }
}