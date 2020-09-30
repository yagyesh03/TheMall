package com.mr.theMall.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.theMall.entity.ShopEntity;
import com.mr.theMall.exception.MallException;
import com.mr.theMall.model.AddressModel;
import com.mr.theMall.model.ShopModel;
import com.mr.theMall.repository.ShopRepository;

@Service
public class DirectoryService {

	@Autowired
	ShopRepository shopRepo;
	
	@Autowired
	TenantService tenantService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	BrandService brandService;
	
//	Map from Brand Entity to Brand Model
	public ShopModel mapTo(ShopEntity from) {
		ShopModel to = new ShopModel(); 
		
		to.setAddress(addressService.getAddressbyId(from.getAddressId()));
		to.setBrand(brandService.findBrandByName(from.getBrandName()));
		to.setCarousel(from.isCarousel());
		to.setShopId(from.getShopId());
		to.setTennant(tenantService.getTenantbyId(from.getTennantId()));
		
		return to;
	}
	
//	Map from Brand Model to Brand Entity
	public ShopEntity mapTo(ShopModel from) {
		ShopEntity to = new ShopEntity(); 
		
		to.setAddressId(from.getAddress().getAddressId());
		to.setBrandName(from.getBrand().getBrandName());
		to.setCarousel(from.isCarousel());
		to.setTennantId(from.getTenant().getOwnerUniqueId());
		
		return to;
	}
	
//	Retrieve all Shops from Shop repository
	public List<ShopModel> getAllShops(){
		return shopRepo.findAll().stream().map(i -> mapTo(i)).collect(Collectors.toList());
	}
	
//	Search for Shop in Shop repository using Shop ID
	public ShopModel getShopById(Long shopId) {
		ShopEntity shop = shopRepo.findById(shopId).orElse(null);
		System.out.println("Shop:"+shop);
		return mapTo(shop);
	}
	
//	Add New Shop to repository
	public ShopModel addShop(ShopModel shopModel) throws MallException {
		
//		Search if Shop already exist in repository
		if(!shopRepo.existsById(shopModel.getShopId())) {
			
//			Check if Address is already occupied 
			if(addressService.getAddressbyId(shopModel.getAddress().getAddressId()).isOccupied()) {
				throw new MallException("Address Already occupied");
			}
			addressService.modifyAddress(shopModel.getAddress());
			return mapTo(shopRepo.save(mapTo(shopModel)));
		
		}
		else
			throw new MallException("Shop Already Exist");
	}
	
//	Modify Shop Object with given ID from repository
	public ShopModel modifyShop(ShopModel shopModel) throws MallException {
		
//		Search if Shop already in repository or its new?
		if(shopRepo.existsById(shopModel.getShopId())) {
			shopRepo.deleteById(shopModel.getShopId());
			return mapTo(shopRepo.save(mapTo(shopModel)));
		}
		else
			throw new MallException("Shop Doesnot Exist");
		
	}

//	Delete Shop Object with given ID from repository
	public void deleteShop(Long shopId) {
		
		AddressModel addressModel = getShopById(shopId).getAddress();
		addressModel.setOccupied(false);
		try {
			addressService.modifyAddress(addressModel);
		} catch (MallException e) {
			e.printStackTrace();
		}
		shopRepo.deleteById(shopId);
	}
	
}