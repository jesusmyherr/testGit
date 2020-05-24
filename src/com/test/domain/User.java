package com.test.domain;

public class User {
	private String username;
	private String password;
	private String uid;
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", uid=" + uid + "]";
	}
	
}
