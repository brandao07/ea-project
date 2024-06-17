import BaseOutput from "./BaseOutput";

export default class GetCompetitionByIdOutput extends BaseOutput {
  constructor(id = 0, name = '', startDate = new Date(), endDate = new Date(), isActive = false, creationDate = new Date(),gender="",grade="",category="",trials=[], feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.isActive = isActive;
    this.creationDate = creationDate;
    this.gender=gender;
    this.grade=grade;
    this.type=category;
    this.trials=trials;
  }
}