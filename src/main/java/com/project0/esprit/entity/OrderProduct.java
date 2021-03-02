package com.project0.esprit.entity;

import java.util.Set;
/*
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orderproduct")
public class OrderProduct {

	@EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = false)
	private Integer quantity;

    // default constructor
    @JsonIgnore
	@OneToMany(mappedBy = "orderproduct", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<OrderProductPK> ordersproduct;
    public OrderProduct(Order order, Product product, Integer quantity) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    public OrderProduct() {
		super();
	}

	public OrderProduct(OrderProductPK pk, Integer quantity) {
		super();
		this.pk = pk;
		this.quantity = quantity;
	}

	public OrderProductPK getPk() {
		return pk;
	}

	public void setPk(OrderProductPK pk) {
		this.pk = pk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }
}
*/