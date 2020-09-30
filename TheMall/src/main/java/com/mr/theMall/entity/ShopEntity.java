package com.mr.theMall.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class ShopEntity {

	public ShopEntity() {
		super();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long shopId;

	@NotBlank(message = "Brand Name cannot be empty or Null")
	private String brandName;
	
	@NotBlank(message = "Address cannot be empty or Null")
	private Long addressId;
	
	@NotBlank(message = "Address cannot be empty or Null")
	private String tennantId;
	
	private boolean carousel;
	
	public ShopEntity(String brandName, Long addressId, String tennantId, boolean carousel) {
		super();
		this.addressId = addressId;
		this.brandName = brandName;
		this.tennantId = tennantId;
		this.carousel = carousel;
	}
	
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public boolean isCarousel() {
		return carousel;
	}

	public void setCarousel(boolean carousel) {
		this.carousel = carousel;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getTennantId() {
		return tennantId;
	}

	public void setTennantId(String tenantId) {
		this.tennantId = tenantId;
	}

}