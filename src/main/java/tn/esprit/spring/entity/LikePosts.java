package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class LikePosts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int like_id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column
	private boolean isLiked;
	@JsonIgnore
	@ManyToOne
	private Publication pub;
	public LikePosts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	public Publication getPub() {
		return pub;
	}
	public void setPub(Publication pub) {
		this.pub = pub;
	}
	public LikePosts(int like_id, User user, boolean isLiked, Publication pub) {
		super();
		this.like_id = like_id;
		this.user = user;
		this.isLiked = isLiked;
		this.pub = pub;
	}
	public LikePosts(User user, boolean isLiked, Publication pub) {
		super();
		this.user = user;
		this.isLiked = isLiked;
		this.pub = pub;
	}
	
	
	
	

}
