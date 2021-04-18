package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class LikeComments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Like_id;
	@Column
	private boolean isLiked;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="com_id")
	private Comments com;
	@Enumerated(EnumType.STRING)
	private InteractionComments interactionType;
	public int getLike_id() {
		return Like_id;
	}
	public void setLike_id(int like_id) {
		Like_id = like_id;
	}
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	public Comments getPub() {
		return com;
	}
	public void setPub(Comments com) {
		this.com = com;
	}
	public InteractionComments getInteractionType() {
		return interactionType;
	}
	public void setInteractionType(InteractionComments interactionType) {
		this.interactionType = interactionType;
	}
	public LikeComments(int like_id, boolean isLiked, User user, Comments com, InteractionComments interactionType) {
		super();
		Like_id = like_id;
		this.isLiked = isLiked;
		this.user = user;
		this.com = com;
		this.interactionType = interactionType;
	}
	public LikeComments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
