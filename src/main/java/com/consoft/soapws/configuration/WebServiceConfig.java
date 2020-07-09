package com.consoft.soapws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.consoft.soapws.endpoint.CustomerEndpoint;

@Configuration
@EnableWs
@ComponentScan("com.consoft.soapws")
public class WebServiceConfig{
	
	private static final String NAMESPACE_URI = "http://www.consoft.com/soapws/api";
	
	@Bean(name = "services")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema servicesSchema) {
		DefaultWsdl11Definition wsd11Definition = new DefaultWsdl11Definition();
		wsd11Definition.setPortTypeName("Services");
		wsd11Definition.setLocationUri("/ws");
		wsd11Definition.setTargetNamespace(NAMESPACE_URI);
		wsd11Definition.setSchema(servicesSchema);
		
		System.out.println("WSDL Defined");
		return wsd11Definition;
	}
	
	@Bean
	public XsdSchema servicesSchema() {
		System.out.println("CONFIG");
		return new SimpleXsdSchema(new ClassPathResource("services.xsd"));
	}
}
