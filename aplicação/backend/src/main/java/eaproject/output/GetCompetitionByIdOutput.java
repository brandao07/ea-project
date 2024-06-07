package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class GetCompetitionByIdOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private CompetitionProperties competition;

    public CompetitionProperties getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionProperties competition) {
        this.competition = competition;
    }

    public static class CompetitionProperties implements Serializable {
        private int id;
        private String name;
        private Timestamp startDate;
        private Timestamp endDate;
        private boolean isActive;
        private Timestamp creationDate;
        private List<NotificationProperties> notifications; // LAZY

        // Getters e setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Timestamp getStartDate() {
            return startDate;
        }

        public void setStartDate(Timestamp startDate) {
            this.startDate = startDate;
        }

        public Timestamp getEndDate() {
            return endDate;
        }

        public void setEndDate(Timestamp endDate) {
            this.endDate = endDate;
        }

        public boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }

        public Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Timestamp creationDate) {
            this.creationDate = creationDate;
        }

        public List<NotificationProperties> getNotifications() {
            return notifications;
        }

        public void setNotifications(List<NotificationProperties> notifications) {
            this.notifications = notifications;
        }
    }

    public static class NotificationProperties implements Serializable {
        private int id;
        private String messageHeader;
        private String messageBody;
        private String messageType;
        private String photographyPath;
        private Timestamp creationDate;

        // Getters e setters
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
}
