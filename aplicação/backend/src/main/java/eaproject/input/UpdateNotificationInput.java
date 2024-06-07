package eaproject.input;

import java.io.Serializable;
import java.sql.Timestamp;

public class UpdateNotificationInput extends BaseInput implements Serializable {

    private int id;
    private String messageHeader;
    private String messageBody;
    private String messageType;
    private String photographyPath;
    private Timestamp creationDate;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getPhotographyPath() {
        return photographyPath;
    }

    public void setPhotographyPath(String photographyPath) {
        this.photographyPath = photographyPath;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
