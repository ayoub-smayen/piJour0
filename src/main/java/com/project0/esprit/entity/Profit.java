package com.project0.esprit.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="profit")
public class Profit extends AuditModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profit_id;
	
	@Column(name="income")     
	private Double income ;
	
	@Column(name="outcome")
	private Double outcome ;
	
	@Column(name="margins")
	private Double margins ;
	
	@Column(name="month")
	private String month ;
	
	
	

	/*@OneToOne(mappedBy = "profit", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Admin admin;*/
	
	
	public Profit() {
		super();
	}


	public Profit(Double outcome, String month, Double income, Double margins) {
		super();
		this.outcome = outcome;
		this.month = month;
		this.income = income;
		this.margins = margins;
	}

	public Profit(Long profit_id, Double outcome, String month, Double income, Double margins) {
		super();
		this.profit_id = profit_id;
		this.outcome = outcome;
		this.month = month;
		this.income = income;
		this.margins = margins;
	}

	public Double getMargins() {
		return margins;
	}

	public void setMargins(Double margins) {
		this.margins = margins;
	}


	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}


	
	public Long getProfit_id() {
		return profit_id;
	}

	public void setProfit_id(Long profit_id) {
		this.profit_id = profit_id;
	}

	public Double getOutcome() {
		return outcome;
	}

	public void setOutcome(Double outcome) {
		this.outcome = outcome;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}


	
	
	}

	

	

	

	

	
	

