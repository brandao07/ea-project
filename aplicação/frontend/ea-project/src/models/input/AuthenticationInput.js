import BaseInput from './BaseInput';

export default class AuthenticationInput extends BaseInput {
    constructor(email = '', password = '', lazyLoad = false) {
        super(lazyLoad);
        this.email = email;
        this.password = password;
    }
}
