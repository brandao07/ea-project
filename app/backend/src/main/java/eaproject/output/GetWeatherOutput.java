package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GetWeatherOutput extends BaseOutput implements Serializable {
    @JsonProperty
    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public static class Weather implements Serializable {
        @JsonProperty
        private String main;
        @JsonProperty
        private String description;
        @JsonProperty
        private String icon;
        @JsonProperty
        private double temp;
        @JsonProperty
        private double tempMin;
        @JsonProperty
        private double tempMax;
        @JsonProperty
        private Integer pressure;
        @JsonProperty
        private Integer humidity;
        @JsonProperty
        private Integer seaLevel;
        @JsonProperty
        private double windSpeed;

        public String getMain() { return main; }
        public void setMain(String main) { this.main = main; }

        public String getDescription() { return description; }

        public void setDescription(String description) { this.description = description; }

        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }

        public double getTempMin() { return tempMin; }
        public void setTempMin(double tempMin) { this.tempMin = tempMin; }

        public double getTempMax() { return tempMax; }
        public void setTempMax(double tempMax) { this.tempMax = tempMax; }

        public Integer getPressure() { return pressure; }
        public void setPressure(Integer pressure) { this.pressure = pressure; }

        public Integer getHumidity() { return humidity; }
        public void setHumidity(Integer humidity) { this.humidity = humidity; }

        public Integer getSeaLevel() { return seaLevel; }
        public void setSeaLevel(Integer seaLevel) { this.seaLevel = seaLevel; }

        public double getWindSpeed() { return windSpeed; }
        public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
