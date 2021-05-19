package com.project0.esprit.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.minidev.json.annotate.JsonIgnore;


@Entity
@JsonIgnoreProperties
public class LigneCommande implements Serializable  {

	static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String productName;
	
	private int quantity;
	
	private double price;
	
	private String status;
	
    @JsonIgnore
	@ManyToOne
	private Product1 produit;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
    private Commande commande ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product1 getProduit() {
		return produit;
	}

	public void setProduit(Product1 produit) {
		this.produit = produit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LigneCommande( int quantity) {
		super();
		
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public LigneCommande() {
		super();
	}

	public LigneCommande(String productName, int quantity, double price, String status, Product1 produit,
			Commande commande) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.produit = produit;
		this.commande = commande;
	}

	public LigneCommande(Long id, String productName, int quantity, double price, String status, Product1 produit,
			Commande commande) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.produit = produit;
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantity=" + quantity + ", price=" + price + ", status=" + status
				+ ", produit=" + produit + ", commande=" + commande + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((produit == null) ? 0 : produit.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCommande other = (LigneCommande) obj;
		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (produit == null) {
			if (other.produit != null)
				return false;
		} else if (!produit.equals(other.produit))
			return false;
		if (quantity != other.quantity)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
