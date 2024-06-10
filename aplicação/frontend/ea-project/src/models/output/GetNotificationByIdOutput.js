import BaseOutput from "./BaseOutput";

export default class GetNotificationByIdOutput extends BaseOutput {
  constructor(id = 0, messageHeader = '', messageBody = '', messageType = '', photographyPath = '', creationDate = new Date(), feedbackMessages = []) {
    super(feedbackMessages);
    this.id = id;
    this.messageHeader = messageHeader;
    this.messageBody = messageBody;
    this.messageType = messageType;
    this.photographyPath = photographyPath;
    this.creationDate = creationDate;
  }
}