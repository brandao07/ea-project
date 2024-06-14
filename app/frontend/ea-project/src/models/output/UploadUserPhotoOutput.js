import BaseOutput from "./BaseOutput";

export default class UploadUserPhotoOutput extends BaseOutput {
  constructor(token = '', updateSuccessful = false, feedbackMessages = []) {
    super(feedbackMessages);
    this.token = token;
    this.updateSuccessful = updateSuccessful;
  }
}