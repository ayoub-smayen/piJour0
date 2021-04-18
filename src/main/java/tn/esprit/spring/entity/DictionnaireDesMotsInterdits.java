package tn.esprit.spring.entity;

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
	private int id;
	@Column
	private String mots;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMots() {
		return mots;
	}
	public void setMots(String mots) {
		this.mots = mots;
	}
	public DictionnaireDesMotsInterdits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DictionnaireDesMotsInterdits(int id, String mots) {
		super();
		this.id = id;
		this.mots = mots;
	}

}
