import BaseInput from "./BaseInput";

export default class CreateNotificationInput extends BaseInput {
  constructor(messageHeader = '', messageBody = '', messageType = '', competitionId = 0, creationDate = new Date(), photo = new FormData(), lazyLoad = false) {
    super(lazyLoad);
    this.messageHeader = messageHeader;
    this.messageBody = messageBody;
    this.messageType = messageType;
    this.competitionId = competitionId;
    this.creationDate = creationDate;
    this.photo = photo;
  }
}