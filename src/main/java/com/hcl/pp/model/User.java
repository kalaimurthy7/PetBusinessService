package com.hcl.pp.model;

import java.util.Set;

public class User {

	private long userId;
	
	private String username;
	
	private String password;
	//private String confirmPassword;
	
	private Set<Pet> pets;
	
	public User() {}

	public User(String username, String password, /* String confirmPassword, */ Set<Pet> pets) {
		this.username = username;
		this.password = password;
		/* this.confirmPassword = confirmPassword; */
		this.pets = pets;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}*/

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", username=" + username + ", password=" + password + ", confirmPassword="
				+ /* confirmPassword + */ ", pets=" + pets + "]";
	}
	
	
}
