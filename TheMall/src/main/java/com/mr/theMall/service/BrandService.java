package com.mr.theMall.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.theMall.entity.BrandEntity;
import com.mr.theMall.exception.MallException;
import com.mr.theMall.model.BrandModel;
import com.mr.theMall.repository.BrandRepository;

@Service
public class BrandService {
	
//	Brand Repository Object
	@Autowired
	BrandRepository brandRepo;
	
//	Map from Brand Entity to Brand Model
	private BrandModel mapTo(BrandEntity from) {
		BrandModel to = new BrandModel();
		
		to.setBrandDescription(from.getBrandDescription());
		to.setBrandLogo(from.getBrandLogo());
		to.setBrandName(from.getBrandName());
		to.setPhotoURL(from.getPhotoURL());
		
		return to;
	}

//	Map from Brand Model to Brand Entity
	private BrandEntity mapTo(BrandModel from) {
		BrandEntity to = new BrandEntity();
		
		to.setBrandDescription(from.getBrandDescription());
		to.setBrandLogo(from.getBrandLogo());
		to.setBrandName(from.getBrandName());
		to.setPhotoURL(from.getPhotoURL());
		
		return to;
	}
	
//	Retrieve all Brands from Brand repository
	public List<BrandModel> getAllBrand() {
		return brandRepo.findAll().stream().map( i -> mapTo(i)).collect(Collectors.toList());
	}
	
//	Add New Brand to repository
	public BrandModel addBrand(BrandModel brandModel) throws MallException {
		
//		Search if Brand already exist in repository
		if(brandRepo.existsById(brandModel.getBrandName()))
			throw new MallException("Brand Already Exist");
		else
			return mapTo(brandRepo.save(mapTo(brandModel)));
	}
	
//	Delete Brand Object with given ID from repository
	public void deleteBrand(String brandId) {
		brandRepo.deleteById(brandId);
	}
	
//	Modify Brand Object with given ID from repository
	public BrandModel modifyBrand(BrandModel brandModel) throws MallException {
		
//		Search if Brand already in repository or its new?
		
		if(brandRepo.existsById(brandModel.getBrandName()))
			return mapTo(brandRepo.save(mapTo(brandModel)));			
		else
			throw new MallException("Brand Doesnot Exist");
	}
	
//	Search for Brand in Brand repository using Brand ID
	public BrandModel findBrandByName(String brandName) {
		return mapTo(brandRepo.findById(brandName).orElse(null));
	}

}