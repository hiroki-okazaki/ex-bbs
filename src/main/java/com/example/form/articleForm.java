package com.example.form;

public class articleForm {

	
	private String id;
	
	private String name;
	
	private String content;
	
	

	@Override
	public String toString() {
		return "articleForm [ID=" + id + ", name=" + name + ", content=" + content + "]";
	}
	
	public String getId() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
