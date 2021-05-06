package tn.esprit.spring.entity;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Publication> publication_id;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Comments> comments;
	
	@Lob
	private byte[] img;
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
	public List<Publication> getPublication_id() {
		return publication_id;
	}
	public void setPublication_id(List<Publication> publication_id) {
		this.publication_id = publication_id;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}

	public User(int user_id, String user_name, String user_Lastname, List<Publication> publication_id,
			List<Comments> comments, byte[] img) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_Lastname = user_Lastname;
		this.publication_id = publication_id;
		this.comments = comments;
		this.img = img;
	}

	public User(String user_name, String user_Lastname, List<Publication> publication_id, List<Comments> comments,
			byte[] img) {
		super();
		this.user_name = user_name;
		this.user_Lastname = user_Lastname;
		this.publication_id = publication_id;
		this.comments = comments;
		this.img = img;
	}
	
	
	
	
}
