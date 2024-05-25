import BaseInput from './BaseInput';

export default class UserRegisterInput extends BaseInput {
    constructor(name = '', email = '', password = '', gender = '', age = 0, height = 0.0, weight = 0.0) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
