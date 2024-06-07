import BaseOutput from './BaseOutput';

export default class GetAllCompetitionsOutput extends BaseOutput {
    constructor(notifications = [], competitionList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.competitionList = competitionList.map(item => new GetAllCompetitionsOutput.CompetitionProperties(item));
        this.notifications = notifications.map(item => new GetAllCompetitionsOutput.NotificationProperties(item));
    }

    static CompetitionProperties = class {
        constructor(id = 0, name = '', startDate = new Date(), endDate = new Date(), isActive = false, creationDate = new Date(), notifications = []) {
            this.id = id;
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.isActive = isActive;
            this.creationDate = creationDate;
            this.notifications = notifications;
        }
    };

    static NotificationProperties = class {
        constructor(id = 0, messageHeader = '', messageBody = '', messageType = '', photographyPath = '', creationDate = new Date()) {
            this.id = id;
            this.messageHeader = messageHeader;
            this.messageBody = messageBody;
            this.messageType = messageType;
            this.photographyPath = photographyPath;
            this.creationDate = creationDate;
        }
    };
}
