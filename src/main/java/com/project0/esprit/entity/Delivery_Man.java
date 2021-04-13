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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="delivey_man")
public class Delivery_Man {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long deliveryMan_id;
	@NotNull(message = "deliveryMan_Name required.")
	@Column(name="deliveryMan_Name")
	private String deliveryMan_Name ;
	
	public Delivery_Man() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Column(name="transport")
	@NotNull(message = "transport required.")
    private String transport;
	public Delivery_Man(Long deliveryMan_id, String deliveryMan_Name, String transport, String deliveryMan_lastName,
			String email, Integer workLoad) {
		super();
		this.deliveryMan_id = deliveryMan_id;
		this.deliveryMan_Name = deliveryMan_Name;
		this.transport = transport;
		this.deliveryMan_lastName = deliveryMan_lastName;
		this.email = email;
		this.workLoad = workLoad;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}



	@Column(name="deliveryMan_lastname")
	@NotNull(message = "transport required.")
	private String deliveryMan_lastName  ;
	
	public Long getDeliveryMan_id() {
		return deliveryMan_id;
	}

	public void setDeliveryMan_id(Long deliveryMan_id) {
		this.deliveryMan_id = deliveryMan_id;
	}

	public String getDeliveryMan_Name() {
		return deliveryMan_Name;
	}

	public void setDeliveryMan_Name(String deliveryMan_Name) {
		this.deliveryMan_Name = deliveryMan_Name;
	}

	public String getDeliveryMan_lastName() {
		return deliveryMan_lastName;
	}

	public void setDeliveryMan_lastName(String deliveryMan_lastName) {
		this.deliveryMan_lastName = deliveryMan_lastName;
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



	@NotNull(message = "email required.")
	@Column(name="email")
	private String email  ;
	
	
	@Column(name="workload")
	@NotNull(message = "workLoad required.")
	private Integer workLoad ;

	@JsonIgnore
	@OneToMany(mappedBy = "liv", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Orders0> orders;
	
}
