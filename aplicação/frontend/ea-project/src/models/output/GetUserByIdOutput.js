import BaseOutput from "./BaseOutput";

export default class GetUserByIdOutput extends BaseOutput {
  constructor(feedbackMessages = []) {
    super(feedbackMessages);
  }
}