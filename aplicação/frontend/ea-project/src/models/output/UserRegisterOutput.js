import BaseOutput from './BaseOutput';

export default class UserRegisterOutput extends BaseOutput {
    constructor(registrationSuccessful = false, feedbackMessages = []) {
        super(feedbackMessages);
        this.registrationSuccessful = registrationSuccessful;
    }
}
