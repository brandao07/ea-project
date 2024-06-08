package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import eaproject.base.FeedbackMessage;
import eaproject.enums.FeedbackSeverity;

import java.util.ArrayList;

public abstract class BaseOutput {
    private  ArrayList<FeedbackMessage> feedbackMessages = new ArrayList<>();

    @JsonProperty
    public ArrayList<FeedbackMessage> getFeedbackMessages() {
        return feedbackMessages;
    }

    public void setFeedbackMessages(ArrayList<FeedbackMessage> feedbackMessages) {
        this.feedbackMessages = feedbackMessages;
    }

    public void addFeedbackMessage(String message, FeedbackSeverity severity) {
        this.feedbackMessages.add(new FeedbackMessage(message, severity));
    }
}
