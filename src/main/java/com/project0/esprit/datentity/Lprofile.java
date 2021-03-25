package com.project0.esprit.datentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import org.hibernate.annotations.ColumnDefault;

@Embeddable
public class Lprofile implements Serializable {
  
	 @Lob
	 @Column(name = "profile_pic" , nullable = true)
	private byte[] picprofile;
	 
	 @Column(name="tel", nullable = true)
	 private String tel ;
	 
	  
	@Column(name="addresse", nullable = true)
	  private String adreese;
     
	 // @Column(name="edited")
	  @ColumnDefault("0")
	  private Boolean edited = false;
	   
	public Boolean getEdited() {
		return edited;
	}

	public void setEdited(Boolean edited) {
		this.edited = edited;
	}
	/*
	public Lprofile(String tel, String adreese) {
		super();
		this.tel = tel;
		this.adreese = adreese;
	}

	public Lprofile(byte[] picprofile, String tel, String adreese, Boolean edited) {
		super();
		this.picprofile = picprofile;
		this.tel = tel;
		this.adreese = adreese;
		this.edited = edited;
	}
*/
	public byte[] getPicprofile() {
		return picprofile;
	}

	public void setPicprofile(byte[] picprofile) {
		this.picprofile = picprofile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdreese() {
		return adreese;
	}

	public void setAdreese(String adreese) {
		this.adreese = adreese;
	}
/*
	public Lprofile(byte[] picprofile, String tel, String adreese) {
		super();
		this.picprofile = picprofile;
		this.tel = tel;
		this.adreese = adreese;
	}
*/

	public Lprofile() {
		super();
	}
	
	  
	  
	  
	  
	  
}
