package com.cg.onlineflatrental.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.dao.ITenantDao;
import com.cg.onlineflatrental.model.Tenant;

@Service
@Transactional
public class ITenantServiceImpl implements ITenantService {

	@Autowired
	private ITenantDao itenantdao;
	
	@Override
	public Tenant addTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return itenantdao.save(tenant);
	}

	@Override
	public List<Tenant> viewAllTenants() {
		// TODO Auto-generated method stub
		return itenantdao.findAll();
	}
    @Override
	public Tenant viewTenantById(int tenantId) {
		// TODO Auto-generated method stub
		return itenantdao.findById(tenantId).get();
	}

	@Override
	public Tenant updateTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return itenantdao.save(tenant);
	}
	
	
	
    @Override
	public Boolean deleteTenant(int tenantId) {
		// TODO Auto-generated method stub
    	Tenant tenant=itenantdao.findById(tenantId).get();
        itenantdao.deleteById(tenantId);

        if(null==tenant)
        {
            return true;
        }
        return false;
		//return itenantdao.deleteTenantByID(tenantId);
	}

	@Override
	public Tenant validateTenat(int tenantId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
/*
 
package com.cg.onlineflatrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.onlineflatrental.dao.ITenantDao;
import com.cg.onlineflatrental.model.Tenant;

public class ITenantServiceImpl implements ITenantService {
	
	@Autowired


	@Override
	public Tenant addTenant(Tenant tenant) {
		return itenantdao.save(tenant);
	}

	@Override
	public List<Tenant> viewAllTenants() {
		return itenantdao.findAll();
	}

	@Override
	public Tenant viewTenantById(int tenant_id) {
		return itenantdao.findById(tenant_id).get();
	}

	@Override
	public Tenant updateTenant(Tenant tenant) {
		return itenantdao.save(tenant);
	}
	
	
	

	@Override
	public Tenant validateTenat(int tenant_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant deleteTenant(int tenant_id) {
		// TODO Auto-generated method stub
		return null;
	}
    
}


*/