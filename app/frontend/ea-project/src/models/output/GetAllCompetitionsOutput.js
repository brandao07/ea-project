import BaseOutput from "./BaseOutput";

export default class GetAllCompetitionsOutput extends BaseOutput {
  constructor(competitionList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.competitionList = Array.isArray(competitionList) ? competitionList.map(item => new GetAllCompetitionsOutput.CompetitionProperties(item)) : [];
  }

  static CompetitionProperties = class {
    constructor({id = 0, name = '', startDate = new Date(), endDate = new Date(), isActive = false, creationDate = new Date(), grade = '', category ='', gender = ''}) {
      this.id = id;
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
      this.isActive = isActive;
      this.creationDate = creationDate;
      this.grade = grade,
      this.category = category,
      this.gender = gender
    }
  };
}