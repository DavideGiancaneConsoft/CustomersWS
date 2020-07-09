package com.consoft.soapws.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.consoft.soapws.api.Customer;
import com.consoft.soapws.api.CustomersRequest;
import com.consoft.soapws.api.CustomersResponse;
import com.consoft.soapws.api.DeleteCustomerRequest;
import com.consoft.soapws.api.DeleteCustomerResponse;
import com.consoft.soapws.api.NewCustomerRequest;
import com.consoft.soapws.api.NewCustomerResponse;
import com.consoft.soapws.service.CustomerServices;

@Endpoint
public class CustomerEndpoint extends AbstractEndpoint{
		
	@Autowired
	private CustomerServices customerServices;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CustomersRequest")
	@ResponsePayload
	public CustomersResponse getCustomers(@RequestPayload CustomersRequest request){
		CustomersResponse response = objectFactory.createCustomersResponse();
		List<Customer> customers = customerServices.getCustomers();
		response.getCustomers().addAll(customers);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "NewCustomerRequest")
	@ResponsePayload
	public NewCustomerResponse newCustomer(@RequestPayload NewCustomerRequest request) {
		Customer c = request.getNewCustomer();
		NewCustomerResponse response = objectFactory.createNewCustomerResponse();
		String result = customerServices.addCustomer(c);
		response.setRegistrationResult(result);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart="DeleteCustomerRequest")
	@ResponsePayload
	public DeleteCustomerResponse deleteCustomer(@RequestPayload DeleteCustomerRequest request) {
		int customerID = request.getCustomerToDeleteID();
		DeleteCustomerResponse response = objectFactory.createDeleteCustomerResponse();
		String result = customerServices.deleteCustomer(customerID);
		response.setDeletionResult(result);
		return response;
	}

}
