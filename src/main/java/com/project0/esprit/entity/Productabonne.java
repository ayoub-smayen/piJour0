package com.project0.esprit.entity;

import org.springframework.stereotype.Service;


public class Productabonne {
	
	
	private String Abonne ;
	
	
	private String  localname;
	
	private Boolean subremise = false;

	public String getAbonne() {
		return Abonne;
	}

	public Productabonne(String abonne, String localname, Boolean subremise) {
		super();
		Abonne = abonne;
		this.localname = localname;
		this.subremise = subremise;
	}

	public void setAbonne(String abonne) {
		Abonne = abonne;
	}

	public String getLocalname() {
		return localname;
	}

	public Productabonne() {
		super();
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public Boolean getSubremise() {
		return subremise;
	}

	public void setSubremise(Boolean subremise) {
		this.subremise = subremise;
	}
	
	

}
