package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * 
 * 
 *  1 --  publicty  conteient n mony product
 * 
 * 
 */

@Entity
@Table(name="publicity")
public class Publicity extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long publicity_id;
	
	@Column(name="publictyname")
	private String publictyname;
	
	@Column(name="publictytag")
	private String publictytag;
	
	
	public Publicity(Long publicity_id, String publictyname, String publictytag, String publictyBody,
			Set<Product1> products) {
		super();
		this.publicity_id = publicity_id;
		this.publictyname = publictyname;
		this.publictytag = publictytag;
		this.publictyBody = publictyBody;
		this.products = products;
	}

	public Long getPublicity_id() {
		return publicity_id;
	}

	public void setPublicity_id(Long publicity_id) {
		this.publicity_id = publicity_id;
	}
	@Column(name="publictybody")
	private String publictyBody;
	
	public Publicity() {
		super();
	}

	public Publicity(String publictyname, String publictytag, String publictyBody, Set<Product1> products) {
		super();
		this.publictyname = publictyname;
		this.publictytag = publictytag;
		this.publictyBody = publictyBody;
		this.products = products;
	}
  @JsonIgnore
	@OneToMany(mappedBy = "publicity", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Product1> products;

	public String getPublictyname() {
		return publictyname;
	}

	public void setPublictyname(String publictyname) {
		this.publictyname = publictyname;
	}

	public String getPublictytag() {
		return publictytag;
	}

	public void setPublictytag(String publictytag) {
		this.publictytag = publictytag;
	}

	public String getPublictyBody() {
		return publictyBody;
	}

	public void setPublictyBody(String publictyBody) {
		this.publictyBody = publictyBody;
	}

	public Set<Product1> getProducts() {
		return products;
	}

	public void setProducts(Set<Product1> products) {
		this.products = products;
	}
	
	
	
	
	

}
