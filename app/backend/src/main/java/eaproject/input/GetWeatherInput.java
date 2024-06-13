package eaproject.input;

import java.io.Serializable;

public class GetWeatherInput extends BaseInput implements Serializable {

    private String lat;

    private String lon;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
