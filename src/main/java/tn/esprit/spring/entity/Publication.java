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
import javax.validation.constraints.Size;

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
	@ManyToOne
	@JoinColumn(name = "user", nullable=true)
	private User user;
	@Lob
	private byte[] pic;
	@OneToMany(mappedBy="pub",cascade=CascadeType.ALL)
	private List<LikePosts> likes;
	@OneToMany(mappedBy = "pub_id",cascade=CascadeType.ALL)
	private List<Comments> comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublication_txt() {
		return publication_txt;
	}
	public void setPublication_txt(String publication_txt) {
		this.publication_txt = publication_txt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public List<LikePosts> getLikes() {
		return likes;
	}
	public void setLikes(List<LikePosts> likes) {
		this.likes = likes;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publication(int id,  String title,
			String publication_txt, User user, byte[] pic, List<LikePosts> likes, List<Comments> comments) {
		super();
		this.id = id;
		this.title = title;
		this.publication_txt = publication_txt;
		this.user = user;
		this.pic = pic;
		this.likes = likes;
		this.comments = comments;
	}
	public Publication( String title,
			String publication_txt, User user, byte[] pic, List<LikePosts> likes, List<Comments> comments) {
		super();
		this.title = title;
		this.publication_txt = publication_txt;
		this.user = user;
		this.pic = pic;
		this.likes = likes;
		this.comments = comments;
	}	

	

	
}
