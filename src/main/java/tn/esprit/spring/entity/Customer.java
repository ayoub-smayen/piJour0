package tn.esprit.spring.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcustomer", unique = true, nullable = false)
	private Long idCustomer;
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;
	@Column(name = "password", nullable = false, length = 256)
	private String password;

}
