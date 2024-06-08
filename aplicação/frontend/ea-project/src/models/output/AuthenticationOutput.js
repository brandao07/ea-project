import BaseOutput from "./BaseOutput";

export default class AuthenticationOutput extends BaseOutput {
  constructor(token = "", feedbackMessages = []) {
    super(feedbackMessages);
    this.token = token;
  }
}
