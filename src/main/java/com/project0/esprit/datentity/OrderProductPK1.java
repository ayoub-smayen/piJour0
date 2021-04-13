package com.project0.esprit.datentity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project0.esprit.entity.Product1;
/*
@Embeddable
public class OrderProductPK1 implements Serializable{
	 @JsonBackReference
	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JoinColumn(name = "order_id")
	    private Lorder order;

	    public Lorder getOrder() {
		return order;
	}

	public OrderProductPK1() {
			super();
		}

	public void setOrder(Lorder order) {
		this.order = order;
	}

	public Product1 getProduct() {
		return product;
	}

	public void setProduct(Product1 product) {
		this.product = product;
	}

		public OrderProductPK1(Lorder order, Product1 product) {
		super();
		this.order = order;
		this.product = product;
	}

		@ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JoinColumn(name = "product_id")
	    private Product1 product;
}
*/