import BaseOutput from './BaseOutput';

export default class UpdateClubOutput extends BaseOutput {
    constructor(updateSuccessful = false, feedbackMessages = []) {
        super(feedbackMessages);
        this.updateSuccessful = updateSuccessful;
    }
}
