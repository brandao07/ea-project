import BaseOutput from "./BaseOutput";

export default class GetAllUsersOutput extends BaseOutput {
  constructor(usersList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.usersList = usersList.map(item => new GetAllUsersOutput.UserProperties(item));
  }

  static UserProperties = class UserProperties {
    constructor(id = 0, name = '', email = '', gender = '', age = 0, height = null, weight = null, registerDate = new Date(), photographyPath = '') {
      this.id = id;
      this.name = name;
      this.email = email;
      this.gender = gender;
      this.age = age;
      this.height = height;
      this.weight = weight;
      this.registerDate = registerDate;
      this.photographyPath = photographyPath;
    }
  }
}