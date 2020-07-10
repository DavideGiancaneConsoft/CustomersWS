package com.consoft.soapws.endpoint;

import javax.annotation.PostConstruct;

import com.consoft.soapws.api.ObjectFactory;


public abstract class AbstractEndpoint {
	
	protected static final String NAMESPACE_URI = "http://www.consoft.com/soapws/api";
	
	protected ObjectFactory objectFactory;
	
	@PostConstruct
	private void initialize() {
		objectFactory = new ObjectFactory();
	}

}
