import BaseOutput from "./BaseOutput";

export default class GetRolesOutput extends BaseOutput {
  constructor(getroleList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.getroleList = getroleList.map(
      (getrole) =>
        new GetRolesOutput.GetRoleProperties(
          getrole.id,
          getrole.name,
          getrole.description,
          getrole.creationDate
        )
    );
  }

  static GetRoleProperties = class {
    constructor(id, name, description, creationDate) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.creationDate = creationDate;
    }
  };
}
