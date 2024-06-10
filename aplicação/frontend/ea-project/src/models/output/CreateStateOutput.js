import BaseOutput from "./BaseOutput";

export default class CreateStateOutput extends BaseOutput {
  constructor(updateSuccessful = false, feedbackMessages = []) {
    super(feedbackMessages);
    this.updateSuccessful = updateSuccessful;
  }
}