package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import eaproject.base.FeedbackMessage;
import eaproject.enums.FeedbackSeverity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseOutput {
    private  List<FeedbackMessage> feedbackMessages = new ArrayList<>();

    @JsonProperty
    public List<FeedbackMessage> getFeedbackMessages() {
        return feedbackMessages;
    }

    public void setFeedbackMessages(List<FeedbackMessage> feedbackMessages) {
        this.feedbackMessages = feedbackMessages;
    }

    public void addFeedbackMessage(String message, FeedbackSeverity severity) {
        this.feedbackMessages.add(new FeedbackMessage(message, severity));
    }
}
