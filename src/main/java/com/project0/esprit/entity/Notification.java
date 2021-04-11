package com.project0.esprit.entity;

public class Notification {

	  private String message;
	  private int count;
	  public Notification (String content) {
	    this.message = content;
	  }

	  public String getContent() {
	    return message;
	  }

	public Notification(int count) {
		super();
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public Notification(String message, int count) {
		super();
		this.message = message;
		this.count = count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	public void increments() {
		this.count++;
	}
	

	}
