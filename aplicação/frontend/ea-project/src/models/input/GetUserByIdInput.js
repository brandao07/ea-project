import BaseInput from "./BaseInput";

export default class GetUserByIdInput extends BaseInput {
  constructor(id = 0, lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
  }
}