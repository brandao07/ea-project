import BaseInput from "./BaseInput";

export default class GetWeatherInput extends BaseInput {
  constructor(lat = '', lon = '', lazyLoad = false) {
    super(lazyLoad);
    this.lat = lat;
    this.lon = lon;
  }
}