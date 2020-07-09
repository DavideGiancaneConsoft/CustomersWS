package com.consoft.soapws.endpoint;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.consoft.soapws.api.Customer;
import com.consoft.soapws.api.CustomersRequest;
import com.consoft.soapws.api.CustomersResponse;
import com.consoft.soapws.api.ObjectFactory;
import com.consoft.soapws.service.CustomerServices;

@Endpoint
public class CustomerEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.consoft.com/soapws/api";
	
	@Autowired
	private CustomerServices customerServices;
	
	private ObjectFactory objectFactory;
	
	@PostConstruct
	public void inizialize() {
		objectFactory = new ObjectFactory();
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI,
			localPart = "CustomersRequest")
	@ResponsePayload
	public CustomersResponse getCustomersRequest(
			@RequestPayload CustomersRequest request){
		
		CustomersResponse response = objectFactory.createCustomersResponse();
		List<Customer> customers = customerServices.getCustomers();
		response.getCustomers().addAll(customers);
		return response;
	}

}
