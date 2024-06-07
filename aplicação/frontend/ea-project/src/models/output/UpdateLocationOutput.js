import BaseOutput from './BaseOutput';

export default class UpdateLocationOutput extends BaseOutput {
    constructor(updateSuccessful = false, feedbackMessages = []) {
        super(feedbackMessages);
        this.updateSuccessful = updateSuccessful;
    }
}
