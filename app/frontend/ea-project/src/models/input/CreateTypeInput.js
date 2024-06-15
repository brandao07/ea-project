import BaseInput from "./BaseInput";

export default class CreateTypeInput extends BaseInput {
  constructor(name = '', numberOfPersons = 0, creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.name = name;
    this.numberOfPersons = numberOfPersons;
    this.creationDate = creationDate;
  }
}