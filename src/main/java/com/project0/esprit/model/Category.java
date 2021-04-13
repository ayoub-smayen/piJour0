package com.project0.esprit.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project0.esprit.entity.AuditModel;

@Entity
@Table(name = "categories", catalog = "shopping_cart_db")
public class Category  extends AuditModel {

	private Integer idCategory;
	private String description;
	private String categoryName;
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryNam) {
		this.categoryName = categoryNam;
	}

	public Category(String description, String categoryName, List<Product> products) {
		super();
		this.description = description;
		this.categoryName = categoryName;
		this.products = products;
	}

	private List<Product> products = new ArrayList<Product>();

	public Category() {
	}

	public Category(String description) {
		this.description = description;
	}

	public Category(String description, List<Product> products) {
		this.description = description;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idcategory", unique = true, nullable = false)
	public Integer getIdcategory() {
		return this.idCategory;
	}

	public void setIdcategory(Integer idcategory) {
		this.idCategory = idcategory;
	}

	@Column(name = "description", nullable = false, length = 20)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@Cascade(CascadeType.SAVE_UPDATE)
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> productses) {
		this.products = productses;
	}

}
