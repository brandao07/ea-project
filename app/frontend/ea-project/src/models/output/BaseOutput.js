import FeedbackMessage from '@/models/base/FeedbackMessage';

export default class BaseOutput {
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
