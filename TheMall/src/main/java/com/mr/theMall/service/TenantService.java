   package com.mr.theMall.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.theMall.entity.TenantEntity;
import com.mr.theMall.exception.MallException;
import com.mr.theMall.model.TenantModel;
import com.mr.theMall.repository.TenantRepository;

@Service
public class TenantService {
	
	@Autowired
	TenantRepository tenantRepo;
	
//	Map from Tenant Entity to Tenant Model
	private TenantModel mapTo(TenantEntity from) {
		TenantModel to = new TenantModel();
		
		to.setOwnerContact(from.getOwnerContact());
		to.setOwnerEmail(from.getOwnerEmail());
		to.setOwnerName(from.getOwnerName());
		to.setOwnerUniqueId(from.getOwnerUniqueId());
		
		return to;
	}
	
//	Map from Tenant Model to Tenant Entity
	private TenantEntity mapTo(TenantModel from) {
		TenantEntity to = new TenantEntity();
		
		to.setOwnerContact(from.getOwnerContact());
		to.setOwnerEmail(from.getOwnerEmail());
		to.setOwnerName(from.getOwnerName());
		to.setOwnerUniqueId(from.getOwnerUniqueId());
		
		return to;
	}
	
//	Search for Tenant in Tenant repository using Tenant ID
	public TenantModel getTenantbyId(String tenantId) {
		return mapTo(tenantRepo.findById(tenantId).orElse(null));
	}
	
//	Retrieve all Tenants from Tenant repository
	public List<TenantModel> getAllTenant() {
		return tenantRepo.findAll().stream().map( i -> mapTo(i)).collect(Collectors.toList());
	}
	
//	Add New Tenant to repository
	public TenantModel addTenant(TenantModel tenantModel) throws MallException {
		
//		Search if Tenant already exist in repository
		if(tenantRepo.existsById(tenantModel.getOwnerUniqueId()))
			throw new MallException("Tenant Already Exist");
		else
			return mapTo(tenantRepo.save(mapTo(tenantModel)));

	}
	
//	Delete Tenant Object with given ID from repository
	public void deleteTenant(String tenantId) {
		tenantRepo.deleteById(tenantId);
	}
	
//	Modify Tenant Object with given ID from repository
	public TenantModel modifyTenant(TenantModel tenantModel) throws MallException {

//		Search if Tenant already in repository or its new?
		if(tenantRepo.existsById(tenantModel.getOwnerUniqueId()))
			return mapTo(tenantRepo.save(mapTo(tenantModel)));
		else
			throw new MallException("Tenant Doesnot Exist");
	}

}