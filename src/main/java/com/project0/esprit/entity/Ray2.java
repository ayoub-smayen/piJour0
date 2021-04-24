package com.project0.esprit.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;


@Entity
@Table(name="Sections")
public class Ray2 extends AuditModel {

	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long RayId;
	private String RayName;
	private String RayDescription;
	@Max(value=100,message="cannot add a value over 100")
	private int totalproduct;
	@Max(value=100,message="cannot add a value over 100")
	private int Capacity;
	/*@OneToOne
	private Product1 bestProduct;*/
	@Lob
	private byte[] RayonImg;
	
	
	@OneToMany(mappedBy="ray", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Category1> categories;
	
	
	
	
	
	public Ray2() {
		super();
		
	}





	public Ray2(Long rayId, String rayName, String rayDescription,
			@Max(value = 100, message = "cannot add a value over 100") int totalproduct,
			@Max(value = 100, message = "cannot add a value over 100") int capacity, Product1 bestProduct,
			byte[] rayonImg, Set<Category1> categories) {
		super();
		RayId = rayId;
		RayName = rayName;
		RayDescription = rayDescription;
		this.totalproduct = totalproduct;
		Capacity = capacity;
		
		RayonImg = rayonImg;
		this.categories = categories;
	}





	public Ray2(String rayName, String rayDescription,
			@Max(value = 100, message = "cannot add a value over 100") int totalproduct,
			@Max(value = 100, message = "cannot add a value over 100") int capacity, Product1 bestProduct,
			byte[] rayonImg, Set<Category1> categories) {
		super();
		RayName = rayName;
		RayDescription = rayDescription;
		this.totalproduct = totalproduct;
		Capacity = capacity;
	
		RayonImg = rayonImg;
		this.categories = categories;
	}





	public Long getRayId() {
		return RayId;
	}





	public void setRayId(Long rayId) {
		RayId = rayId;
	}





	public String getRayName() {
		return RayName;
	}





	public void setRayName(String rayName) {
		RayName = rayName;
	}





	public String getRayDescription() {
		return RayDescription;
	}





	public void setRayDescription(String rayDescription) {
		RayDescription = rayDescription;
	}





	public int getTotalproduct() {
		return totalproduct;
	}





	public void setTotalproduct(int totalproduct) {
		this.totalproduct = totalproduct;
	}





	public int getCapacity() {
		return Capacity;
	}





	public void setCapacity(int capacity) {
		Capacity = capacity;
	}







	public byte[] getRayonImg() {
		return RayonImg;
	}





	public void setRayonImg(byte[] rayonImg) {
		RayonImg = rayonImg;
	}





	public Set<Category1> getCategories() {
		return categories;
	}





	public void setCategories(Set<Category1> categories) {
		this.categories = categories;
	}
	
	
	
	
	
}
