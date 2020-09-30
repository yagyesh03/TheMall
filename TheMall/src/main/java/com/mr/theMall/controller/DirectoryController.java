package com.mr.theMall.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.mr.theMall.exception.MallException;
import com.mr.theMall.model.ShopModel;
import com.mr.theMall.service.DirectoryService;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;


@Controller
@CrossOrigin
@RequestMapping("/directory")
public class DirectoryController {

	@Autowired
	DirectoryService dirService;
	
	@GetMapping
	public ResponseEntity<List<ShopModel>> getAllShops(){
		return status(HttpStatus.OK).body(dirService.getAllShops());
	}
	
	@GetMapping("/findShopById/{shopId}")
	public ResponseEntity<ShopModel> findShopById(@PathVariable Long shopId) {
		return status(HttpStatus.OK).body(dirService.getShopById(shopId));
	}
	
	@PostMapping("/addShop")
	public ResponseEntity<ShopModel> addShop(@RequestBody ShopModel shopModel) throws MallException {
		return status(HttpStatus.OK).body(dirService.addShop(shopModel));
	}
	
	@PutMapping("/modifyShop")
	public ResponseEntity<?> modifyShop(@RequestBody ShopModel shopModel) throws MallException{
		return status(HttpStatus.OK).body(dirService.modifyShop(shopModel));
	}
	
	@DeleteMapping("/deleteShop/{shopId}")
	public void deleteShop(@PathVariable Long shopId){
		dirService.deleteShop(shopId);
	}

}