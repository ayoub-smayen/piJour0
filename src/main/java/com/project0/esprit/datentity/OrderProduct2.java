package com.project0.esprit.datentity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project0.esprit.entity.Product1;
/*
@Entity
@Table(name="order_prod")
public class OrderProduct2 {
	@EmbeddedId
    @JsonIgnore
    private OrderProductPK1 pk;

    @Column(nullable = false)
	private Integer quantity;

    // default constructor

    public OrderProductPK1 getPk() {
		return pk;
	}

	public void setPk(OrderProductPK1 pk) {
		this.pk = pk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderProduct2(Lorder order, Product1 product, Integer quantity) {
        pk = new OrderProductPK1();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    @Transient
    public Product1 getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }
}
*/
