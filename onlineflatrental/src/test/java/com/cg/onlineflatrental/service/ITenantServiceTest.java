package com.cg.onlineflatrental.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.cg.onlineflatrental.dao.ITenantDao;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.model.FlatAddress;
import com.cg.onlineflatrental.model.Tenant;
import com.cg.onlineflatrental.services.ITenantService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ITenantServiceTest {
	
	 @MockBean
	    private ITenantDao itenantdao;
	 @Autowired
	    private ITenantService itenantservice;

	@Test
	public void testAddTenant01()throws TenantNotFoundException {
		Tenant tenant=new Tenant();
		tenant.setTenantId(1);
		tenant.setAge(18);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(101);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testAddTenant02()throws TenantNotFoundException {
		Tenant tenant=new Tenant();
		tenant.setTenantId(1001);
		tenant.setAge(16);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(1100);
		flatAddress.setHouseNo(1050);
		flatAddress.setStreet("M G4@Road");
		flatAddress.setCity("Bangalore *#");
		flatAddress.setState("Karnataka %");
		flatAddress.setCity("India");
		flatAddress.setPin(56003410);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testAddTenant03()throws TenantNotFoundException {
		Tenant tenant=new Tenant();
		tenant.setTenantId(6);
		tenant.setAge(20);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testAddTenant04()throws TenantNotFoundException {
		Tenant tenant=new Tenant();
		tenant.setTenantId(6);
		tenant.setAge(100);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testAddTenant05()throws TenantNotFoundException {
		Tenant tenant=new Tenant();
		tenant.setTenantId(1001);
		tenant.setAge(102);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(1100);
		flatAddress.setHouseNo(1050);
		flatAddress.setStreet("M G4@Road");
		flatAddress.setCity("Bangalore *#");
		flatAddress.setState("Karnataka %");
		flatAddress.setCity("India");
		flatAddress.setPin(56003410);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testUpdateTenant01()throws TenantNotFoundException {
		Tenant tenant=new Tenant();
		tenant.setTenantId(6);
		tenant.setAge(99);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(105);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),16);
	}

	@Test
	public void testUpdateTenant02()throws TenantNotFoundException {
		Tenant tenant=new Tenant();
		tenant.setTenantId(6);
		tenant.setAge(99);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(1000);
		flatAddress.setHouseNo(0);
		flatAddress.setStreet("M G4Road");
		flatAddress.setCity("Bangalore 4");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(5600340);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(0);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(flatAddress.getCity(),"Bangalore");
	}
	
	@Test
	public void testUpdateTenant03()throws TenantNotFoundException {
		Tenant tenant=new Tenant();
		tenant.setTenantId(6);
		tenant.setAge(101);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(105);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),101);
	}
	
}
