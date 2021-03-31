package com.project0.esprit.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="claim")
public class Claim {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long claim_id;
	
	
	@NotNull(message = "subject name is required.")
	@Column(name="subject")
	private String subject;
	@NotNull(message = "desription name is required.")
	@Column(name="description")
	private String desc;
	
	@Column(name="claim_date_created")
	@CreationTimestamp
	private Date claimDateCreated;

	@Column(name="claim_date_updated")
	@UpdateTimestamp
	private Date claimDateUpdated;
	
	
	public Long getClaim_id() {
		return claim_id;
	}

	public void setClaim_id(Long claim_id) {
		this.claim_id = claim_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	

	
	public Claim(Long claim_id, String subject, String desc, Date claimDateCreated, Date claimDateUpdated) {
		super();
		this.claim_id = claim_id;
		this.subject = subject;
		this.desc = desc;
		this.claimDateCreated = claimDateCreated;
		this.claimDateUpdated = claimDateUpdated;
	}

	public Date getClaimDateCreated() {
		return claimDateCreated;
	}

	public void setClaimDateCreated(Date claimDateCreated) {
		this.claimDateCreated = claimDateCreated;
	}

	public Date getClaimDateUpdated() {
		return claimDateUpdated;
	}

	public void setClaimDateUpdated(Date claimDateUpdated) {
		this.claimDateUpdated = claimDateUpdated;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",nullable=true )
	private Euser client ; */
}

