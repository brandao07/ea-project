import BaseInput from "./BaseInput";

export default class CreateStateInput extends BaseInput {
  constructor(name = '', creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.name = name;
    this.creationDate = creationDate;
  }
}