package com.cg.onlineflatrentaltest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.onlineflatrental.controller.TenantController;
import com.cg.onlineflatrental.model.FlatAddress;
import com.cg.onlineflatrental.model.Tenant;
import com.cg.onlineflatrental.services.ITenantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TenantController.class)
class controllerTest{

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ITenantService itenantservice;

	@Test
	public void testAddTenant() throws Exception{
		String URI="/Tenant/addTenant";
		Tenant tenant=new Tenant();
		FlatAddress flatAddress=new FlatAddress();

		flatAddress.setHouseNo(10);
		flatAddress.setCity("Bangalore");
		flatAddress.setStreet("nagpura");
		flatAddress.setState("Karnataka");
		flatAddress.setCountry("India");
		flatAddress.setPin(560086);
		tenant.setTenantId(19);
		tenant.setAge(20);
		tenant.setFlatAddress(flatAddress);
		String jsonInput = this.convertToJson(tenant);

		Mockito.when(itenantservice.addTenant(Mockito.any(Tenant.class))).thenReturn(tenant);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	private String convertToJson(Object tenant) throws JsonProcessingException {
		ObjectMapper objectMapper  = new ObjectMapper();
		return objectMapper.writeValueAsString(tenant);
	}


}
