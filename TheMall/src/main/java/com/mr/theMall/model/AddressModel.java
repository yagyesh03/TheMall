package com.mr.theMall.model;


public class AddressModel {

	public AddressModel() {
		super();
	}
	
	public AddressModel(long floorNumber, Long shopNumber, Boolean occupied) {
		super();
		this.setOccupied(occupied);
		this.floorNumber = floorNumber;
		this.shopNumber = shopNumber;
	}
	private long addressId;

	private long floorNumber;
	
	private Long shopNumber;
	
	private boolean occupied;
	
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
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

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

}