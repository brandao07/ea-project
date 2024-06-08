import BaseInput from "./BaseInput";

export default class UpdateTeamInput extends BaseInput {
  constructor(
    id = 0,
    name = "",
    isActive = false,
    creationDate = new Date(),
    clubId = 0,
    userIds = []
  ) {
    super();
    this.id = id;
    this.name = name;
    this.isActive = isActive;
    this.creationDate = creationDate;
    this.clubId = clubId;
    this.userIds = userIds;
  }
}
