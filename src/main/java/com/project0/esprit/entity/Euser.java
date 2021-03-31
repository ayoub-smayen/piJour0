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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Entity
@Table(name="euser")
public class Euser extends AuditModel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@Column(name="firstname")
	private String membre_username ;
	@NotNull(message="firstname is required")
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
	@NotNull(message="password is required")
	public Euser() {
		super();
	}



	@Column(name="confirmpassword")
	@NotNull(message="confirmpassword is required")
	private String confirm_password  ;
	
	@Column(name="email")
	@NotNull(message="email is required")
	@Email
	private String email  ;
	
	@Column(name="groups")
	@NotNull(message="groups is required")
	private String group ;
	
	@Column(name="city")
	@NotNull(message="city is required")
	private String city  ;
	
	

	public Euser(Long user_id, String membre_username, String password,
			@NotNull(message = "confirmpassword is required") String confirm_password,
			@NotNull(message = "email is required") @Email String email,
			@NotNull(message = "groups is required") String group, @NotNull(message = "city is required") String city,
			String address,
			@NotNull(message = "phone is required") @Pattern(regexp = "[0-9] {8}") String phone_number) {
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

	@Column(name="address")
	private String address  ;
	@NotNull(message="phone is required")
	@Pattern(regexp = "[0-9] {8}")
	@Column(name="phonenumber")
	private String phone_number  ;
	@Column(name="age")
	private Integer age ;
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Euser(Long user_id, String membre_username, String password,
			@NotNull(message = "confirmpassword is required") String confirm_password,
			@NotNull(message = "email is required") @Email String email,
			@NotNull(message = "groups is required") String group, @NotNull(message = "city is required") String city,
			String address, @NotNull(message = "phone is required") @Pattern(regexp = "[0-9] {8}") String phone_number,
			Integer age) {
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
		this.age = age;
	}


	
	
	

}
