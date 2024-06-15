package eaproject.input;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Timestamp;

public class CreateNotificationInput extends BaseInput implements Serializable {

    private String messageHeader;
    private String messageBody;
    private String messageType;
    private Integer competitionId;
    private Timestamp creationDate;

    private MultipartFile photo;

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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public MultipartFile getPhoto() { return photo; }

    public void setPhoto(MultipartFile photo) { this.photo = photo; }

    public Integer getCompetitionId() { return competitionId; }

    public void setCompetitionId(Integer competitionId) { this.competitionId = competitionId; }
}
