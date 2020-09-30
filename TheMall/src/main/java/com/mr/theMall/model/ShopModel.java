package com.mr.theMall.model;

public class ShopModel {
	
	public ShopModel() {
		super();
	}
	
	private Long shopId;

	private BrandModel brand;
	
	private AddressModel address;
	
	private TenantModel tenant;
	
	private boolean carousel;
	
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public boolean isCarousel() {
		return carousel;
	}

	public void setCarousel(boolean carousel) {
		this.carousel = carousel;
	}

	public BrandModel getBrand() {
		return brand;
	}

	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public TenantModel getTenant() {
		return tenant;
	}

	public void setTennant(TenantModel tenant) {
		this.tenant = tenant;
	}

	
}