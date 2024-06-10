import BaseOutput from "./BaseOutput";

export default class GetAllLocationsOutput extends BaseOutput {
  constructor(locationList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.locationList = locationList.map(item => new GetAllLocationsOutput.LocationProperties(item));
  }

  static LocationProperties = class {
    constructor(id = 0, latitude = null, longitude = null, address = '', city = '', country = '', postalCode = '', creationDate = new Date()) {
      this.id = id;
      this.latitude = latitude;
      this.longitude = longitude;
      this.address = address;
      this.city = city;
      this.country = country;
      this.postalCode = postalCode;
      this.creationDate = creationDate;
    }
  };
}