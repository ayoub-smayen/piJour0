package com.project0.esprit.datentity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_category")
public class BookCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="category_name")
	private String categoryName;
	
	public Long getId() {
		return id;
	}

	public BookCategory() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookCategory(String categoryName, Set<Book> book) {
		super();
		this.categoryName = categoryName;
		this.book = book;
	}

	public BookCategory(Long id, String categoryName, Set<Book> book) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.book = book;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="bookcategory")
	private Set<Book> book;
}
