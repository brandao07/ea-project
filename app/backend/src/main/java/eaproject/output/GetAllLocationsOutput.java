package eaproject.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GetAllLocationsOutput extends BaseOutput implements Serializable {

    @JsonProperty
    private ArrayList<LocationProperties> locationList;

    public ArrayList<LocationProperties> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<LocationProperties> locationList) {
        this.locationList = locationList;
    }

    public static class LocationProperties implements Serializable {

        @JsonProperty
        private int id;

        @JsonProperty
        private Double latitude;

        @JsonProperty
        private Double longitude;

        @JsonProperty
        private String address;

        @JsonProperty
        private String city;

        @JsonProperty
        private String country;

        @JsonProperty
        private String postalCode;

        @JsonProperty
        private Timestamp creationDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() { return longitude; }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Timestamp creationDate) {
            this.creationDate = creationDate;
        }
    }
}
