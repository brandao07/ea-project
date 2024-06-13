import BaseOutput from "./BaseOutput";

export default class UploadUserPhotoOutput extends BaseOutput {
  constructor(updateSuccessful = false, feedbackMessages = []) {
    super(feedbackMessages);
    this.updateSuccessful = updateSuccessful;
  }
}