import BaseInput from "./BaseInput";

export default class UpdateTypeInput extends BaseInput {
  constructor(id = 0, name = '', numberOfPersons = 0, creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.name = name;
    this.numberOfPersons = numberOfPersons;
    this.creationDate = creationDate;
  }
}