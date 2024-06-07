import BaseOutput from './BaseOutput';

export default class UpdateUserRoleOutput extends BaseOutput {
    constructor(updateSuccessful = false, feedbackMessages = []) {
        super(feedbackMessages);
        this.updateSuccessful = updateSuccessful;
    }
}
