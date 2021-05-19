package com.project0.esprit.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="stock")
public class Stock extends AuditModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	private int amount;
	@JsonIgnore
	@OneToMany( mappedBy="stock",cascade = CascadeType.ALL)
	private Set<Product1> product;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Set<Product1> getProduct() {
		return product;
	}
	public void setProduct(Set<Product1> product) {
		this.product = product;
	}
	public Stock(Long id, int amount, Set<Product1> product) {
		super();
		this.id = id;
		this.amount = amount;
		this.product = product;
	}
	public Stock(int amount, Set<Product1> product) {
		super();
		this.amount = amount;
		this.product = product;
	}
	public Stock() {
		super();
	}
	
	
	
}
