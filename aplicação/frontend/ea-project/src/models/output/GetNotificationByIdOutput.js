import BaseOutput from "./BaseOutput";

export default class GetNotificationByIdOutput extends BaseOutput {
  constructor(
    creationDate = new Date(),
    photographyPath = "",
    messageType = "",
    messageBody = "",
    messageHeader = "",
    id = 0,
    feedbackMessages = []
  ) {
    super(feedbackMessages);
    this.id = id;
    this.messageHeader = messageHeader;
    this.messageBody = messageBody;
    this.messageType = messageType;
    this.photographyPath = photographyPath;
    this.creationDate = creationDate;
  }
}
