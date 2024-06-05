import BaseOutput from "./BaseOutput";

export default class GetUsersOutput extends BaseOutput {
  constructor(usersList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.usersList = usersList.map(
      (user) => new GetUsersOutput.UserProperties(
        user.userId,
        user.email
      )
    );
  }

  static UserProperties = class {
    constructor(
      userId,
      email,
    ) {
      this.userId = userId;
      this.email = email;
    }
  };
}
