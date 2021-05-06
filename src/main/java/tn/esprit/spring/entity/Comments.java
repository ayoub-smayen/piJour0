package tn.esprit.spring.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Comments extends AuditModel {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String Comment_field;
	private int like_count = 0;
	private int dislike_count = 0;
	
	@ManyToOne
	private User user;
	@JsonIgnore
	@ManyToOne
	private Publication pub_id;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int id, String comment_field, int like_count, int dislike_count, User user, Publication pub_id) {
		super();
		this.id = id;
		Comment_field = comment_field;
		this.like_count = like_count;
		this.dislike_count = dislike_count;
		this.user = user;
		this.pub_id = pub_id;
	}
	public Comments(String comment_field, int like_count, int dislike_count, User user, Publication pub_id) {
		super();
		Comment_field = comment_field;
		this.like_count = like_count;
		this.dislike_count = dislike_count;
		this.user = user;
		this.pub_id = pub_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment_field() {
		return Comment_field;
	}
	public void setComment_field(String comment_field) {
		Comment_field = comment_field;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public int getDislike_count() {
		return dislike_count;
	}
	public void setDislike_count(int dislike_count) {
		this.dislike_count = dislike_count;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Publication getPub_id() {
		return pub_id;
	}
	public void setPub_id(Publication pub_id) {
		this.pub_id = pub_id;
	}
	
	
	
	

}
