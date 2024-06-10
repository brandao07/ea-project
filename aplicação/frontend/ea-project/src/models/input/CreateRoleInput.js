import BaseInput from "./BaseInput";

export default class CreateRoleInput extends BaseInput {
  constructor(id = 0, name = '', description = '', creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.name = name;
    this.description = description;
    this.creationDate = creationDate;
  }
}