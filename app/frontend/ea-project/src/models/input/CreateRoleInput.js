import BaseInput from "./BaseInput";

export default class CreateRoleInput extends BaseInput {
  constructor(name = '', description = '', creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.name = name;
    this.description = description;
    this.creationDate = creationDate;
  }
}