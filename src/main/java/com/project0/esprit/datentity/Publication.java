package com.project0.esprit.datentity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/*
 * 
 * salim forum publication
 */

import com.project0.esprit.entity.AuditModel;

@Entity
@Table(name="publication")
public class Publication extends AuditModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="publication_txt")
	private String publication_txt;
	
	
	
	/*@OneToMany(mappedBy = "publicityfk",cascade=CascadeType.ALL)
	private List<Comments> comments;
	*/
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
   // @JsonIgnore
    private User user2;

    @JsonManagedReference
	@JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "publication")
    private List<Comments> comments ;
	


	public List<Comments> getComments() {
		return comments;
	}



	public Publication(Long id, String publication_txt, User user2, List<Comments> comments) {
		super();
		this.id = id;
		this.publication_txt = publication_txt;
		this.user2 = user2;
		this.comments = comments;
	}



	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Publication(Long id, String publication_txt, User user2) {
		super();
		this.id = id;
		this.publication_txt = publication_txt;
		this.user2 = user2;
	}



	public Publication(String publication_txt, User user2) {
		super();
		this.publication_txt = publication_txt;
		this.user2 = user2;
	}



	@Override
	public String toString() {
		return "Publication [id=" + id + ", publication_txt=" + publication_txt + ", user2=" + user2 + "]";
	}



	public String getPublication_txt() {
		return publication_txt;
	}



	public void setPublication_txt(String publication_txt) {
		this.publication_txt = publication_txt;
	}



	public Publication() {
		super();
	}



	public User getUser() {
		return user2;
	}



	public void setUser(User user2) {
		this.user2 = user2;
	}

}
