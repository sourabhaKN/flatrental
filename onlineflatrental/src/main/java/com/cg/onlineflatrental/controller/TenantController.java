package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Tenant viewTenantById(@PathVariable int tenantId){
    return tenantService.viewTenantById(tenantId);
	}   
	
	@PostMapping("/addTenant")
    public Tenant addTenant(@RequestBody Tenant tenant){
    return tenantService.addTenant(tenant);
	}    
	
	@PutMapping("/updateTenant")
	public Tenant updateTenant(@RequestBody Tenant tenant){
	return tenantService.updateTenant(tenant);
	}
	
	
		
	@DeleteMapping("/deleteTenant/{tenantId}")
	public Boolean deleteTenant(@PathVariable int tenantId) {
		return tenantService.deleteTenant(tenantId);
		}
	
	
	@Validated
	public Tenant validateTenant(@RequestBody int tenantId ) {
		return tenantService.validateTenat(tenantId);
	}
	
}	  
	  
	  
