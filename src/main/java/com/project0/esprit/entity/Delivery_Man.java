package com.project0.esprit.entity;


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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="delivey_man")
public class Delivery_Man {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long deliveryMan_id;
	
	@Column(name="dispoDeliv")
	private Boolean dispoDeliv;
	/**@Column(name="longitude")
	 double longitude ;
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	@Column(name="latitude")
	 double latitude  ;	**/
	
	@Embedded
	private Shop shop1  ;

	

	public Shop getShop1() {
		return shop1;
	}

	public void setShop1(Shop shop1) {
		this.shop1 = shop1;
	}


	@Size(max=6)
	@Column(name="deliveryMan_Name")
	private String deliveryMan_Name ;
	public Delivery_Man(Long deliveryMan_id, Boolean dispoDeliv, String deliveryMan_Name,
			String transport, String deliveryMan_lastName, String email, Integer workLoad) {
		super();
		this.deliveryMan_id = deliveryMan_id;
		this.dispoDeliv = dispoDeliv;
		this.deliveryMan_Name = deliveryMan_Name;
		//this.deliveryMan_photo = deliveryMan_photo;
		this.transport = transport;
		this.deliveryMan_lastName = deliveryMan_lastName;
		this.email = email;
		this.workLoad = workLoad;
	}



	/**@Column(name="deliveryMan_photo")
	private Byte deliveryMan_photo ;
	
	public Byte getDeliveryMan_photo() {
		return deliveryMan_photo;
	}

	public void setDeliveryMan_photo(Byte deliveryMan_photo) {
		this.deliveryMan_photo = deliveryMan_photo;
	}**/

	public Delivery_Man() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Column(name="transport")
    private String transport;

/*@Embedded
public Float getLength(){
	return length;
} */
	   
	
	
	 @Lob
	 
	  private byte[]  delivery_phot ; 
	 
	 
  
	public byte[] getDelivery_phot() {
		return delivery_phot;
	}

	public void setDelivery_phot(byte[] delivery_phot) {
		this.delivery_phot = delivery_phot;
	}

	public Set<Order> getOrd() {
		return ord;
	}

	public void setOrd(Set<Order> ord) {
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
	@ManyToMany(mappedBy = "deliv")
	Set<Order> ord;



	/**
	 * @param deliveryMan_id
	 * @param dispoDeliv
	 * @param shop1
	 * @param deliveryMan_Name
	 * @param deliveryMan_photo
	 * @param transport
	 * @param delivery_phot
	 * @param deliveryMan_lastName
	 * @param email
	 * @param workLoad
	 */
	
}
