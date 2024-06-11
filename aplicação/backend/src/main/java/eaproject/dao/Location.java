/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Eduardo(University of Minho)
 * License Type: Academic
 */
package eaproject.dao;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=true)
@Table(name="location")
public class Location implements Serializable {
	public Location() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="EAPROJECT_DAO_LOCATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EAPROJECT_DAO_LOCATION_ID_GENERATOR", strategy="increment")	
	private Integer Id;
	
	@Column(name="Latitude", nullable=false)	
	private Double Latitude;
	
	@Column(name="Longitude", nullable=false)	
	private Double Longitude;
	
	@Column(name="Address", nullable=true, length=255)	
	private String Address;
	
	@Column(name="City", nullable=true, length=255)	
	private String City;
	
	@Column(name="Country", nullable=true, length=255)	
	private String Country;
	
	@Column(name="Postalcode", nullable=true, length=255)	
	private String PostalCode;
	
	@Column(name="Creationdate", nullable=true)	
	private java.sql.Timestamp CreationDate;
	
	private void setId(int value) {
		setId(Integer.valueOf(value));
	}
	
	private void setId(Integer value) {
		this.Id = value;
	}
	
	public Integer getId() {
		return Id;
	}
	
	public Integer getORMID() {
		return getId();
	}
	
	public void setLatitude(double value) {
		setLatitude(Double.valueOf(value));
	}
	
	public void setLatitude(Double value) {
		this.Latitude = value;
	}
	
	public Double getLatitude() {
		return Latitude;
	}
	
	public void setLongitude(double value) {
		setLongitude(Double.valueOf(value));
	}
	
	public void setLongitude(Double value) {
		this.Longitude = value;
	}
	
	public Double getLongitude() {
		return Longitude;
	}
	
	public void setAddress(String value) {
		this.Address = value;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setCity(String value) {
		this.City = value;
	}
	
	public String getCity() {
		return City;
	}
	
	public void setCountry(String value) {
		this.Country = value;
	}
	
	public String getCountry() {
		return Country;
	}
	
	public void setPostalCode(String value) {
		this.PostalCode = value;
	}
	
	public String getPostalCode() {
		return PostalCode;
	}
	
	public void setCreationDate(java.sql.Timestamp value) {
		this.CreationDate = value;
	}
	
	public java.sql.Timestamp getCreationDate() {
		return CreationDate;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
