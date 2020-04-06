package com.hcl.pp.model;

public class Pet {

	private long id;
	
	private String name;
	
	private int age;
	
	private String place;
	
	private User owner;
	
	public Pet() {}

	public Pet(String name, int age, String place, User owner) {
		this.name = name;
		this.age = age;
		this.place = place;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", place=" + place + ", owner=" + owner + "]";
	}
	
	
	
}
