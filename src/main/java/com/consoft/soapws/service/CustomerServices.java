package com.consoft.soapws.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.consoft.soapws.api.Customer;

@Service
public class CustomerServices {

	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";
	
	private static final Map<Integer, Customer> customers = new HashMap<>();
	
	private static int idCounter = 4;
		
		@PostConstruct
		public void initialize() {
			Customer c1 = new Customer();
			c1.setId(1);
			c1.setFirstName("Davide");
			c1.setLastName("Giancane");
			c1.setPhoneNumber("34891910");
			c1.setCity("MI");
			
			Customer c2 = new Customer();
			c2.setId(2);
			c2.setFirstName("Simone");
			c2.setLastName("Romagna");
			c2.setPhoneNumber("1212349");
			c2.setCity("TA");
			
			Customer c3 = new Customer();
			c3.setId(3);
			c3.setFirstName("Francesca");
			c3.setLastName("Taronno");
			c3.setPhoneNumber("476783");
			c3.setCity("TO");
			
			customers.put(c1.getId(), c1);
			customers.put(c2.getId(), c2);
			customers.put(c3.getId(), c3);
		}
		
		public List<Customer> getCustomers(){
			return new LinkedList<Customer>(customers.values());
		}
		
		public String addCustomer(Customer c) {
			customers.put(idCounter++, c);
			return SUCCESS;
		}
		
		public String deleteCustomer(int id) {
			customers.remove(id);
			return FAILURE;
		}
}
