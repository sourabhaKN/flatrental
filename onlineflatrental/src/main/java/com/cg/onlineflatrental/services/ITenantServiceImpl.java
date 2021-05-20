package com.cg.onlineflatrental.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.dao.ITenantDao;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.model.Tenant;

@Service
@Transactional
public class ITenantServiceImpl implements ITenantService {

	@Autowired
	private ITenantDao itenantdao;
	
	String TenantIdNotFound="flat with given id was not found";
	
	@Override
	public Tenant addTenant(Tenant tenant)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		validateTenant(tenant);
		return itenantdao.save(tenant);
	}

	@Override
	public List<Tenant> viewAllTenants() {
		// TODO Auto-generated method stub
		return itenantdao.findAll();
	}
    @Override
	public Tenant viewTenantById(int tenantId)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		Optional<Tenant> optional= itenantdao.findById(tenantId);
		if(optional.isPresent())
		{
			
			Tenant tenant=optional.get();
		    return tenant;
			
		}
		else
		{
			throw new TenantNotFoundException("Tenant ID not found");
	}
    }

	@Override
	public Tenant updateTenant(Tenant tenant)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		Optional<Tenant> optional= itenantdao.findById(tenant.getTenantId());
		if(optional.isPresent())
		{
			validateTenant(tenant);
			 return itenantdao.save(tenant);

		}
		else
		  		throw new TenantNotFoundException("Tenant ID not found");
	}
	
	
	
    @Override
	public Boolean deleteTenant(int tenantId)throws TenantNotFoundException {
		// TODO Auto-generated method stub
    	Optional<Tenant> optional=itenantdao.findById(tenantId);
        itenantdao.deleteById(tenantId);

        if(optional.isPresent())
        {
        	 return true;
        }
       
        throw new TenantNotFoundException("Tenant ID not found");
		//return itenantdao.deleteTenantByID(tenantId);
	}


	@Override
	public Tenant validateTenat(int tenantId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void validateTenant(Tenant tenant)throws TenantNotFoundException
	{
		//boolean flag=false;
	//	if(flag==false)
	//	{
	//		throw new TenantNotFoundException("Tenant details cannot be null");
		//}
	//	else {
			validateTenantId(tenant.getTenantId());
			validateTenantAge(tenant.getAge());
			validateTenantAddressId(tenant.getFlatAddress().getAddressId());
			validateTenantHouseNo(tenant.getFlatAddress().getHouseNo());
			validateTenantStreet(tenant.getFlatAddress().getStreet());
			validateTenantCity(tenant.getFlatAddress().getCity());
			validateTenantState(tenant.getFlatAddress().getState());
			validateTenantCountry(tenant.getFlatAddress().getCountry());
			validateTenantPin(tenant.getFlatAddress().getPin());
		//	flag=true;
	//	}
	//	return flag;
	}

	public static Boolean validateTenantCountry(String country)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(country.isEmpty())
		{
			throw new TenantNotFoundException("Country cannot be Empty");
		}
		else if (!country.matches("^[a-zA-Z ][A-Za-z\\s]+$"))
		{
			throw new TenantNotFoundException("Country cannot contain Numbers or Special Characters");
		}
		else
		{
			flag=true;
		}
		return flag;
		
	}

	private static Boolean validateTenantPin(int pin)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(pin<=0)
		{
			throw new TenantNotFoundException("PinCode cannot be negative");	
		}
		else if(Integer.toString(pin).length() != 6)
		{
			throw new TenantNotFoundException("PinCode should be of length 6");		
		}
		else if(!Integer.toString(pin).matches("^[0-9]+$"))
		{
			throw new TenantNotFoundException("PinCode cannot contain Alphabets or Special Characters");	
		}
		else
		{
			flag=true;
		}
		return flag;
		
	}

	private static Boolean validateTenantState(String state)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(state.isEmpty())
		{
			throw new TenantNotFoundException("State cannot be Empty");
		}
		else if (!state.matches("^[a-zA-Z ][A-Za-z\\s]+$"))
		{
			throw new TenantNotFoundException("State cannot contain Numbers or Special Characters");
		}
		else
		{
			flag=true;
		}
		return flag;	
	}

	private static Boolean validateTenantCity(String city)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(city.isEmpty())
		{
			throw new TenantNotFoundException("City cannot be Empty");
		}
		else if (!city.matches("^[a-zA-Z ][A-Za-z\\s]+$"))
		{
			throw new TenantNotFoundException("City cannot contain Numbers or Special Characters");
		}
		else
		{
			flag=true;
		}
		return flag;	
		
	}

	private static Boolean validateTenantStreet(String street)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(street.isEmpty())
		{
			throw new TenantNotFoundException("Street cannot be Empty");
		}
		else if (!street.matches("^[A-Za-z][A-Za-z\\s]+$"))
		{
			throw new TenantNotFoundException("Street cannot contain Numbers or Special Characters");
		}
		else
		{
			flag=true;
		}
		return flag;
		
	}

	private static Boolean validateTenantHouseNo(int houseNo)throws TenantNotFoundException{
		// TODO Auto-generated method stub
		boolean flag=false;
		if(houseNo <= 0 || Integer.toString(houseNo).isEmpty() )
		{
			throw new TenantNotFoundException("House Number cannot be Empty or 0 or Negative");
		}
		else
		{
			flag=true;
		}
			return flag;
		
	}

	private static Boolean validateTenantAddressId(int addressId)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(addressId > 0 && addressId<1000)
		{
			flag=true;			
		}
		else
		{
			throw new TenantNotFoundException("Tenant ID cannot be 0 or negative or greater than 1000");
		}
		return flag;
	}

	
	private static Boolean validateTenantAge(int age)throws TenantNotFoundException {
		
		boolean flag=false;
		if(age<18)
		{
			throw new TenantNotFoundException("Tenant age should be greater than 18");
		}
		else
		{
			flag=true;
		}
		return flag;
	}

	private static Boolean validateTenantId(int tenantId)throws TenantNotFoundException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(tenantId > 0 && tenantId<1000)
		{
			flag=true;			
		}
		else
		{
			throw new TenantNotFoundException("Tenant ID cannot be 0 or negative or greater than 1000");
		}
		return flag;
		
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