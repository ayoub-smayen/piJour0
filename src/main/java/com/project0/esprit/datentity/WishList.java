package com.project0.esprit.datentity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project0.esprit.entity.AuditModel;
import com.project0.esprit.entity.Product1;


@Entity
@Table(name="wishlist")
public class WishList  extends AuditModel {
	
	
	public WishList(String wishlist_title, String wishlist_body, User user, Set<Product1> products) {
		super();
		this.wishlist_title = wishlist_title;
		this.wishlist_body = wishlist_body;
		this.user3 = user;
		this.products = products;
	}

	public WishList() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWishlist_title() {
		return wishlist_title;
	}

	public void setWishlist_title(String wishlist_title) {
		this.wishlist_title = wishlist_title;
	}

	public String getWishlist_body() {
		return wishlist_body;
	}

	public void setWishlist_body(String wishlist_body) {
		this.wishlist_body = wishlist_body;
	}

	public User getUser() {
		return user3;
	}

	public void setUser(User user) {
		this.user3 = user;
	}

	public Set<Product1> getProducts() {
		return products;
	}

	public void setProducts(Set<Product1> products) {
		this.products = products;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="wishlist_title")
	private String wishlist_title;
	
	@Column(name="wishlist_body")
	private String wishlist_body;

	
	 public WishList(Long id, String wishlist_title, String wishlist_body, User user, Set<Product1> products) {
		super();
		this.id = id;
		this.wishlist_title = wishlist_title;
		this.wishlist_body = wishlist_body;
		this.user3 = user;
		this.products = products;
	}

	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	    @JsonIdentityReference(alwaysAsId = true)
	    @ManyToOne
	    private User user3;
	 
	 @OneToMany(mappedBy = "wishlist", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Product1> products;
}
