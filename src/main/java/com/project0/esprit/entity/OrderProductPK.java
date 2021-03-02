package com.project0.esprit.entity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*
import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class OrderProductPK {

	 @JsonBackReference
	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JoinColumn(name = "order_id")
	    private Order order;

	    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public OrderProductPK() {
		super();
	}

	public OrderProductPK(Order order, Product product) {
		super();
		this.order = order;
		this.product = product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

		@ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JoinColumn(name = "product_id")
	    private Product product;
}
*/