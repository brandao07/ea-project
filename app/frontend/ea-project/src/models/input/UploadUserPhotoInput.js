import BaseInput from "./BaseInput";

export default class UploadUserPhotoInput extends BaseInput {
  constructor(id = 0, photoBase64 = '', fileName = '', contentType = '', lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.photoBase64 = photoBase64;
    this.fileName = fileName;
    this.contentType = contentType;
  }
}