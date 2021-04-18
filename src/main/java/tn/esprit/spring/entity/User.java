package tn.esprit.spring.entity;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table
public class User extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int user_id;
	@Column
	private String user_name;
	@Column
	private String user_Lastname;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Publication> publication_id;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Comments> comments;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<LikePosts> like_posts;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<LikeComments> like_comments;
	
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	@JsonIgnore
	public List<Publication> getPublication_id() {
		return publication_id;
	}
	public void setPublication_id(List<Publication> publication_id) {
		this.publication_id = publication_id;
	}
	
	
	public User(int user_id, String user_name, String user_Lastname, List<Publication> publication_id,
			List<Comments> comments, List<LikePosts> like) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_Lastname = user_Lastname;
		this.publication_id = publication_id;
		this.comments = comments;
		this.like_posts = like;
	}
	public User(String user_name, String user_Lastname, List<Publication> publication_id, List<Comments> comments) {
		super();
		this.user_name = user_name;
		this.user_Lastname = user_Lastname;
		this.publication_id = publication_id;
		this.comments = comments;
	}
	public User(int user_id, String user_name, String user_Lastname, List<Publication> publication_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_Lastname = user_Lastname;
		this.publication_id = publication_id;
	}
	
	public User(int user_id, String user_name, String user_Lastname) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_Lastname = user_Lastname;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_Lastname() {
		return user_Lastname;
	}
	public void setUser_Lastname(String user_Lastname) {
		this.user_Lastname = user_Lastname;
	}
	public User(int user_id, String user_name, String user_Lastname, List<Publication> publication_id,
			List<Comments> comments) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_Lastname = user_Lastname;
		this.publication_id = publication_id;
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_Lastname == null) ? 0 : user_Lastname.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_Lastname == null) {
			if (other.user_Lastname != null)
				return false;
		} else if (!user_Lastname.equals(other.user_Lastname))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}
	public List<LikePosts> getLike_posts() {
		return like_posts;
	}
	public void setLike_posts(List<LikePosts> like_posts) {
		this.like_posts = like_posts;
	}
	public List<LikeComments> getLike_comments() {
		return like_comments;
	}
	public void setLike_comments(List<LikeComments> like_comments) {
		this.like_comments = like_comments;
	}
	public User(String user_name, String user_Lastname, List<Publication> publication_id, List<Comments> comments,
			List<LikePosts> like_posts, List<LikeComments> like_comments) {
		super();
		this.user_name = user_name;
		this.user_Lastname = user_Lastname;
		this.publication_id = publication_id;
		this.comments = comments;
		this.like_posts = like_posts;
		this.like_comments = like_comments;
	}
	
	
	
	
	
}
