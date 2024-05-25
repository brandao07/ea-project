import BaseOutput from '@/models/output/BaseOutput';

export default class AuthenticationOutput extends BaseOutput {
    constructor(token = '', feedbackMessages = []) {
        super(feedbackMessages);
        this.token = token;
    }
}
