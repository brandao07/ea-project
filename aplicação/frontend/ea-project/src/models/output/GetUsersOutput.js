import BaseOutput from "./BaseOutput";

export default class GetUsersOutput extends BaseOutput {
  constructor(usersList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.usersList = usersList.map(
      (user) => new GetUsersOutput.UserProperties(
        user.id,
        user.email
      )
    );
  }

  static UserProperties = class {
    constructor(
      id,
      email,
    ) {
      this.id = id;
      this.email = email;
    }
  };
}
