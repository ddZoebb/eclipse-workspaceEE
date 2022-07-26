package com.itwill.bean;

public class Car {
	private int no;
	private String model;
	private String color;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int no, String model, String color) {
		super();
		this.no = no;
		this.model = model;
		this.color = color;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [no=" + no + ", model=" + model + ", color=" + color + "]";
	}

}
