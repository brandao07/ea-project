import FeedbackMessage from "../base/FeedbackMessage";

class BaseOutput {
  constructor(feedbackMessages = []) {
    this.feedbackMessages = [];
    this.setFeedbackMessages(feedbackMessages);
  }

  setFeedbackMessages(feedbackMessages) {
    this.feedbackMessages = feedbackMessages.map(
      (msg) => new FeedbackMessage(msg.message, msg.severity)
    );
  }

  addFeedbackMessage(message, severity) {
    this.feedbackMessages.push(new FeedbackMessage(message, severity));
  }
}

export default BaseOutput;
