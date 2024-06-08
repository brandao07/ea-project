import BaseOutput from "./BaseOutput";

export default class GetGradeByIdOutput extends BaseOutput {
  constructor(
    creationDate = new Date(),
    gender = "",
    maxAge = 0,
    minAge = 0,
    name = "",
    id = 0,
    feedbackMessages = []
  ) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.minAge = minAge;
    this.maxAge = maxAge;
    this.gender = gender;
    this.creationDate = creationDate;
  }
}
