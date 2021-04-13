package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User1 extends AuditModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	@ColumnDefault("0")
	//@Column(name="role",columnDefinition = "int  default 2 ")
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Column(name="firstname")
	private String membre_username ;
	
	public User1(Long user_id, Role role, String membre_username, String password, String confirm_password, String email,
			String group, String city, String address, String phone_number, Set<Messages> message) {
		super();
		this.user_id = user_id;
		this.role = role;
		this.membre_username = membre_username;
		this.password = password;
		this.confirm_password = confirm_password;
		this.email = email;
		this.group = group;
		this.city = city;
		this.address = address;
		this.phone_number = phone_number;
		this.message = message;
	}
	@Column(name="password")
	private String password  ;
	
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
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Messages> message;
	
	
	
	
	public User1(Long user_id, String membre_username, String password, String confirm_password, String email,
			String group, String city, String address, String phone_number, Set<Messages> message) {
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
		this.message = message;
	}
	
	public Set<Messages> getMessage() {
		return message;
	}
	public void setMessage(Set<Messages> message) {
		this.message = message;
	}
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
	
	
	public User1() {
		super();
	}
	public User1(Long user_id, String membre_username, String password, String confirm_password, String email,
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

	
	
	
}
