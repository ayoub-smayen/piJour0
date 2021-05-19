package com.project0.esprit.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String number;

	private String addressLine1;

	private String addressLine2;

	private String postCode;

	public String getNumber() {
		return number;
	}
	

	public Address() {
		super();
	}


	public void setNumber(String number) {
		this.number = number;
	}

	public Address(String number, String addressLine1, String addressLine2, String postCode) {
		super();
		this.number = number;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.postCode = postCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
}