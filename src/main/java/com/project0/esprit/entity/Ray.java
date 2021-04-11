package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ray")
public class Ray  extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ray_id;
	
	@Column(name="rayname")
	private String rayname ;
	
	@Column(name="raytag")
	private String raytag  ;
	@Column(name="rayvison")
	private String rayvision;
	
    public Ray(Long ray_id, String rayname, String raytag, String rayvision, Set<Category1> categories) {
		super();
		this.ray_id = ray_id;
		this.rayname = rayname;
		this.raytag = raytag;
		this.rayvision = rayvision;
		this.categories = categories;
	}

	public Ray() {
		super();
	}

	@JsonManagedReference
	//@JsonIgnore
	@OneToMany(mappedBy = "ray", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Category1> categories;

	public Long getRay_id() {
		return ray_id;
	}

	public void setRay_id(Long ray_id) {
		this.ray_id = ray_id;
	}

	public String getRayname() {
		return rayname;
	}

	public void setRayname(String rayname) {
		this.rayname = rayname;
	}

	public String getRaytag() {
		return raytag;
	}

	public void setRaytag(String raytag) {
		this.raytag = raytag;
	}

	public String getRayvision() {
		return rayvision;
	}

	public void setRayvision(String rayvision) {
		this.rayvision = rayvision;
	}

	public Set<Category1> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category1> categories) {
		this.categories = categories;
	}
    

}
