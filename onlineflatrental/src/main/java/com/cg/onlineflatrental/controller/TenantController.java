package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/viewTenantById/{tenant_id}")
    public Tenant viewTenantById(@PathVariable Integer tenant_id){
    return tenantService.viewTenantById(tenant_id);
	}   
	
	@PostMapping("/addTenant")
    public Tenant addTenant(@RequestBody Tenant tenant){
    return tenantService.addTenant(tenant);
	}    
	
	@PutMapping("/updateTenant")
	public Tenant updateTenant(@RequestBody Tenant tenant){
	return tenantService.updateTenant(tenant);
     }

	@DeleteMapping("/deleteTenant")
	public boolean deleteTenant(@RequestBody Tenant tenant){
	return tenantService.deleteTenant(tenant);
	 }
	
	
	//validation...
}	  
	  
	  
