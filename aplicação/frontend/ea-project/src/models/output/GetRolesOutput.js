import BaseOutput from "./BaseOutput";

export default class GetRolesOutput extends BaseOutput {
  constructor(rolesList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.rolesList = rolesList.map(
      (role) => new GetRolesOutput.RoleProperties(role)
    );
  }

  static RoleProperties = class {
    constructor(roleId, name, description, creationDate) {
      this.roleId = roleId;
      this.name = name;
      this.description = description;
      this.creationDate = creationDate;
    }
  };
}
