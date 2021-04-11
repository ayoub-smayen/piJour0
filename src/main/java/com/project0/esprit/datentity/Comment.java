package com.project0.esprit.datentity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project0.esprit.entity.AuditModel;
import com.project0.esprit.entity.Product1;
import java.util.Set;
@Entity
@Table(name="comments")
public class Comment  extends AuditModel{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="title")
	private String Title;
	
	@Column(name="comment_body")
	private String BodyComment;
	
	
	@Lob
	@Column(name="comment_pic",nullable = true)
	private byte[] commentPic;
	
	
	
	@JsonBackReference
    //@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "product_id", nullable = true)
	    private Product1 product;

	
	
	
	 public Comment(String title, String bodyComment, byte[] commentPic, Product1 product, User user1) {
		super();
		Title = title;
		BodyComment = bodyComment;
		this.commentPic = commentPic;
		this.product = product;
		this.user1 = user1;
	}






	public Product1 getProduct() {
		return product;
	}






	public Comment(Long id, String title, String bodyComment, byte[] commentPic, Product1 product, User user1) {
		super();
		this.id = id;
		Title = title;
		BodyComment = bodyComment;
		this.commentPic = commentPic;
		this.product = product;
		this.user1 = user1;
	}






	public void setProduct(Product1 product) {
		this.product = product;
	}






	public Long getId() {
		return id;
	}


	

	

	public Comment(String title, String bodyComment, byte[] commentPic, User user) {
		super();
		Title = title;
		BodyComment = bodyComment;
		this.commentPic = commentPic;
		this.user1 = user;
	}


	public Comment() {
		super();
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Comment(Long id, String title, String bodyComment, byte[] commentPic, User user) {
		super();
		this.id = id;
		Title = title;
		BodyComment = bodyComment;
		this.commentPic = commentPic;
		this.user1 = user;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getBodyComment() {
		return BodyComment;
	}


	public void setBodyComment(String bodyComment) {
		BodyComment = bodyComment;
	}


	public byte[] getCommentPic() {
		return commentPic;
	}


	public void setCommentPic(byte[] commentPic) {
		this.commentPic = commentPic;
	}


	public User getUser() {
		return user1;
	}


	public void setUser(User user) {
		this.user1 = user;
	}


	    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	    @JsonIdentityReference(alwaysAsId = true)
	    @ManyToOne
	    private User user1;
	 

}
