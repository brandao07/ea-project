import BaseOutput from "./BaseOutput";

export default class GetAllNotificationsOutput extends BaseOutput {
  constructor(notificationList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.notificationList = notificationList.map(item => new GetAllNotificationsOutput.NotificationProperties(item));
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