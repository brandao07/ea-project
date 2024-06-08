import BaseInput from "./BaseInput";

export default class AuthenticationInput extends BaseInput {
  constructor(email = "", password = "") {
    super();
    this.email = email;
    this.password = password;
  }
}
