package com.project0.esprit.datentity;




import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project0.esprit.entity.Claim;
import com.project0.esprit.entity.Orders;
import com.project0.esprit.entity.Shop;






@Entity
@Table(name="delivey_man0")
public class Delivery_man0 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long deliveryMan_id;
	
	@Column(name="dispoDeliv")
	private Boolean dispoDeliv= false;

	private double lati;
	
	private double lngi;
	
	@Embedded
	private Shop shop1  ;

	

	public Shop getShop1() {
		return shop1;
	}

	public void setShop1(Shop shop1) {
		this.shop1 = shop1;
	}

	@Column
	private String facebook;
	
	@Column
	private String rating;

	
	@Column(name="deliveryMan_Name")
	private String deliveryMan_Name ;
	



	

	

	@Column(name="salaire")
    private int salaire;

	@Column
	private String phoneNumber;


	@Column(name="transport")
    private String transport;


	   
	
	
	 @Lob
	 
	  private byte[]  delivery_phot ; 
	 
	 
  
	public byte[] getDelivery_phot() {
		return delivery_phot;
	}

	public void setDelivery_phot(byte[] delivery_phot) {
		this.delivery_phot = delivery_phot;
	}
@JsonIgnore
	public Set<Orders> getOrd() {
		return ord;
	}

	public void setOrd(Set<Orders> ord) {
		this.ord = ord;
	}

	
	

	public Boolean getDispoDeliv() {
		return dispoDeliv;
	}

	public void setDispoDeliv(Boolean dispoDeliv) {
		this.dispoDeliv = dispoDeliv;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}



	@Column(name="deliveryMan_lastname")
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



	@Email
	@Column(name="email")
	private String email  ;
	
	@Column(name="workload")
	private Integer workLoad ;

	/*@JsonIgnore
	@OneToMany(mappedBy = "liv", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Order> orders;*/
	@JsonIgnore
	@ManyToMany(mappedBy = "deliv")
	Set<Orders> ord;



	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	
	

	
	

	@OneToMany(mappedBy= "delivery_man", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
	private Set<Claim> claim;



	public Set<Claim> getClaim() {
		return claim;
	}

	public void setClaim(Set<Claim> claim) {
		this.claim = claim;
	}

	/**
	 * @param deliveryMan_id
	 * @param dispoDeliv
	 * @param lati
	 * @param lngi
	 * @param shop1
	 * @param deliveryMan_Name
	 * @param salaire
	 * @param transport
	 * @param delivery_phot
	 * @param deliveryMan_lastName
	 * @param email
	 * @param workLoad
	 * @param ord
	 * @param claim
	 */
	

	public double getLati() {
		return lati;
	}

	public void setLati(double lati) {
		this.lati = lati;
	}

	public double getLngi() {
		return lngi;
	}

	public void setLngi(double lngi) {
		this.lngi = lngi;
	}

	/**
	 * @param deliveryMan_id
	 * @param dispoDeliv
	 * @param lati
	 * @param lngi
	 * @param shop1
	 * @param deliveryMan_Name
	 * @param salaire
	 * @param phoneNumber
	 * @param transport
	 * @param delivery_phot
	 * @param deliveryMan_lastName
	 * @param email
	 * @param workLoad
	 * @param ord
	 * @param claim
	 */
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @param deliveryMan_id
	 * @param dispoDeliv
	 * @param lati
	 * @param lngi
	 * @param shop1
	 * @param facebook
	 * @param rating
	 * @param deliveryMan_Name
	 * @param salaire
	 * @param phoneNumber
	 * @param transport
	 * @param delivery_phot
	 * @param deliveryMan_lastName
	 * @param email
	 * @param workLoad
	 * @param ord
	 * @param claim
	 */
	public Delivery_man0(Long deliveryMan_id, Boolean dispoDeliv, double lati, double lngi, Shop shop1, String facebook,
			String rating, String deliveryMan_Name, int salaire, String phoneNumber, String transport,
			byte[] delivery_phot, String deliveryMan_lastName, @Email String email, Integer workLoad, Set<Orders> ord,
			Set<Claim> claim) {
		super();
		this.deliveryMan_id = deliveryMan_id;
		this.dispoDeliv = dispoDeliv;
		this.lati = lati;
		this.lngi = lngi;
		this.shop1 = shop1;
		this.facebook = facebook;
		this.rating = rating;
		this.deliveryMan_Name = deliveryMan_Name;
		this.salaire = salaire;
		this.phoneNumber = phoneNumber;
		this.transport = transport;
		this.delivery_phot = delivery_phot;
		this.deliveryMan_lastName = deliveryMan_lastName;
		this.email = email;
		this.workLoad = workLoad;
		this.ord = ord;
		this.claim = claim;
	}

	/**
	 * @param deliveryMan_id
	 * @param dispoDeliv
	 * @param lati
	 * @param lngi
	 * @param shop1
	 * @param facebook
	 * @param rating
	 * @param deliveryMan_Name
	 * @param salaire
	 * @param phoneNumber
	 * @param transport
	 * @param delivery_phot
	 * @param deliveryMan_lastName
	 * @param email
	 * @param workLoad
	 * @param ord
	 * @param claim
	 */
	
	
	

}
