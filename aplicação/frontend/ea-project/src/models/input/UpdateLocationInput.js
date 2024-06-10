import BaseInput from "./BaseInput";

export default class UpdateLocationInput extends BaseInput {
  constructor(id = 0, latitude = 0.0, longitude = 0.0, address = '', city = '', country = '', postalCode = '', creationDate = new Date(), lazyLoad = false) {
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