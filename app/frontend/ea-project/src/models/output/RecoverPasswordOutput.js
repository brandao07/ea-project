import BaseOutput from "./BaseOutput";

export default class RecoverPasswordOutput extends BaseOutput {
  constructor(successful = false, feedbackMessages = []) {
    super(feedbackMessages);
    this.successful = successful;
  }
}