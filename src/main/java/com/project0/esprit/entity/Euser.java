package com.project0.esprit.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name="euser")
public class Euser extends AuditModel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@NotNull(message="firstname is required")
	@Size(min=1, max=32, message="First name must be between 1 and 32 characters")
	@Column(name="firstname")
	private String membre_username ;
	
	@Lob
	@Column(name="userimg")
	private byte[] userimg;
	
	@NotNull(message="password is required")
	@Column(name="password")
	private String password  ;
	
	@Column(name="confirmpassword")
	@NotNull(message="confirmpassword is required")
	private String confirm_password  ;

	@Column(name="email")
	@NotNull(message="email is required")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
	private String email  ;
	
	@Column(name="city")
	@NotNull(message="city is required")
	private String city  ;
	
	@Column(name="address")
	@NotNull(message="address is required")
	private String address  ;
	
	@NotNull(message="phone is required")
	@Pattern(regexp = "[0-9] {8}")
	@Column(name="phonenumber")
	private String phone_number  ;
	
	@NotNull(message="age is required")
	@Column(name="age")
	private String age ;
	
	@NotNull(message="sexe is required")
	@Column(name="sexe")
	private String sexe ;

	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getMembre_username() {
		return membre_username;
	}

	public void setMembre_username(String membre_username) {
		this.membre_username = membre_username;
	}


	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public byte[] getUserimg() {
		return userimg;
	}

	public void setUserimg(byte[] userimg) {
		this.userimg = userimg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
public String getAge() {
		return age;
	}
public void setAge(String age) {
	this.age = age;
}


	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	
	public Euser() {
		super();
	}

	public Euser(Long user_id,
			@NotNull(message = "firstname is required") @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") String membre_username,
			byte[] userimg, @NotNull(message = "password is required") String password,
			@NotNull(message = "confirmpassword is required") String confirm_password,
			@NotNull(message = "email is required") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email address is invalid") String email,
			@NotNull(message = "city is required") String city,
			@NotNull(message = "address is required") String address,
			@NotNull(message = "phone is required") @Pattern(regexp = "[0-9] {8}") String phone_number,
			@NotNull(message = "age is required") String age, @NotNull(message = "sexe is required") String sexe) {
		super();
		this.user_id = user_id;
		this.membre_username = membre_username;
		this.userimg = userimg;
		this.password = password;
		this.confirm_password = confirm_password;
		this.email = email;
		this.city = city;
		this.address = address;
		this.phone_number = phone_number;
		this.age = age;
		this.sexe = sexe;
	}

	public Euser(
			@NotNull(message = "firstname is required") @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") String membre_username,
			byte[] userimg, @NotNull(message = "password is required") String password,
			@NotNull(message = "confirmpassword is required") String confirm_password,
			@NotNull(message = "email is required") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email address is invalid") String email,
			@NotNull(message = "city is required") String city,
			@NotNull(message = "address is required") String address,
			@NotNull(message = "phone is required") @Pattern(regexp = "[0-9] {8}") String phone_number,
			@NotNull(message = "age is required") String age, @NotNull(message = "sexe is required") String sexe) {
		super();
		this.membre_username = membre_username;
		this.userimg = userimg;
		this.password = password;
		this.confirm_password = confirm_password;
		this.email = email;
		this.city = city;
		this.address = address;
		this.phone_number = phone_number;
		this.age = age;
		this.sexe = sexe;
	}






	



	
	
	

}
