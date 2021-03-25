package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class Orders  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	
	@Column(name="ordername")
	private String ordername ;
	
	public Orders(Long order_id, String ordername, String point, String typepay, Set<Product1> products) {
		super();
		this.order_id = order_id;
		this.ordername = ordername;
		this.point = point;
		this.typepay = typepay;
		this.products = products;
	}

	public Orders() {
		super();
	}

	@Column(name="point")
	private String point;
	
	@Column(name="typepay")
	private String typepay;
	
	@JsonIgnore
	@OneToMany(mappedBy = "orders", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Product1> products;

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getTypepay() {
		return typepay;
	}

	public void setTypepay(String typepay) {
		this.typepay = typepay;
	}

	public Set<Product1> getProducts() {
		return products;
	}

	public void setProducts(Set<Product1> products) {
		this.products = products;
	}
    

}
