package com.mr.theMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mr.theMall.entity.ShopEntity;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

	ShopEntity findByAddressId(Long shopId);

}
