import BaseOutput from './BaseOutput';

export default class GetLocationByIdOutput extends BaseOutput {
    constructor(creationDate = new Date(), postalCode = '', country = '', city = '', address = '', longitude = null, latitude = null, id = 0, feedbackMessages = []) {
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
