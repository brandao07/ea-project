import BaseInput from "./BaseInput";

export default class GetLocationByIdInput extends BaseInput {
  constructor(id = 0, lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
  }
}