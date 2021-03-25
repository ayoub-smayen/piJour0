package com.project0.esprit.datentity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_book")
public class Book {

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public byte[] getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(byte[] imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isActive() {
		return active;
	}
	public Book(Long id, String sku, String name, String description, BigDecimal unitPrice, byte[] imageUrl,
			boolean active, int unitsInStock, BookCategory category) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.active = active;
		this.unitsInStock = unitsInStock;
		this.bookcategory = category;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Book() {
		super();
	}
	public Book(String sku, String name, String description, BigDecimal unitPrice, byte[] imageUrl, boolean active,
			int unitsInStock, BookCategory category) {
		super();
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.active = active;
		this.unitsInStock = unitsInStock;
		this.bookcategory = category;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public BookCategory getCategory() {
		return bookcategory;
	}
	public void setCategory(BookCategory category) {
		this.bookcategory = category;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String sku;
	
	private String name;
	
	private String description;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Lob
	@Column(name="image_url")
	private byte[] imageUrl;
	
	private boolean active;
	
	@Column(name="units_in_stock")
	private int unitsInStock;
	/*
	@Column(name="date_created")
	private Date createdOn;
	
	@Column(name="last_updated")
	private Date updatedOn;
*/
	@ManyToOne
	@JoinColumn(name="book_category_id", nullable=true)
	private BookCategory bookcategory;
}
