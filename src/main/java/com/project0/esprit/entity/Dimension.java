package com.project0.esprit.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Dimension {
	
	private float lenght;
	public float getLenght() {
		return lenght;
	}
	public void setLenght(float lenght) {
		this.lenght = lenght;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	private float width;
	public Dimension() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dimension(float lenght, float width) {
		super();
		this.lenght = lenght;
		this.width = width;
	}

}
