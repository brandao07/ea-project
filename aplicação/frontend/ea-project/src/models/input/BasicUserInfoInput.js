import BaseInput from "./BaseInput";

export default class BasicUserInfoInput extends BaseInput {
  constructor(id = 0) {
    super();
    this.id = id;
  }
}
