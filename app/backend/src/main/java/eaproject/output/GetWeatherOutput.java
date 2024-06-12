package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GetWeatherOutput extends BaseOutput implements Serializable {
    @JsonProperty
    private WeatherApiOutput weather;

    public WeatherApiOutput getWeather() {
        return weather;
    }

    public void setWeather(WeatherApiOutput weather) {
        this.weather = weather;
    }
}
