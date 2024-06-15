package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;

public class GetNotificationByIdOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String messageHeader;

    @JsonProperty
    private String messageBody;

    @JsonProperty
    private String messageType;

    @JsonProperty
    private String photographyPath;

    @JsonProperty
    private Timestamp creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
