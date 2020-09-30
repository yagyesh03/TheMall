package com.mr.theMall.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mr.theMall.exception.MallException;
import com.mr.theMall.model.BrandModel;
import com.mr.theMall.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@GetMapping
	public ResponseEntity<List<BrandModel>> getAllBrands(){
		return status(HttpStatus.OK).body(brandService.getAllBrand());
	}
	
	@GetMapping("/findBrandById/{brandId}")
	public ResponseEntity<BrandModel> findBrandById(@PathVariable String brandId) {
		return status(HttpStatus.OK).body(brandService.findBrandByName(brandId));
	}
	
	@PostMapping("/addBrand")
	public ResponseEntity<BrandModel> addBrand(@RequestBody BrandModel brandModel) throws MallException {
		return status(HttpStatus.OK).body(brandService.addBrand(brandModel));
	}
	
	@PutMapping("/modifyBrand")
	public ResponseEntity<BrandModel> modifyBrand(@RequestBody BrandModel brandModel) throws MallException{
		return status(HttpStatus.OK).body(brandService.modifyBrand(brandModel));
	}
	
	@DeleteMapping("/deleteBrand/{brandId}")
	public void deleteBrand(@PathVariable String brandId){
		brandService.deleteBrand(brandId);
	}

}