package com.project0.esprit.datentity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="myprfile")
public class Myprofile implements   Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	/*public User getUser() {
		return user;
	}
*/

	/*public void setUser(User user) {
		this.user = user;
	}
*/

	@Column(name="firstname")
	private String firstname;
	
	
	@Column(name="lastname")
	private String lastname;
	
	
	@Lob
	@Column(name="photoprofile")
	private byte[] profilepic;

	/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@OneToOne(cascade=CascadeType.ALL)
	//(cascade=CascadeType.ALL)
	// @MapsId
	   // @JoinColumn(name = "user_id",cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName = "id",nullable = true)
	private User user;*/

	public Long getId() {
		return id;
	}


	/*public User getUsers() {
		return user;
	}


	public void setUsers(User users) {
		this.user = users;
	}

	public Myprofile(Long id, String firstname, String lastname, byte[] profilepic, User users) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilepic = profilepic;
		this.user = users;
	}
*/

	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Myprofile() {
		super();
	}


	public Myprofile( String firstname, String lastname, byte[] profilepic) {
		//super(username, password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilepic = profilepic;
	}
/*

	public Myprofile(String firstname, String lastname, byte[] profilepic, User user) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilepic = profilepic;
		this.user = user;
	}
*/

	public Myprofile( Long id, String firstname, String lastname, byte[] profilepic) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilepic = profilepic;
	}


	public byte[] getProfilepic() {
		return profilepic;
	}


	public void setProfilepic(byte[] profilepic) {
		this.profilepic = profilepic;
	}
	


}
