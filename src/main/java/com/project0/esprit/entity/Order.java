package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "orders")
public class Order  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	
	@Column(name="dispoOrder")
	private Boolean dispoOrder;
	
	
	public Order(Long order_id, Boolean dispoOrder, int quantity) {
		super();
		this.order_id = order_id;
		this.dispoOrder = dispoOrder;
		this.quantity = quantity;
	}

	@Column(name="quantity")
	private int quantity;
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	







	public Boolean getDispoOrder() {
		return dispoOrder;
	}







	public void setDispoOrder(Boolean dispoOrder) {
		this.dispoOrder = dispoOrder;
	}









	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "deliveryMan_id", nullable = false)
	    private Delivery_Man liv;*/
	
	@OneToMany(mappedBy= "order", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
	private Set<Product> product;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			  name = "order_livreur", 
			  joinColumns = @JoinColumn(name = "order_id"), 
			  inverseJoinColumns = @JoinColumn(name = "deliveryMan_id"))
	private Set<Delivery_Man> deliv;
	
	
	

}
