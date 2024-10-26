package com.flashcard.model;

public class ModelLogin {
	private String email;
    private String password;
	public ModelLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
