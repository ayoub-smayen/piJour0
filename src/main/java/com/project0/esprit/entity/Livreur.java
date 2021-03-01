package com.project0.esprit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delivry")
public class Livreur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long delivrey_id;
	
	@Column(name="deliveryame")
	private String deliveryName ;
	
	@Column(name="deliverylastname")
	private String deliverylastName  ;
	
	@Column(name="location")
	private Location loc  ;
	
	@Column(name="email")
	private String email  ;
	
	@Column(name="workload")
	private Integer workLoad ;

	public Livreur() {
		super();
	}

	public Livreur(Long delivrey_id, String deliveryName, String deliverylastName, Location loc, String email,
			Integer workLoad) {
		super();
		this.delivrey_id = delivrey_id;
		this.deliveryName = deliveryName;
		this.deliverylastName = deliverylastName;
		this.loc = loc;
		this.email = email;
		this.workLoad = workLoad;
	}

	public Long getDelivrey_id() {
		return delivrey_id;
	}

	public void setDelivrey_id(Long delivrey_id) {
		this.delivrey_id = delivrey_id;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliverylastName() {
		return deliverylastName;
	}

	public void setDeliverylastName(String deliverylastName) {
		this.deliverylastName = deliverylastName;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(Integer workLoad) {
		this.workLoad = workLoad;
	}
}
