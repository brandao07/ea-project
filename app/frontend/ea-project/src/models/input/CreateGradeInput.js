import BaseInput from "./BaseInput";

export default class CreateGradeInput extends BaseInput {
  constructor(name = '', minAge = 0, maxAge = 0, gender = '', creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.name = name;
    this.minAge = minAge;
    this.maxAge = maxAge;
    this.gender = gender;
    this.creationDate = creationDate;
  }
}