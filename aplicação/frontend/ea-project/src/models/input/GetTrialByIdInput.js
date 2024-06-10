import BaseInput from "./BaseInput";

export default class GetTrialByIdInput extends BaseInput {
  constructor(id = 0, lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
  }
}