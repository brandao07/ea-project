import BaseOutput from "./BaseOutput";

export default class GetRolesOutput extends BaseOutput {
  constructor(rolesList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.rolesList = rolesList.map(
      (role) => new GetRolesOutput.RoleProperties(
        role.id,
        role.name
      )
    );
  }

  static RoleProperties = class {
    constructor(id, name) {
      this.id = id;
      this.name = name;
    }
  };
}
