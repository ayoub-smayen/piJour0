package com.project0.esprit.entity.panier;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import net.minidev.json.annotate.JsonIgnore;
@Entity
public class Facture implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String Type;
	
	private LocalDate date;
	
	private long Nfact;
	

	
	@JsonIgnore
	@OneToOne
	Commande commande;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String type) {
		Type = type;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Commande getCommande() {
		return commande;
	}
	
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}