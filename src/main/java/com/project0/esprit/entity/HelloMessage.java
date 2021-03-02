package com.project0.esprit.entity;

public class HelloMessage {

	  private String name;
	  private  String msg;

	  public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HelloMessage() {
	  }

	  public HelloMessage(String name) {
	    this.name = name;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }
	}
