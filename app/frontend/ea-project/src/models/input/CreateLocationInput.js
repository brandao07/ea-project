import BaseInput from "./BaseInput";

export default class CreateLocationInput extends BaseInput {
  constructor(latitude = 0.0, longitude = 0.0, address = '', city = '', country = '', postalCode = '', creationDate = new Date(), lazyLoad = false) {
    super(lazyLoad);
    this.latitude = latitude;
    this.longitude = longitude;
    this.address = address;
    this.city = city;
    this.country = country;
    this.postalCode = postalCode;
    this.creationDate = creationDate;
  }
}