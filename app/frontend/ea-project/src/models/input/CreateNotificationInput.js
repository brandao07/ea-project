import BaseInput from "./BaseInput";

export default class CreateNotificationInput extends BaseInput {
  constructor(id = 0, messageHeader = '', messageBody = '', messageType = '', photographyPath = '', creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.messageHeader = messageHeader;
    this.messageBody = messageBody;
    this.messageType = messageType;
    this.photographyPath = photographyPath;
    this.creationDate = creationDate;
  }
}