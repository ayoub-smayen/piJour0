package com.project0.esprit.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.project0.esprit.entity.AuditModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products", catalog = "shopping_cart_db")
public class Product extends AuditModel {

	private Long idProduct;
	private Category category;
	private String description;
	private BigDecimal price;
	private List<LineItem> linesItems = new ArrayList<LineItem>();

	public Product() {
	}

	public Product(String description, BigDecimal price) {
		this.description = description;
		this.price = price;
	}

	public Product(Category category, String description, BigDecimal price, List<LineItem> linesItems) {
		this.category = category;
		this.description = description;
		this.price = price;
		this.linesItems = linesItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idproduct", unique = true, nullable = false)
	public Long getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategory")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name="brand")
	private String Brand ;
	
	@Column(name="prix")
	private Double prix ;
	@Column(name="codebar")
	private String codeBar ;
	
	public String getBrand() {
		return Brand;
	}

	public Product(Category category, String description, BigDecimal price, List<LineItem> linesItems, String brand,
			Double prix, String codeBar, byte[] productImg) {
		super();
		this.category = category;
		this.description = description;
		this.price = price;
		this.linesItems = linesItems;
		Brand = brand;
		this.prix = prix;
		this.codeBar = codeBar;
		ProductImg = productImg;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getCodeBar() {
		return codeBar;
	}

	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}

	public byte[] getProductImg() {
		return ProductImg;
	}

	public void setProductImg(byte[] productImg) {
		ProductImg = productImg;
	}
    @Lob
	@Column(name="productimg")
	private byte[] ProductImg;
	

	
	@Column(name = "description", nullable = false, length = 100)
	public String getDescription() {
		return this.description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price", nullable = false, precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<LineItem> getLinesItems() {
		return this.linesItems;
	}

	public void setLinesItems(List<LineItem> linesItems) {
		this.linesItems = linesItems;
	}

}
