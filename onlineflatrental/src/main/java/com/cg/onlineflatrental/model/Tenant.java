package com.cg.onlineflatrental.model;

import org.springframework.stereotype.Component;

@Component
public class Tenant {
	
	private int tenant_id;
	private int age;
	private FlatAddress taddress;
  
	public Tenant()
	{
		super();
	}
	
	public Tenant(int tenant_id, int age, FlatAddress taddress) {
		super();
		this.tenant_id = tenant_id;
		this.age = age;
		this.taddress = taddress;
	}
	
	public void setTenantId(int tenant_id)
	{
		this.tenant_id=tenant_id;
	}
	public int getTenantId()
	{
		return tenant_id;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public int getAge()
	{
		return age;
	}
	public void setTAddress(FlatAddress taddress)
	{
		this.taddress=taddress;
	}
	public FlatAddress getTAddress()
	{
		return taddress;
	}
	@Override
	public String toString()
	{
		return "tenant [ TenantID" + tenant_id + "Age"+ age+"FlatAddress"+taddress+"]";
	}
}
