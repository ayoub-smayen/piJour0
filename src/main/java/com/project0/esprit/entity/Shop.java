package com.project0.esprit.entity;

public class Shop {

	private String shopName;

	private Address shopAddress;

	private double shopLatitude;

	private double shopLongitude;

	public double getShopLatitude() {
		return shopLatitude;
	}

	public void setShopLatitude(double shopLatitude) {
		this.shopLatitude = shopLatitude;
	}

	public double getShopLongitude() {
		return shopLongitude;
	}

	public void setShopLongitude(double shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Address getShopAddress() {
		return shopAddress;
	}

	public Shop(String shopName, Address shopAddress, double shopLatitude, double shopLongitude) {
		super();
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopLatitude = shopLatitude;
		this.shopLongitude = shopLongitude;
	}

	public void setShopAddress(Address shopAddress) {
		this.shopAddress = shopAddress;
	}

}