package com.mr.theMall.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tenant_entity")
public class TenantEntity {
	
	@NotBlank(message = "Owner E-mail cannot be empty or Null")
	private String ownerEmail;
	
	@NotBlank(message = "Owner Name cannot be empty or Null")
	private String ownerName;
	
	@Id
	@NotBlank(message = "Owner Unique ID cannot be empty or Null")
	private String ownerUniqueId;
	
	@NotBlank(message = "Owner Contact cannot be empty or Null")
	private String ownerContact;

	public TenantEntity(@NotBlank(message = "Owner E-mail cannot be empty or Null") String ownerEmail,
			@NotBlank(message = "Owner Name cannot be empty or Null") String ownerName,
			@NotBlank(message = "Owner Unique ID cannot be empty or Null") String ownerUniqueId,
			@NotBlank(message = "Owner Contact cannot be empty or Null") String ownerContact) {
		super();
		this.ownerEmail = ownerEmail;
		this.ownerName = ownerName;
		this.ownerUniqueId = ownerUniqueId;
		this.ownerContact = ownerContact;
	}

	public TenantEntity() {
		// TODO Auto-generated constructor stub
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