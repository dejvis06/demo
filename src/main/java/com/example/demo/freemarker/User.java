package com.example.demo.freemarker;

public class User {

	private String name;
	private String username;
	private String email;

	public User(String name, String username, String email) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

}
