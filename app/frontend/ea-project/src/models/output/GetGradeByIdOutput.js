import BaseOutput from "./BaseOutput";

export default class GetGradeByIdOutput extends BaseOutput {
  constructor(id = 0, name = '', minAge = 0, maxAge = 0, gender = '', creationDate = new Date(), feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.minAge = minAge;
    this.maxAge = maxAge;
    this.gender = gender;
    this.creationDate = creationDate;
  }
}