import BaseOutput from "./BaseOutput";

export default class GetUsersOutput extends BaseOutput {
  constructor(usersList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.usersList = usersList.map(
      (user) => new GetUsersOutput.UserProperties(user)
    );
  }

  static UserProperties = class {
    constructor(
      userId,
      name,
      email,
      gender,
      age,
      height,
      weight,
      registerDate,
      photographyPath
    ) {
      this.userId = userId;
      this.name = name;
      this.email = email;
      this.gender = gender;
      this.age = age;
      this.height = height;
      this.weight = weight;
      this.registerDate = registerDate;
      this.photographyPath = photographyPath;
    }
  };
}
