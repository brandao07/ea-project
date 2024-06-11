import FeedbackSeverity from '../enums/FeedbackSeverity';

export default class FeedbackMessage {
    constructor(message = '', severity = FeedbackSeverity.INFO) {
        this.message = message;
        this.severity = severity;
    }
}
