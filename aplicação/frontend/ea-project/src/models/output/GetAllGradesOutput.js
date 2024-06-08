import BaseOutput from "./BaseOutput";

export default class GetAllGradesOutput extends BaseOutput {
  constructor(getallgradeList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.getallgradeList = getallgradeList.map(
      (getallgrade) =>
        new GetAllGradesOutput.GetAllGradeProperties(
          getallgrade.id,
          getallgrade.name,
          getallgrade.minAge,
          getallgrade.maxAge,
          getallgrade.gender,
          getallgrade.creationDate
        )
    );
  }

  static GetAllGradeProperties = class {
    constructor(id, name, minAge, maxAge, gender, creationDate) {
      this.id = id;
      this.name = name;
      this.minAge = minAge;
      this.maxAge = maxAge;
      this.gender = gender;
      this.creationDate = creationDate;
    }
  };
}
