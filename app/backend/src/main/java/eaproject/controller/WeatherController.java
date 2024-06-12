package eaproject.controller;

import eaproject.beans.WeatherBean;
import eaproject.enums.FeedbackSeverity;
import eaproject.output.GetWeatherOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
public class WeatherController {
    @EJB
    WeatherBean weatherBean;

    @PreAuthorize("hasAnyRole(T(eaproject.constants.EAProjectConstants).ROLE_PARTICIPANT, T(eaproject.constants.EAProjectConstants).ROLE_ADMIN)")
    @GetMapping("/GetWeather")
    public GetWeatherOutput getWeather(@RequestParam String lat, @RequestParam String lon) {
        return weatherBean.getWeather(lat, lon);
    }
}
