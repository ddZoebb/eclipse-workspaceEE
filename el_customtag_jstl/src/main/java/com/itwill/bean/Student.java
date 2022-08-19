package com.itwill.bean;

public class Student {
	private int no;
	private String name;
	private Car car;
	public Student(int no, String name, Car car) {
		super();
		this.no = no;
		this.name = name;
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
