package com.project0.esprit.entity;

import javax.persistence.Column;
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
@Table(name="product")
public class Product extends AuditModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	
	@Column(name="productname")
	private String productname ;
	
	@Column(name="productdescription")
	private String productdescription  ;
	@Column(name="quantity")
	private Integer Quantity  ;
	@Column(name="price")
	private Double price  ;
	@Column(name="brand")
	private String Brand ;
	
	@Column(name="productimg")
	private byte[] ProductImg;
	
	 public Product() {
		super();
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public byte[] getProductImg() {
		return ProductImg;
	}

	public void setProductImg(byte[] productImg) {
		ProductImg = productImg;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "category_id", nullable = false)
	    private Category category;

	public Product(Long product_id, String productname, String productdescription, Integer quantity, Double price,
			String brand, byte[] productImg, Category category) {
		super();
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		ProductImg = productImg;
		this.category = category;
	}
	
	
	
	

}
