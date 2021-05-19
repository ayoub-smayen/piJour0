package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="category")
public class Category1 extends AuditModel {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long category_id;
	
	@NotNull(message = "categoryname  is required.")
	
	@Column(name="categoryname")
	private String categoryName ;
	
	
	@NotNull(message = "categoryname name is required.")
	@Column(name="tags")
	private String tags  ;
	
	
	
	@NotNull(message = "categoryType name is required.")
	@Column(name="categorytype")
	private String categoryType;
	
	 
	
	public Category1(@NotNull(message = "categoryname  is required.") String categoryName,
			@NotNull(message = "categoryname name is required.") String tags,
			@NotNull(message = "categoryType name is required.") String categoryType, Set<Product1> products, Ray ray) {
		super();
		this.categoryName = categoryName;
		this.tags = tags;
		this.categoryType = categoryType;
		this.products = products;
		this.ray = ray;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Category1(Long category_id, String categoryName, String tags, String categoryType, Set<Product1> products) {
		super();
		this.category_id = category_id;
		this.categoryName = categoryName;
		this.tags = tags;
		this.categoryType = categoryType;
		this.products = products;
	}
	public Category1() {
		super();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public Ray getRay() {
		return ray;
	}

	public void setRay(Ray ray) {
		this.ray = ray;
	}

	public Set<Product1> getProducts() {
		return products;
	}

	

	public Category1(Long category_id, String categoryName, String tags, String categoryType, Set<Product1> products,
			Ray ray) {
		super();
		this.category_id = category_id;
		this.categoryName = categoryName;
		this.tags = tags;
		this.categoryType = categoryType;
		this.products = products;
		this.ray = ray;
	}

	public void setProducts(Set<Product1> products) {
		this.products = products;
	}
	
	//@JsonManagedReference(value = "cat1")
    @JsonIgnore
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Product1> products;
    
    
	//@JsonBackReference
    @JsonIgnore
   	@ManyToOne(fetch = FetchType.LAZY, optional = true)
   	    @JoinColumn(name = "ray_id", nullable = true)
   	    private Ray ray;

	
	

}
