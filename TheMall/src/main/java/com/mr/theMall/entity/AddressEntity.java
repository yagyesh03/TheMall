package com.mr.theMall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class AddressEntity {

	public AddressEntity() {
		super();
	}
	
	public AddressEntity(@NotBlank(message = "Floor Number cannot be empty or Null") long floorNumber,
			@NotBlank(message = "Shop Number cannot be empty or Null") Long shopNumber,
			Boolean occupied) {
		super();
		this.occupied = occupied;
		this.floorNumber = floorNumber;
		this.shopNumber = shopNumber;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;

	@NotBlank(message = "Floor Number cannot be empty or Null")
	private long floorNumber;
	
	@NotBlank(message = "Shop Number cannot be empty or Null")
	private Long shopNumber;
	
	@NotBlank(message = "Occupied Status cannot be empty or Null")
	private boolean occupied;

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public long getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(long floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Long getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(Long shopNumber) {
		this.shopNumber = shopNumber;
	}

}