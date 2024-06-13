import BaseInput from "./BaseInput";

export default class UploadUserPhotoInput extends BaseInput {
  constructor(id = 0, photo = new FormData(), lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.photo = photo;
  }
}