package com.mr.theMall.model;

import javax.validation.constraints.NotBlank;

public class BrandModel {
	
	private String brandName;
	
	private String brandDescription;
	
	private String brandLogo;
	
	private String photoURL;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandDescription() {
		return brandDescription;
	}

	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}

	public String getBrandLogo() {
		return brandLogo;
	}

	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public BrandModel(String brandName,
			@NotBlank(message = "Brand Description cannot be empty") String brandDescription,
			@NotBlank(message = "Brand Logo cannot be empty") String brandLogo,
			@NotBlank(message = "Brand Photo URL cannot be empty") String photoURL) {
		super();
		this.brandName = brandName;
		this.brandDescription = brandDescription;
		this.brandLogo = brandLogo;
		this.photoURL = photoURL;
	}

	public BrandModel() {
		// TODO Auto-generated constructor stub
	}
	
}
