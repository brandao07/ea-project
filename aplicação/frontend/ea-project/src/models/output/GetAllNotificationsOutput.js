import BaseOutput from './BaseOutput';

export default class GetAllNotificationsOutput extends BaseOutput {
    constructor(getallnotificationList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.getallnotificationList = getallnotificationList.map(
            (getallnotification) => new GetAllNotificationsOutput.GetAllNotificationProperties(
                getallnotification.id,
                getallnotification.messageHeader,
                getallnotification.messageBody,
                getallnotification.messageType,
                getallnotification.photographyPath,
                getallnotification.creationDate
            )
        );
    }

    static GetAllNotificationProperties = class {
        constructor(id, messageHeader, messageBody, messageType, photographyPath, creationDate) {
            this.id = id;
            this.messageHeader = messageHeader;
            this.messageBody = messageBody;
            this.messageType = messageType;
            this.photographyPath = photographyPath;
            this.creationDate = creationDate;
        }
    };
}
