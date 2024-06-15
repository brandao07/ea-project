import BaseOutput from "./BaseOutput";

export default class GetAllGradesOutput extends BaseOutput {
  constructor(gradeList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.gradeList = Array.isArray(gradeList) ? gradeList.map(item => new GetAllGradesOutput.GradeProperties(item)) : [];
  }

  static GradeProperties = class {
    constructor({id = 0, name = '', minAge = 0, maxAge = 0, gender = '', creationDate = new Date()}) {
      this.id = id;
      this.name = name;
      this.minAge = minAge;
      this.maxAge = maxAge;
      this.gender = gender;
      this.creationDate = creationDate;
    }
  };
}