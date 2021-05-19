package com.project0.esprit.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project0.esprit.datentity.User;



@Entity
@Table(name="Commande")
public class Commande extends AuditModel {

private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//@Temporal(TemporalType.DATE)
	private LocalDate date;
	
	private float montant;
	
	private String status;
	
	private String typedePayment;
	
	private String remise;
	
	private double pourcentageDeRemise;
	
	@JsonIgnore
	@OneToMany(mappedBy="commande",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<LigneCommande> ligneCommande;
	@JsonIgnore
	@OneToOne(mappedBy="commande")
	Facture factureid;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private User user;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate  getDate() {
		return date;
	}
	
	public void setDate(LocalDate  date) {
		this.date = date;
	}
	
	public float getMontant() {
		return montant;
	}
	
	public void setMontant(float montant) {
		this.montant = montant;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Set<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(Set<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Commande(LocalDate date, float montant, String status, String typedePayment, String remise,
			double pourcentageDeRemise, Set<LigneCommande> ligneCommande, Facture factureid, User user) {
		super();
		this.date = date;
		this.montant = montant;
		this.status = status;
		this.typedePayment = typedePayment;
		this.remise = remise;
		this.pourcentageDeRemise = pourcentageDeRemise;
		this.ligneCommande = ligneCommande;
		this.factureid = factureid;
		this.user = user;
	}

	public Commande(Long id, LocalDate date, float montant, String status, String typedePayment, String remise,
			double pourcentageDeRemise, Set<LigneCommande> ligneCommande, Facture factureid, User user) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.status = status;
		this.typedePayment = typedePayment;
		this.remise = remise;
		this.pourcentageDeRemise = pourcentageDeRemise;
		this.ligneCommande = ligneCommande;
		this.factureid = factureid;
		this.user = user;
	}

	public Commande(Long id, LocalDate date, float montant, String status) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.status = status;
	}
	
	public Commande() {
		super();
	}
	
	public Commande(LocalDate date, float montant, String status) {
		super();
		this.date = date;
		this.montant = montant;
		this.status = status;
	}
	
	
	public String getTypedePayment() {
		return typedePayment;
	}
	
	public void setTypedePayment(String typedePayment) {
		this.typedePayment = typedePayment;
	}
	
	public User getIdUser() {
		return user;
	}
	
	public void setIdUser(User idUser) {
		this.user = idUser;
	}
	
	public String getRemise() {
		return remise;
	}
	
	public void setRemise(String remise) {
		this.remise = remise;
	}
	
	

	public Stream<Commande> stream() {
		// TODO Auto-generated method stub
		return null;
	}
	public double getPourcentageDeRemise() {
		return pourcentageDeRemise;
	}
	public void setPourcentageDeRemise(double pourcentageDeRemise) {
		this.pourcentageDeRemise = pourcentageDeRemise;
	}

	public Facture getFactureid() {
		return factureid;
	}

	public void setFactureid(Facture factureid) {
		this.factureid = factureid;
	}
	
}
