import FeedbackMessage from '../base/FeedbackMessage';

export default class BaseOutput {
    constructor() {
        this.feedbackMessages = [];
    }

    addFeedbackMessage(message, severity) {
        this.feedbackMessages.push(new FeedbackMessage(message, severity));
    }

    setFeedbackMessages(feedbackMessages) {
        this.feedbackMessages = feedbackMessages.map(msg => new FeedbackMessage(msg.message, msg.severity));
    }

    sortFeedbackMessagesBySeverity() {
        this.feedbackMessages.sort((a, b) => a.severity.localeCompare(b.severity));
    }
}