package com.project0.esprit.datentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dictionnaire")
public class DictionnaireDesMotsInterdits {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//@Column
	private String mots;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMots() {
		return mots;
	}
	public void setMots(String mots) {
		this.mots = mots;
	}
	public DictionnaireDesMotsInterdits(Long id, String mots) {
		super();
		this.id = id;
		this.mots = mots;
	}
	public DictionnaireDesMotsInterdits(String mots) {
		super();
		this.mots = mots;
	}
	
	
	
	
}
