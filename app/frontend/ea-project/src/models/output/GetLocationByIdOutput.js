import BaseOutput from "./BaseOutput";

export default class GetLocationByIdOutput extends BaseOutput {
  constructor(id = 0, latitude = 0.0, longitude = 0.0, address = '', city = '', country = '', postalCode = '', creationDate = new Date(), feedbackMessages = []) {
    super(feedbackMessages);
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