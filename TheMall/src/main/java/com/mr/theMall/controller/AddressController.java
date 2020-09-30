package com.mr.theMall.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mr.theMall.exception.MallException;
import com.mr.theMall.model.AddressModel;
import com.mr.theMall.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<AddressModel>> getAllAddresss(){
		return status(HttpStatus.OK).body(addressService.getAllAddress());
	}
	
	@GetMapping("/findAddressById/{addressId}")
	public ResponseEntity<AddressModel> findAddressById(@PathVariable Long addressId) {
		return status(HttpStatus.OK).body(addressService.getAddressbyId(addressId));
	}
	
	@PostMapping("/addAddress")
	public ResponseEntity<AddressModel> addAddress(@RequestBody AddressModel addressModel) throws MallException {
		return status(HttpStatus.OK).body(addressService.addAddress(addressModel));
	}
	
	@PutMapping("/modifyAddress")
	public ResponseEntity<AddressModel> modifyAddress(@RequestBody AddressModel addressModel) throws MallException{
		return status(HttpStatus.OK).body(addressService.modifyAddress(addressModel));
	}
	
	@DeleteMapping("/deleteAddress/{addressId}")
	public void deleteAddress(@PathVariable Long addressId){
		addressService.deleteAddress(addressId);
	}

}