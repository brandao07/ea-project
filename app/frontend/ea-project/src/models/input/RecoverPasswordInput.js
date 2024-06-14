import BaseInput from "./BaseInput";

export default class RecoverPasswordInput extends BaseInput {
  constructor(email = '', lazyLoad = false) {
    super(lazyLoad);
    this.email = email;
  }
}