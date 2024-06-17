import BaseOutput from "./BaseOutput";

export default class AuthenticationOutput extends BaseOutput {
  constructor(token = '',userId,role, feedbackMessages = []) {
    super(feedbackMessages);
    this.token = token;
    this.userId=userId;
    this.role=role;
  }
}