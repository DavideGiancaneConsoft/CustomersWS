package com.consoft.soapws.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.consoft.soapws.api.Customer;
import com.consoft.soapws.api.DeleteCustomerRequest;
import com.consoft.soapws.api.DeleteCustomerResponse;
import com.consoft.soapws.api.GetCustomersRequest;
import com.consoft.soapws.api.GetCustomersResponse;
import com.consoft.soapws.api.NewCustomerRequest;
import com.consoft.soapws.api.NewCustomerResponse;
import com.consoft.soapws.service.CustomerServices;

@Endpoint
public class CustomerEndpoint extends AbstractEndpoint{
		
	@Autowired
	private CustomerServices customerServices;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomersRequest")
	@ResponsePayload
	public GetCustomersResponse getCustomers(@RequestPayload GetCustomersRequest request){
		GetCustomersResponse response = objectFactory.createGetCustomersResponse();
		List<Customer> customers = customerServices.getCustomers();
		response.getCustomers().addAll(customers);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "newCustomerRequest")
	@ResponsePayload
	public NewCustomerResponse newCustomer(@RequestPayload NewCustomerRequest request) {
		Customer c = request.getNewCustomer();
		NewCustomerResponse response = objectFactory.createNewCustomerResponse();
		String result = customerServices.addCustomer(c);
		response.setRegistrationResult(result);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart="deleteCustomerRequest")
	@ResponsePayload
	public DeleteCustomerResponse deleteCustomer(@RequestPayload DeleteCustomerRequest request) {
		int customerID = request.getCustomerToDeleteID();
		DeleteCustomerResponse response = objectFactory.createDeleteCustomerResponse();
		String result = customerServices.deleteCustomer(customerID);
		response.setDeletionResult(result);
		return response;
	}

}
