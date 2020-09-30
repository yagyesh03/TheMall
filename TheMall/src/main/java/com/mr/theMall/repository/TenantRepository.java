package com.mr.theMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mr.theMall.entity.TenantEntity;
import java.lang.String;
import java.util.List;

public interface TenantRepository extends JpaRepository<TenantEntity, String> {

	List<TenantEntity> findByOwnerUniqueId(String owneruniqueid);
	
}
