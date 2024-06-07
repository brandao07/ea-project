import BaseOutput from './BaseOutput';

export default class GetCompetitionByIdOutput extends BaseOutput {
    constructor(photographyPath = '', messageType = '', messageBody = '', messageHeader = '', notifications = [], creationDate = new Date(), isActive = false, endDate = new Date(), startDate = new Date(), name = '', id = 0, competition = null, feedbackMessages = []) {
        super(feedbackMessages);
        this.competition = competition;
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.creationDate = creationDate;
        this.notifications = notifications.map(item => new GetCompetitionByIdOutput.NotificationProperties(item));
        this.messageHeader = messageHeader;
        this.messageBody = messageBody;
        this.messageType = messageType;
        this.photographyPath = photographyPath;
    }

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
