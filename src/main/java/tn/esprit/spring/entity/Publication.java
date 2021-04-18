package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="publication")
public class Publication extends AuditModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	private String title;
	@Column
	private String publication_txt;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user", nullable=false)
	private User user;
	@Lob
	private byte[] pic;
	@OneToMany(mappedBy="pub",cascade=CascadeType.ALL)
	private List<LikePosts> likes;
	
	
	
	
	public Publication(String publication_txt, User user, List<LikePosts> likes, List<Comments> comments) {
		super();
		this.publication_txt = publication_txt;
		this.user = user;
		this.likes = likes;
		this.comments = comments;
	}









	public List<LikePosts> getLikes() {
		return likes;
	}









	public void setLikes(List<LikePosts> likes) {
		this.likes = likes;
	}









	public Publication(String publication_txt, User user, List<Comments> comments) {
		super();
		this.publication_txt = publication_txt;
		
		this.user = user;
		this.comments = comments;
	}




	




	public Publication(int id, String publication_txt, User user, List<Comments> comments) {
		super();
		this.id = id;
		this.publication_txt = publication_txt;
		this.user = user;
		this.comments = comments;
	}


	
	@OneToMany(mappedBy = "pub_id",cascade=CascadeType.ALL)
	private List<Comments> comments;
	public Publication(int publication_id, String publication_txt, User user_id) {
		super();
		this.id = publication_id;
		this.publication_txt = publication_txt;
		
		this.user = user;
		
	}
	
	


	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getPublication_txt() {
		return publication_txt;
	}
	public void setPublication_txt(String publication_txt) {
		this.publication_txt = publication_txt;
	}
	public List<Comments> getComments() {
		return comments;
	}



	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}


	

	


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}









	public int getId() {
		return id;
	}









	public void setId(int id) {
		this.id = id;
	}









	public byte[] getPic() {
		return pic;
	}









	public void setPic(byte[] pic) {
		this.pic = pic;
	}









	public Publication(int id, String publication_txt, User user, byte[] pic, List<LikePosts> likes,
			List<Comments> comments) {
		super();
		this.id = id;
		this.publication_txt = publication_txt;
		this.user = user;
		this.pic = pic;
		this.likes = likes;
		this.comments = comments;
	}









	public Publication(String publication_txt, User user, byte[] pic, List<LikePosts> likes, List<Comments> comments) {
		super();
		this.publication_txt = publication_txt;
		this.user = user;
		this.pic = pic;
		this.likes = likes;
		this.comments = comments;
	}









	public String getTitle() {
		return title;
	}









	public void setTitle(String title) {
		this.title = title;
	}









	public Publication(int id, String title, String publication_txt, User user, byte[] pic, List<LikePosts> likes,
			List<Comments> comments) {
		super();
		this.id = id;
		this.title = title;
		this.publication_txt = publication_txt;
		this.user = user;
		this.pic = pic;
		this.likes = likes;
		this.comments = comments;
	}









	public Publication(String title, String publication_txt, User user, byte[] pic, List<LikePosts> likes,
			List<Comments> comments) {
		super();
		this.title = title;
		this.publication_txt = publication_txt;
		this.user = user;
		this.pic = pic;
		this.likes = likes;
		this.comments = comments;
	}




	




	

	
}
