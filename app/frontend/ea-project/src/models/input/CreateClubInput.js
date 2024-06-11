import BaseInput from "./BaseInput";

export default class CreateClubInput extends BaseInput {
  constructor(id = 0, name = '', isActive = false, creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.name = name;
    this.isActive = isActive;
    this.creationDate = creationDate;
  }
}