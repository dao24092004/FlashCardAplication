package com.flashcard.model;

public class ModelMessage {
	private boolean success;
    private String message;
	public ModelMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelMessage(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
}
