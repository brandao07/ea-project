import BaseOutput from '@/models/output/BaseOutput';

export default class AuthenticationOutput extends BaseOutput {
    constructor(token = '') {
        super();
        this.token = token;
    }
}
