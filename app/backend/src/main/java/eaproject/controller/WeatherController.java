package eaproject.controller;

import eaproject.beans.WeatherBean;
import eaproject.input.GetWeatherInput;
import eaproject.output.GetWeatherOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class WeatherController {
    @EJB
    WeatherBean weatherBean;

    /**
     * Fetches the current weather data for a given latitude and longitude using an external weather API.
     *
     * @param input The GetWeatherInput object containing latitude and longitude for the weather data request.
     * @return A GetWeatherOutput object containing the weather data and feedback messages.
     */
    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN, T(eaproject.constants.EAProjectConstants).ROLE_DEFAULT)")
    @PostMapping("/GetWeather")
    public GetWeatherOutput getCurrentWeather(@RequestBody GetWeatherInput input) {
        return weatherBean.getWeather(input);
    }
}
