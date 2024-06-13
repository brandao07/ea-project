package eaproject.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import eaproject.beans.locals.WeatherLocal;
import eaproject.enums.FeedbackSeverity;
import eaproject.input.GetWeatherInput;
import eaproject.output.GetWeatherOutput;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Stateless(name = "WeatherEJB")
@Local(WeatherLocal.class)
@Component
public class WeatherBean implements WeatherLocal {
    private final Dotenv dotenv = Dotenv.load();
    private String urlString;
    private String apiKey;

    @PostConstruct
    public void init() {
        this.urlString = dotenv.get("WEATHER_API_URL");
        this.apiKey = dotenv.get("WEATHER_API_KEY");
    }

    /**
     * Fetches the current weather data for a given latitude and longitude using an external weather API.
     *
     * @param input The GetWeatherInput object containing latitude and longitude for the weather data request.
     * @return A GetWeatherOutput object containing the weather data and feedback messages.
     */
    public GetWeatherOutput getWeather(GetWeatherInput input) {
        // Initialize the output object which will hold the weather data and feedback messages
        GetWeatherOutput output = new GetWeatherOutput();

        // Construct the URL string for the weather API request
        String urlString = this.urlString + "?lat=" + input.getLat() + "&lon=" + input.getLon() + "&appid=" + this.apiKey;

        try {
            // Create a URL object from the constructed URL string
            var url = new URL(urlString);
            // Open a connection to the URL
            var connection = (HttpURLConnection) url.openConnection();
            // Set the HTTP request method to GET
            connection.setRequestMethod("GET");

            // Get the HTTP response code from the API request
            int responseCode = connection.getResponseCode();

            // Check if the response code is OK (200), otherwise throw an exception
            if (responseCode != HttpURLConnection.HTTP_OK)
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);

            // Read the response from the input stream
            var in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            var response = new StringBuilder();

            // Append each line of the response to the StringBuilder
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            // Close the input stream
            in.close();

            // Parse the JSON response using ObjectMapper
            var objectMapper = new ObjectMapper();
            var rootNode = objectMapper.readTree(response.toString());

            // Extract required weather data fields from the JSON response
            String main = rootNode.path("weather").get(0).path("main").asText();
            String description = rootNode.path("weather").get(0).path("description").asText();
            double temp = rootNode.path("main").path("temp").asDouble();
            double tempMin = rootNode.path("main").path("temp_min").asDouble();
            double tempMax = rootNode.path("main").path("temp_max").asDouble();
            int pressure = rootNode.path("main").path("pressure").asInt();
            int humidity = rootNode.path("main").path("humidity").asInt();
            int seaLevel = rootNode.path("main").path("sea_level").asInt();
            double windSpeed = rootNode.path("wind").path("speed").asDouble();

            // Create a Weather object to hold the extracted weather data
            GetWeatherOutput.Weather weatherApiOutput = new GetWeatherOutput.Weather();
            weatherApiOutput.setMain(main);
            weatherApiOutput.setDescription(description);
            weatherApiOutput.setTemp(temp);
            weatherApiOutput.setTempMin(tempMin);
            weatherApiOutput.setTempMax(tempMax);
            weatherApiOutput.setPressure(pressure);
            weatherApiOutput.setHumidity(humidity);
            weatherApiOutput.setSeaLevel(seaLevel);
            weatherApiOutput.setWindSpeed(windSpeed);

            // Add a feedback message indicating successful retrieval of weather data
            output.addFeedbackMessage("Current Weather for lat: " + input.getLat() + " and lon: " + input.getLon(), FeedbackSeverity.SUCCESS);
            // Set the weather data in the output object
            output.setWeather(weatherApiOutput);

        } catch (Exception e) {
            // Add a feedback message indicating an error, with the exception message
            output.addFeedbackMessage(e.getMessage(), FeedbackSeverity.DANGER);
        }
        // Return the output object containing weather data and feedback messages
        return output;
    }
}
