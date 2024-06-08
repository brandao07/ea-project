import BaseOutput from "./BaseOutput";

export default class GetAllCompetitionsOutput extends BaseOutput {
  constructor(getallcompetitionList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.getallcompetitionList = getallcompetitionList.map(
      (getallcompetition) =>
        new GetAllCompetitionsOutput.GetAllCompetitionProperties(
          getallcompetition.id,
          getallcompetition.name,
          getallcompetition.startDate,
          getallcompetition.endDate,
          getallcompetition.isActive,
          getallcompetition.creationDate
        )
    );
  }

  static GetAllCompetitionProperties = class {
    constructor(id, name, startDate, endDate, isActive, creationDate) {
      this.id = id;
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
      this.isActive = isActive;
      this.creationDate = creationDate;
    }
  };
}
