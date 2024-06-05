import BaseOutput from "./BaseOutput";

export default class GetRolesOutput extends BaseOutput {
  constructor(rolesList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.rolesList = rolesList.map(
      (role) => new GetRolesOutput.RoleProperties(
        role.roleId,
        role.name
      )
    );
  }

  static RoleProperties = class {
    constructor(roleId, name) {
      this.roleId = roleId;
      this.name = name;
    }
  };
}
