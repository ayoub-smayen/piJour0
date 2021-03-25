package com.project0.esprit.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cartitem0")
public class CartItem0 extends AuditModel {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Item;
	
	private int Quantity;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="cart0_id")
	private Cart0 cart;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="product_id")
	private Product1 product;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="orders_id")
	private Orders orders;
	
	
        
	public CartItem0() {
		super();
	}

	public CartItem0(Long id_Item, int quantity, BigDecimal price, Cart0 cart, Product1 product, Orders orders) {
		super();
		Id_Item = id_Item;
		Quantity = quantity;
		this.cart = cart;
		this.product = product;
		this.orders = orders;
	}
	

	public CartItem0(int quantity, Cart0 cart, Product1 product, Orders orders) {
		super();
		Quantity = quantity;
		this.cart = cart;
		this.product = product;
		this.orders = orders;
	}
	
	
	@Transient
	private double getToltale(){
		return product.getPrice()*getQuantity()*getCart().getSubtotal();
	}

	
	public CartItem0(Long id_Item, int quantity) {
		super();
		Id_Item = id_Item;
		Quantity = quantity;
	}

	public CartItem0(int quantity) {
		super();
		Quantity = quantity;
	}

	public Long getId_Item() {
		return Id_Item;
	}

	public void setId_Item(Long id_Item) {
		Id_Item = id_Item;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Cart0 getCart() {
		return cart;
	}

	public void setCart(Cart0 cart) {
		this.cart = cart;
	}

	public Product1 getProduct() {
		return product;
	}

	public void setProduct(Product1 product) {
		this.product = product;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}

