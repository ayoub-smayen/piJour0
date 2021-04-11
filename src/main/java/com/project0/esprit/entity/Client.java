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
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long client_id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private int phone_number;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column
	@Embedded
	private Shop shop2;

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy= "client", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
	private Set<Claim> claims;

	/**
	 * @param client_id
	 * @param email
	 * @param phone_number
	 * @param firstName
	 * @param lastName
	 * @param shop2
	 * @param claims
	 */
	public Client(Long client_id, String email, int phone_number, String firstName, String lastName, Shop shop2,
			Set<Claim> claims) {
		super();
		this.client_id = client_id;
		this.email = email;
		this.phone_number = phone_number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.shop2 = shop2;
		this.claims = claims;
	}
}
