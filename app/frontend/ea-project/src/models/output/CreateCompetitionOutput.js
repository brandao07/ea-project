import BaseOutput from "./BaseOutput";

export default class CreateCompetitionOutput extends BaseOutput {
  constructor(updateSuccessful = false, feedbackMessages = []) {
    super(feedbackMessages);
    this.updateSuccessful = updateSuccessful;
  }
}