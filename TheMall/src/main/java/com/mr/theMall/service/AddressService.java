package com.mr.theMall.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.theMall.entity.AddressEntity;
import com.mr.theMall.exception.MallException;
import com.mr.theMall.model.AddressModel;
import com.mr.theMall.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepo;
	
//	Map from Address Entity to Address Model
	public AddressModel mapTo(AddressEntity from) {
		
		AddressModel to = new AddressModel();
		try {
		to.setFloorNumber(from.getFloorNumber());
		to.setShopNumber(from.getShopNumber());
		to.setAddressId(from.getAddressId());
		to.setOccupied(from.isOccupied());
		}
		catch(NullPointerException ex) {
			System.out.println("NullPointerError Encontered");
		}
		return to;
	}

//	Map from Address Model to Address Entity
	public AddressEntity mapTo(AddressModel from) {
		
		AddressEntity to = new AddressEntity();
		
		to.setFloorNumber(from.getFloorNumber());
		to.setShopNumber(from.getShopNumber());
		to.setAddressId(from.getAddressId());
		to.setOccupied(from.isOccupied());
		
		return to;
	}
	
//	Search for address in address repository using Address ID
	public AddressModel getAddressbyId(Long addressId) {
		return mapTo(addressRepo.findById(addressId).orElse(null));
	}
	
//	Retrieve all addresses from address repository
	public List<AddressModel> getAllAddress() {
		return addressRepo.findAll().stream().map( i -> mapTo(i)).collect(Collectors.toList());
	}
	
//	Add New Address to repository
	@SuppressWarnings("finally")
	public AddressModel addAddress(AddressModel addressModel) throws MallException {
		
//		Search if address already exist in repository
		try {
			addressRepo.findByFloorNumberAndShopNumber(addressModel.getFloorNumber(), addressModel.getShopNumber()).equals(null);
		}
		catch(NullPointerException ex) {
			addressModel = mapTo(addressRepo.save(mapTo(addressModel)));
		}
		finally {
			return addressModel;
		}
		
	}
	
//	Delete Address Object with given ID from repository
	public void deleteAddress(Long addressId) {
		addressRepo.deleteById(addressId);
	}

//	Modify Address Object with given ID from repository
	public AddressModel modifyAddress(AddressModel addressModel) throws MallException {

//		Search if address already in repository or its new?
		if(addressRepo.existsById(addressModel.getAddressId()))
			return mapTo(addressRepo.save(mapTo(addressModel)));
		else
			throw new MallException("Address Doesnot Exist");
	}
	
}