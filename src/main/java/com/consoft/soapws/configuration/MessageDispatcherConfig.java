package com.consoft.soapws.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.transport.http.support.AbstractAnnotationConfigMessageDispatcherServletInitializer;

@Configuration
public class MessageDispatcherConfig extends AbstractAnnotationConfigMessageDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebServiceConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}
}
