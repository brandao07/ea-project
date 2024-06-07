import BaseOutput from './BaseOutput';

export default class BasicUserInfoOutput extends BaseOutput {
  constructor(name, email, gender, age, height, weight, feedbackMessages = []) {
        super(feedbackMessages);
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
