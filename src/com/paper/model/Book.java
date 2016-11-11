package com.paper.model; 

public class Book {
	
	private String type;
	private String text;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}