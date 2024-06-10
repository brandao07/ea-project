import BaseOutput from "./BaseOutput";

export default class GetUserByIdOutput extends BaseOutput {
  constructor(name = '', email = '', gender = '', age = 0, height = null, weight = null, feedbackMessages = []) {
    super(feedbackMessages);
    this.name = name;
    this.email = email;
    this.gender = gender;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
}