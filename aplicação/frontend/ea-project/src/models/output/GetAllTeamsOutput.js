import BaseOutput from "./BaseOutput";

export default class GetAllTeamsOutput extends BaseOutput {
  constructor(getallteamList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.getallteamList = getallteamList.map(
      (getallteam) =>
        new GetAllTeamsOutput.GetAllTeamProperties(
          getallteam.id,
          getallteam.name,
          getallteam.isActive,
          getallteam.creationDate
        )
    );
  }

  static GetAllTeamProperties = class {
    constructor(id, name, isActive, creationDate) {
      this.id = id;
      this.name = name;
      this.isActive = isActive;
      this.creationDate = creationDate;
    }
  };
}
