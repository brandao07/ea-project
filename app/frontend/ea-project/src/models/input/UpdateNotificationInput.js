import BaseInput from "./BaseInput";

export default class UpdateNotificationInput extends BaseInput {
  constructor(id = 0, messageHeader = '', messageBody = '', messageType = '', photo = new FormData(), creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.messageHeader = messageHeader;
    this.messageBody = messageBody;
    this.messageType = messageType;
    this.photo = photo;
    this.creationDate = creationDate;
  }
}