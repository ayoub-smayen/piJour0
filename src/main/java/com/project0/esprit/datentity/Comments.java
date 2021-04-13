package com.project0.esprit.datentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project0.esprit.entity.AuditModel;

/*
 * 
 * 
 * forum salim 
 */


@Entity
@Table(name="pcomments")
public class Comments  extends AuditModel {
	
	public Long getId() {
		return id;
	}



	public Comments(Long id, String comment_field, Publication publication, User user) {
		super();
		this.id = id;
		Comment_field = comment_field;
		this.publication = publication;
		this.user = user;
	}



	public Comments() {
		super();
	}



	public Comments(String comment_field, Publication publication, User user) {
		super();
		Comment_field = comment_field;
		this.publication = publication;
		this.user = user;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getComment_field() {
		return Comment_field;
	}



	public void setComment_field(String comment_field) {
		Comment_field = comment_field;
	}



	public Publication getPublication() {
		return publication;
	}



	public void setPublication(Publication publication) {
		this.publication = publication;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column
	private Long  id;
	
	
	@Column
	private String Comment_field;
	
	@JsonBackReference
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pub_id",nullable = true)
	private Publication publication;
	




	//@JsonBackReference
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
   // @JsonIgnore
    private User user;



	
	
	
	
	
	
}
