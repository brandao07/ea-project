import BaseOutput from './BaseOutput';

export default class UserRegisterOutput extends BaseOutput {
    constructor(registrationSuccessful = false) {
        super();
        this.registrationSuccessful = registrationSuccessful;
    }
}