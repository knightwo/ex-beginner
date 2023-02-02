package com.example.form;

import jakarta.validation.constraints.NotBlank;

public class UserForm {
	@NotBlank(message = "名前の入力は必須です")
	private String name;
	
	@NotBlank(message = "年齢の入力は必須です")
	private String age;
	
	@NotBlank(message = "コメントの入力は必須です")
	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getIntAge() {
		return Integer.parseInt(age);
	}

	@Override
	public String toString() {
		return "UserForm [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}

}
