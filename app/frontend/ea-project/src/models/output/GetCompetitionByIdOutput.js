import BaseOutput from "./BaseOutput";
import GenderEnumerator from "../enums/Gender";
import GradeEnumerator from "../enums/Grade";

export default class GetCompetitionByIdOutput extends BaseOutput {
  constructor(id = 0, name = '', startDate = new Date(), endDate = new Date(), isActive = false, creationDate = new Date(),gender="",grade="",category="", feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.isActive = isActive;
    this.creationDate = creationDate;
    for (const key in GenderEnumerator) {
      if (key === gender) {
        this.gender = GenderEnumerator[key];
        console.log("aqui")
        break;
      }
    }
    
    for (const key in GradeEnumerator) {
      if (key === grade) {
        this.grade = GradeEnumerator[key];
        console.log("aqui")
        break;
      }
    }
    this.type=category;
    this.trials=[];
  }
}