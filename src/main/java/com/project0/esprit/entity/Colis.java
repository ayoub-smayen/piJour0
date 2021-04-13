package com.project0.esprit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="coli")
public class Colis extends AuditModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Colis(Long colis_id, String prenom, String numtel, String adress, String remarque, String designationproduit,
			Boolean affected, Etat etatcolis) {
		super();
		this.coli_id = colis_id;
		this.prenom = prenom;
		this.numtel = numtel;
		this.adress = adress;
		this.remarque = remarque;
		this.designationproduit = designationproduit;
		this.affected = affected;
		this.etatcolis = etatcolis;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long coli_id;
	
	@Column(name="prenom")
	private String prenom ;
	
	@Column(name="numtel")
	private String numtel  ;
	
	@Column(name="address")
	private String adress  ;
	
	@Column(name="remarque")
	private String  remarque   ;
	
	@Column(name="designation")
	private String designationproduit ;
	
	@Column(name="affected")
	private Boolean affected=false;

	
	public Colis(String prenom, String numtel, String adress, String remarque, String designationproduit) {
		super();
		this.prenom = prenom;
		this.numtel = numtel;
		this.adress = adress;
		this.remarque = remarque;
		this.designationproduit = designationproduit;
	}


	public Boolean getAffected() {
		return affected;
	}


	public void setAffected(Boolean affected) {
		this.affected = affected;
	}


	//@Column(name="etat_colis")
	@ColumnDefault("0")
	@Enumerated(EnumType.ORDINAL)
	private Etat etatcolis;


	public Long getColi_id() {
		return coli_id;
	}


	public void setColi_id(Long colis_id) {
		this.coli_id = colis_id;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNumtel() {
		return numtel;
	}


	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getRemarque() {
		return remarque;
	}


	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}


	public String getDesignationproduit() {
		return designationproduit;
	}


	public void setDesignationproduit(String designationproduit) {
		this.designationproduit = designationproduit;
	}


	public Etat getEtatcolis() {
		return etatcolis;
	}


	public Colis() {
		super();
	}


	public Colis(Long colis_id, String prenom, String numtel, String adress, String remarque, String designationproduit,
			Etat etatcolis,Boolean affected) {
		super();
		this.coli_id = colis_id;
		this.prenom = prenom;
		this.numtel = numtel;
		this.adress = adress;
		this.remarque = remarque;
		this.designationproduit = designationproduit;
		this.etatcolis = etatcolis;
		this.affected=affected;
	}


	public void setEtatcolis(Etat etatcolis) {
		this.etatcolis = etatcolis;
	}


	public Colis(String prenom, String numtel, String adress, String remarque, String designationproduit,
			Etat etatcolis) {
		super();
		this.prenom = prenom;
		this.numtel = numtel;
		this.adress = adress;
		this.remarque = remarque;
		this.designationproduit = designationproduit;
		this.etatcolis = etatcolis;
		//this.affected=false;
	}


	/*public Colis(String prenom, String numtel, String adress, String remarque, String designationproduit) {
		super();
		this.prenom = prenom;
		this.numtel = numtel;
		this.adress = adress;
		this.remarque = remarque;
		this.designationproduit = designationproduit;
	}*/
	

}
