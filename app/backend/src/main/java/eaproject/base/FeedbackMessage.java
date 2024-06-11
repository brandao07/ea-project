package eaproject.base;

import eaproject.enums.FeedbackSeverity;

public class FeedbackMessage {
    private String message;
    private FeedbackSeverity severity;

    public FeedbackMessage(String message, FeedbackSeverity severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FeedbackSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(FeedbackSeverity severity) {
        this.severity = severity;
    }
}
