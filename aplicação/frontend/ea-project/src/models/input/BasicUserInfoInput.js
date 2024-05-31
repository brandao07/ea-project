import BaseInput from "./BaseInput";

export default class BasicUserInfoInput extends BaseInput {
  constructor(userId = 0) {
    super();
    this.userId = userId;
  }
}
