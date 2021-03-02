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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category")
public class Category extends AuditModel {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	
	@Column(name="categoryname")
	private String categoryName ;
	
	@Column(name="tags")
	private String tags  ;
	
	@Column(name="categorytype")
	private String categoryType;
	
	 public Category() {
		super();
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Category(Long category_id, String categoryName, String tags, String categoryType, Set<Product> products) {
		super();
		this.category_id = category_id;
		this.categoryName = categoryName;
		this.tags = tags;
		this.categoryType = categoryType;
		this.products = products;
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

	public Set<Product> getProducts() {
		return products;
	}

	public Category(Long category_id, String categoryName, String tags, String categoryType, Set<Product> products,
			Ray ray) {
		super();
		this.category_id = category_id;
		this.categoryName = categoryName;
		this.tags = tags;
		this.categoryType = categoryType;
		this.products = products;
		this.ray = ray;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
    @JsonIgnore
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Product> products;
    
    
    
    @JsonIgnore
   	@ManyToOne(fetch = FetchType.LAZY, optional = false)
   	    @JoinColumn(name = "ray_id", nullable = false)
   	    private Ray ray;

	
	

}
