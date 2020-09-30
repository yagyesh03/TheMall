package com.mr.theMall.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mr.theMall.exception.MallException;
import com.mr.theMall.model.TenantModel;
import com.mr.theMall.service.TenantService;

@Controller
@RequestMapping("/tenant")
public class TenantController {
	
	@Autowired
	TenantService tenantService;
	
	@GetMapping
	public ResponseEntity<List<TenantModel>> getAllTenants(){
		return status(HttpStatus.OK).body(tenantService.getAllTenant());
	}
	
	@GetMapping("/findTenantById/{tenantId}")
	public ResponseEntity<TenantModel> findTenantById(@PathVariable String tenantId) {
		return status(HttpStatus.OK).body(tenantService.getTenantbyId(tenantId));
	}
	
	@PostMapping("/addTenant")
	public ResponseEntity<TenantModel> addTenant(@RequestBody TenantModel tenantModel) throws MallException {
		return status(HttpStatus.OK).body(tenantService.addTenant(tenantModel));
	}
	
	@PutMapping("/modifyTenant")
	public ResponseEntity<TenantModel> modifyTenant(@RequestBody TenantModel tenantModel) throws MallException{
		return status(HttpStatus.OK).body(tenantService.modifyTenant(tenantModel));
	}
	
	@DeleteMapping("/deleteTenant/{tenantId}")
	public void deleteTenant(@PathVariable String tenantId){
		tenantService.deleteTenant(tenantId);
	}

}
