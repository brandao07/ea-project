import BaseInput from "./BaseInput";

export default class UpdateStateInput extends BaseInput {
  constructor(id = 0, name = "", creationDate = new Date()) {
    super();
    this.id = id;
    this.name = name;
    this.creationDate = creationDate;
  }
}
