import BaseInput from "./BaseInput";

export default class CreateStateInput extends BaseInput {
  constructor(id = 0, name = '', creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.name = name;
    this.creationDate = creationDate;
  }
}