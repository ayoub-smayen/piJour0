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

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profit_id;
	
	@Column(name="outcome")
	private Double outcome ;
	
	@Column(name="income")     
	private Double income ;
	
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Profit() {
		super();
	}

	@Column(name="salary")
	private Double salary ;

	public Profit(Long profit_id, Double outcome, Double income, Double salary) {
		super();
		this.profit_id = profit_id;
		this.outcome = outcome;
		this.income = income;
		this.salary = salary;
	}
	
}
