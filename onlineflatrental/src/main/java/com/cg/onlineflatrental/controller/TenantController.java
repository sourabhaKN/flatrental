package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.model.Tenant;
import com.cg.onlineflatrental.services.ITenantService;


@RestController
@RequestMapping("/Tenant")
public class TenantController {
	
	@Autowired
    private ITenantService tenantService;
    
	@GetMapping("/viewAllTenants")
	public List<Tenant> viewAllTenants(){
	return (List<Tenant>) tenantService.viewAllTenants();
	}
	
	@GetMapping("/viewTenantById/{tenantId}") 
    public ResponseEntity viewTenantById(@PathVariable int tenantId)throws TenantNotFoundException
	{
		
      Tenant tenant= tenantService.viewTenantById(tenantId);
       return new ResponseEntity(tenant,HttpStatus.OK);
	}   
	
	@PostMapping("/addTenant")
    public Tenant addTenant(@RequestBody Tenant tenant)throws TenantNotFoundException{
    return tenantService.addTenant(tenant);
	}    
	
	@PutMapping("/updateTenant")
	public ResponseEntity updateTenant(@RequestBody Tenant tenant)throws TenantNotFoundException{
	Tenant tenant1= tenantService.updateTenant(tenant);
	return new ResponseEntity(tenant1,HttpStatus.OK);
	}
	
	
		
	@DeleteMapping("/deleteTenant/{tenantId}")
	public ResponseEntity deleteTenant(@PathVariable int tenantId)throws TenantNotFoundException {
         tenantService.deleteTenant(tenantId);
		return new ResponseEntity("Tenant deleted successfully",HttpStatus.OK);
		}
	
	
	@Validated
	public Tenant validateTenant(@RequestBody int tenantId ) {
		return tenantService.validateTenat(tenantId);
	}
	
}	  
	  
	  
