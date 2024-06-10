import BaseInput from "./BaseInput";

export default class CreateLocationInput extends BaseInput {
  constructor(id = 0, latitude = null, longitude = null, address = '', city = '', country = '', postalCode = '', creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.latitude = latitude;
    this.longitude = longitude;
    this.address = address;
    this.city = city;
    this.country = country;
    this.postalCode = postalCode;
    this.creationDate = creationDate;
  }
}