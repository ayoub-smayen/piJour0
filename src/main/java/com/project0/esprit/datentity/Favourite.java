package com.project0.esprit.datentity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project0.esprit.entity.AuditModel;
import com.project0.esprit.entity.Product1;
@Entity
@Table(name = "favourite")
public class Favourite extends AuditModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favourite_id")
	private Long favourite_id;
	
	
	@Column(name = "favorite_title")
	private String favourite_title;
	
	public String getFavourite_title() {
		return favourite_title;
	}


	public Favourite(String favourite_title, Set<Product1> products, User user) {
		super();
		this.favourite_title = favourite_title;
		this.products = products;
		this.user = user;
	}


	public void setFavourite_title(String favourite_title) {
		this.favourite_title = favourite_title;
	}


	public Favourite(Long favourite_id, String favourite_title, Set<Product1> products, User user) {
		super();
		this.favourite_id = favourite_id;
		this.favourite_title = favourite_title;
		this.products = products;
		this.user = user;
	}


	@JsonManagedReference
	@OneToMany(mappedBy = "favourite",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Product1> products ;
	
	
	
	 @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	    @JsonIdentityReference(alwaysAsId = true)
	@OneToOne( cascade = CascadeType.ALL)
   // @MapsId
   // @JoinColumn(name = "user_id")
	private User user;


	public Favourite() {
		super();
	}


	public Favourite(Long favourite_id, Set<Product1> products, User user) {
		super();
		this.favourite_id = favourite_id;
		this.products = products;
		this.user = user;
	}


	public Favourite(Set<Product1> products, User user) {
		super();
		this.products = products;
		this.user = user;
	}


	public Long getFavourite_id() {
		return favourite_id;
	}


	public void setFavourite_id(Long favourite_id) {
		this.favourite_id = favourite_id;
	}


	public Set<Product1> getProducts() {
		return products;
	}


	public void setProducts(Set<Product1> products) {
		this.products = products;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	
	
	

}
