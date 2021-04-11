package com.project0.esprit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Product_id;
	
	public Dimension getDimension() {
		return dimension;
	}


	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	@Column(name="weight")
    private float weight;
	
	@Embedded
	@Column(name="dimension")
    private Dimension dimension;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="order_id",nullable=true )
	private Order order ;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Product(Long product_id, float weight, Dimension dimension) {
		super();
		Product_id = product_id;
		this.weight = weight;
		this.dimension = dimension;
	}






	public Long getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(Long product_id) {
		Product_id = product_id;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	


}
