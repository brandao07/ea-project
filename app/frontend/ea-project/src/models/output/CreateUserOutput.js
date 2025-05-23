import BaseOutput from "./BaseOutput";

export default class CreateUserOutput extends BaseOutput {
  constructor(registrationSuccessful = false, feedbackMessages = []) {
    super(feedbackMessages);
    this.registrationSuccessful = registrationSuccessful;
  }
}