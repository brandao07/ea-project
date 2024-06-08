import BaseInput from "./BaseInput";

export default class UpdateClubInput extends BaseInput {
  constructor(
    id = 0,
    name = "",
    isActive = false,
    creationDate = new Date()
  ) {
    super();
    this.id = id;
    this.name = name;
    this.isActive = isActive;
    this.creationDate = creationDate;
  }
}
