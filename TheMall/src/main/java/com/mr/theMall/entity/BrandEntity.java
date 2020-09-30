package com.mr.theMall.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class BrandEntity {

	@Id
	private String brandName;
	
	@NotBlank(message = "Brand Description cannot be empty")
	private String brandDescription;
	
	@NotBlank(message = "Brand Logo cannot be empty")
	private String brandLogo;
	
	@NotBlank(message = "Brand Photo URL cannot be empty")
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

	public BrandEntity(String brandName,
			@NotBlank(message = "Brand Description cannot be empty") String brandDescription,
			@NotBlank(message = "Brand Logo cannot be empty") String brandLogo,
			@NotBlank(message = "Brand Photo URL cannot be empty") String photoURL) {
		super();
		this.brandName = brandName;
		this.brandDescription = brandDescription;
		this.brandLogo = brandLogo;
		this.photoURL = photoURL;
	}

	public BrandEntity() {
		// TODO Auto-generated constructor stub
	}
	
}