import BaseOutput from "./BaseOutput";

export default class GetWeatherOutput extends BaseOutput {
  constructor(weather = {}, feedbackMessages = []) {
    super(feedbackMessages);
    this.weather = new GetWeatherOutput.Weather(weather);
  }

  static Weather = class {
    constructor({main = '', description = '', temp = 0.0, tempMin = 0.0, tempMax = 0.0, pressure = 0, humidity = 0, seaLevel = 0, windSpeed = 0.0,icon=""}) {
      this.main = main;
      this.description = description;
      this.temp = temp;
      this.tempMin = tempMin;
      this.tempMax = tempMax;
      this.pressure = pressure;
      this.humidity = humidity;
      this.seaLevel = seaLevel;
      this.windSpeed = windSpeed;
      this.icon= icon;
    }
  };
}