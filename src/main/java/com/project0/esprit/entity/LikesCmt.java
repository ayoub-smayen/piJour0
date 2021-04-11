package com.project0.esprit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.springframework.stereotype.Service;


@Entity
@Table(name="likescmt")
public class LikesCmt {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long likes_id;

	

	public LikesCmt(Long likes_id, Boolean isLikes) {
		super();
		this.likes_id = likes_id;
		this.isLikes = isLikes;
	}


	public Long getLikes_id() {
		return likes_id;
	}


	public void setLikes_id(Long likes_id) {
		this.likes_id = likes_id;
	}


	/*@Formula("(select count(user_id) from Likes l where l.post_id = post_id)")  
    private int countLike;
	@Transient
	    private boolean isLiked;
    
    public int getCountLike() {
		return countLike;
	}
	public void setCountLike(int countLike) {
		this.countLike = countLike;
	}
	public boolean isLiked(){
        return getCountLike() > 0;
	}*/
	public Boolean getIsLikes() {
		return isLikes;
	}


	public void setIsLikes(Boolean isLikes) {
		this.isLikes = isLikes;
	}


	public LikesCmt() {
		super();
	}


	public static Integer getLikes_count() {
		return likes_count;
	}


	public static void setLikes_count(Integer likes_count) {
		LikesCmt.likes_count = likes_count;
	}


	private Boolean isLikes = false;
	public LikesCmt(Boolean isLikes) {
		super();
		this.isLikes = isLikes;
	}


	private static  Integer  likes_count = 0 ;
	
	
	//@Transient
	public  Integer  incrementLikes() {
		
		if(this.isLikes == false) {
		if(LikesCmt.likes_count >= 0) {
			
				
				this.isLikes = !this.isLikes;
				LikesCmt.likes_count ++;
			}
		
			return LikesCmt.likes_count ;
		}
		
		
		
		return 0;
	}

}
