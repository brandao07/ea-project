import BaseOutput from "./BaseOutput";

export default class UpdateNotificationOutput extends BaseOutput {
  constructor(updateSuccessful = false, feedbackMessages = []) {
    super(feedbackMessages);
    this.updateSuccessful = updateSuccessful;
  }
}
