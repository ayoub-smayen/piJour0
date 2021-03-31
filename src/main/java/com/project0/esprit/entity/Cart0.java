package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project0.esprit.datentity.User;

@Entity
@Table(name="cart0")
public class Cart0 extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Cart;
	
	@NotNull(message = "SUBtotlal name is required.")
	private double Subtotal;
	
	//relation  between cart=>user
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	@ManyToOne
	@JsonBackReference
	//@JsonIgnore
	//@JoinColumn(name = "user_id" ,  nullable = true)
	private User user;
	
	//relation  between cart=>cartitem
   @OneToMany(mappedBy="cart")
   private Set<CartItem0> cartitem_list;
   

public Cart0(Long id_Cart, Double subtotal, User user, Set<CartItem0> cartitem_list) {
		super();
		Id_Cart = id_Cart;
		Subtotal = subtotal;
		this.user = user;
		this.cartitem_list = cartitem_list;
	}


public Cart0() {
	super();
}

public Long getId_Cart() {
	return Id_Cart;
}

public void setId_Cart(Long id_Cart) {
	Id_Cart = id_Cart;
}

public Double getSubtotal() {
	return Subtotal;
}

public void setSubtotal(Double subtotal) {
	Subtotal = subtotal;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Set<CartItem0> getCartitem_list() {
	return cartitem_list;
}

public void setCartitem_list(Set<CartItem0> cartitem_list) {
	this.cartitem_list = cartitem_list;
}
	
	
	

}

