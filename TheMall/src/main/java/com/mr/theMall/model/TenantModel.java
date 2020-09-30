package com.mr.theMall.model;

import javax.validation.constraints.NotBlank;

public class TenantModel {

	private String ownerEmail;
	
	private String ownerName;
	
	private String ownerUniqueId;
	
	private String ownerContact;

	public TenantModel() {
		super();
	}

	public TenantModel(@NotBlank(message = "Owner E-mail cannot be empty or Null") String ownerEmail,
			@NotBlank(message = "Owner Name cannot be empty or Null") String ownerName,
			@NotBlank(message = "Owner Unique ID cannot be empty or Null") String ownerUniqueId,
			@NotBlank(message = "Owner Contact cannot be empty or Null") String ownerContact) {
		super();
		this.ownerEmail = ownerEmail;
		this.ownerName = ownerName;
		this.ownerUniqueId = ownerUniqueId;
		this.ownerContact = ownerContact;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerUniqueId() {
		return ownerUniqueId;
	}

	public void setOwnerUniqueId(String ownerUniqueId) {
		this.ownerUniqueId = ownerUniqueId;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}
	
}
