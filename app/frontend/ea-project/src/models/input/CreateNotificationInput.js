import BaseInput from "./BaseInput";

export default class CreateNotificationInput extends BaseInput {
  constructor(messageHeader = '', messageBody = '', messageType = '', creationDate = new Date(), photo = new FormData(), lazyLoad = false) {
    super(lazyLoad);
    this.messageHeader = messageHeader;
    this.messageBody = messageBody;
    this.messageType = messageType;
    this.creationDate = creationDate;
    this.photo = photo;
  }
}