package eaproject.beans.locals;

import eaproject.input.GetWeatherInput;
import eaproject.output.GetWeatherOutput;

import javax.ejb.Local;

@Local
public interface WeatherLocal {

    /**
     * Fetches the current weather data for a given latitude and longitude using an external weather API.
     *
     * @param input The GetWeatherInput object containing latitude and longitude for the weather data request.
     * @return A GetWeatherOutput object containing the weather data and feedback messages.
     */
    GetWeatherOutput getWeather(GetWeatherInput input);
}