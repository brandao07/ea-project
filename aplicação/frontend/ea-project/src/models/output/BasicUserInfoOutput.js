import BaseOutput from './BaseOutput';

export default class BasicUserInfoOutput extends BaseOutput {
    constructor(weight = 0.0, height = 0.0, age = 0, gender = '', email = '', name = '', feedbackMessages = []) {
        super(feedbackMessages);
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
