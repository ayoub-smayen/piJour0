package com.project0.esprit.entity;

public class Location extends AuditModel {
 
	
	Integer longitude;
	Integer Latitude;
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public Integer getLatitude() {
		return Latitude;
	}
	public void setLatitude(Integer latitude) {
		Latitude = latitude;
	}
	public Location(Integer longitude, Integer latitude) {
		super();
		this.longitude = longitude;
		Latitude = latitude;
	}
	public Location() {
		super();
	}
	
}
