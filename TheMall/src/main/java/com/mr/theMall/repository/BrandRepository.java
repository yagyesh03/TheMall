package com.mr.theMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mr.theMall.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, String> {

}
