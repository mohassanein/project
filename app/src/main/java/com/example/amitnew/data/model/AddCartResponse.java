package com.example.amitnew.data.model;

import com.google.gson.annotations.SerializedName;

public class AddCartResponse {

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}