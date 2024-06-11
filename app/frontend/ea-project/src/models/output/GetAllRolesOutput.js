import BaseOutput from "./BaseOutput";

export default class GetAllRolesOutput extends BaseOutput {
  constructor(rolesList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.rolesList = rolesList.map(item => new GetAllRolesOutput.RoleProperties(item));
  }

  static RoleProperties = class {
    constructor({id = 0, name = '', description = '', creationDate = new Date()}) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.creationDate = creationDate;
    }
  };
}