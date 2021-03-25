package com.project0.esprit.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project0.esprit.datentity.User;

@Entity
@Table(name="orders0")
public class Orders0 extends AuditModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Order;
	@Temporal(TemporalType.DATE)
	private Date Order_Date;
	
	private String Order_Status;
	
	private String Order_Name;
	
	private String Order_point;
	
	private String Order_TypePay;
	
	//Relation between Oder=>User
	@ManyToOne
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	//@JsonIgnore
	//@JoinColumn(name = "user_id" ,  nullable = true)
	private User user;
	
	public Orders0() {
		super();
	}

	public Orders0(Long id_Order, Date order_Date, String order_Status, String order_Name, String order_point,
			String order_TypePay, User user, Set<CartItem0> catitem_list) {
		super();
		Id_Order = id_Order;
		Order_Status = order_Status;
		Order_Name = order_Name;
		Order_point = order_point;
		Order_TypePay = order_TypePay;
		this.user = user;
		this.catitem_list = catitem_list;
	}

	public Long getId_Order() {
		return Id_Order;
	}

	public void setId_Order(Long id_Order) {
		Id_Order = id_Order;
	}


	public String getOrder_Status() {
		return Order_Status;
	}

	public void setOrder_Status(String order_Status) {
		Order_Status = order_Status;
	}

	public String getOrder_Name() {
		return Order_Name;
	}

	public void setOrder_Name(String order_Name) {
		Order_Name = order_Name;
	}

	public String getOrder_point() {
		return Order_point;
	}

	public void setOrder_point(String order_point) {
		Order_point = order_point;
	}

	public String getOrder_TypePay() {
		return Order_TypePay;
	}

	public void setOrder_TypePay(String order_TypePay) {
		Order_TypePay = order_TypePay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItem0> getCatitem_list() {
		return catitem_list;
	}

	public void setCatitem_list(Set<CartItem0> catitem_list) {
		this.catitem_list = catitem_list;
	}

	//Relation between Oder=>CartItem
	@OneToMany(mappedBy="orders",fetch =  FetchType.LAZY)
	private Set<CartItem0> catitem_list;
	

}

