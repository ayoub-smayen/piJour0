package com.project0.esprit.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dashboard")
public class Dashboard  extends AuditModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dashboard_id;
	@NotNull(message = "product_soldis required.")
	@Column(name="productsold")
	private Integer product_sold ;
	@Column(name="monthlypayment")
	
	
	private Float monthly_payment ;
	public Dashboard(Long dashboard_id, Integer product_sold, Float monthly_payment) {
		super();
		this.dashboard_id = dashboard_id;
		this.product_sold = product_sold;
		this.monthly_payment = monthly_payment;
	}
	public Long getDashboard_id() {
		return dashboard_id;
	}
	public void setDashboard_id(Long dashboard_id) {
		this.dashboard_id = dashboard_id;
	}
	public Integer getProduct_sold() {
		return product_sold;
	}
	public void setProduct_sold(Integer product_sold) {
		this.product_sold = product_sold;
	}
	public Float getMonthly_payment() {
		return monthly_payment;
	}
	public void setMonthly_payment(Float monthly_payment) {
		this.monthly_payment = monthly_payment;
	}
	public Dashboard() {
		super();
	}
	public Dashboard(Integer product_sold, Float monthly_payment) {
		super();
		this.product_sold = product_sold;
		this.monthly_payment = monthly_payment;
	
	}
	
	/*
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "dashboard")
	private List<Product1> best_product ;
	
	*/
	
	/*//onetomany
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "customer_id", referencedColumnName = "user_id")
	
	 private User customer ;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product best_product ;
	
	
	@OneToOne(mappedBy = "dashboard", fetch = FetchType.LAZY,   
	           cascade = CascadeType.ALL)
	private Admin admin;*/


	}
	
