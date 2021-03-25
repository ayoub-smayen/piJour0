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



@Entity
@Table(name="euser")
public class Euser extends AuditModel{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@Column(name="firstname")
	private String membre_username ;
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getMembre_username() {
		return membre_username;
	}

	public void setMembre_username(String membre_username) {
		this.membre_username = membre_username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Column(name="password")
	private String password  ;
	
	public Euser() {
		super();
	}

	public Euser(Long user_id, String membre_username, String password, String confirm_password, String email,
			String group, String city, String address, String phone_number) {
		super();
		this.user_id = user_id;
		this.membre_username = membre_username;
		this.password = password;
		this.confirm_password = confirm_password;
		this.email = email;
		this.group = group;
		this.city = city;
		this.address = address;
		this.phone_number = phone_number;
	}

	@Column(name="confirmpassword")
	private String confirm_password  ;
	
	@Column(name="email")
	private String email  ;
	
	@Column(name="groups")
	private String group ;
	
	@Column(name="city")
	private String city  ;
	
	@Column(name="address")
	private String address  ;
	
	@Column(name="phonenumber")
	private String phone_number  ;

}
