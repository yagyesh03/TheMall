package com.mr.theMall.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mr.theMall.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

//	Search Address object with given Floor Number & Shop Number
	public AddressEntity findByFloorNumberAndShopNumber(Long floorNumber, Long shopNumber);

}