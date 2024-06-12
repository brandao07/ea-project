package eaproject.beans;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eaproject.enums.FeedbackSeverity;
import eaproject.output.GetWeatherOutput;
import eaproject.output.WeatherApiOutput;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Stateless(name = "WeatherEJB")
@Component
public class WeatherBean {
    private final Dotenv dotenv = Dotenv.load();
    private String urlString;
    private String apiKey;

    @PostConstruct
    public void init() {
        this.urlString = dotenv.get("WEATHER_API_URL");
        this.apiKey = dotenv.get("WEATHER_API_KEY");
    }

    public GetWeatherOutput getWeather(String lon, String lat) {
        var output = new GetWeatherOutput();

        String urlString = this.urlString + "?lat=" + lat + "&lon=" + lon + "&appid=" + this.apiKey;;

        try {
            var url = new URL(urlString);
            var connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) throw new RuntimeException("Failed : HTTP error code : " + responseCode);

            // Read the response
            var in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            var response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the response
            var objectMapper = new ObjectMapper();
            var rootNode = objectMapper.readTree(response.toString());

            // Extract required fields
            String main = rootNode.path("weather").get(0).path("main").asText();
            String description = rootNode.path("weather").get(0).path("description").asText();
            double temp = rootNode.path("main").path("temp").asDouble();
            double tempMin = rootNode.path("main").path("temp_min").asDouble();
            double tempMax = rootNode.path("main").path("temp_max").asDouble();
            int pressure = rootNode.path("main").path("pressure").asInt();
            int humidity = rootNode.path("main").path("humidity").asInt();
            int seaLevel = rootNode.path("main").path("sea_level").asInt();
            double windSpeed = rootNode.path("wind").path("speed").asDouble();

            var weatherApiOutput = new WeatherApiOutput();
            weatherApiOutput.setMain(main);
            weatherApiOutput.setDescription(description);
            weatherApiOutput.setTemp(temp);
            weatherApiOutput.setTempMin(tempMin);
            weatherApiOutput.setTempMax(tempMax);
            weatherApiOutput.setPressure(pressure);
            weatherApiOutput.setHumidity(humidity);
            weatherApiOutput.setSeaLevel(seaLevel);
            weatherApiOutput.setWindSpeed(windSpeed);

            output.addFeedbackMessage("Current Weather for lat: " + lat + " and lon: " + lon, FeedbackSeverity.SUCCESS);
            output.setWeather(weatherApiOutput);

        } catch (Exception e) {
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        }
        return output;
    }
}
