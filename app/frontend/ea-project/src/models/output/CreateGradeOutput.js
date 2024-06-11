import BaseOutput from "./BaseOutput";

export default class CreateGradeOutput extends BaseOutput {
  constructor(updateSuccessful = false, feedbackMessages = []) {
    super(feedbackMessages);
    this.updateSuccessful = updateSuccessful;
  }
}