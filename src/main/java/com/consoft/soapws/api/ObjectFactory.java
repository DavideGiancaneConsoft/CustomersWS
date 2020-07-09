//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.2 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.09 alle 02:29:10 PM CEST 
//


package com.consoft.soapws.api;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.consoft.soapws.api package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.consoft.soapws.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomersRequest }
     * 
     */
    public CustomersRequest createCustomersRequest() {
        return new CustomersRequest();
    }

    /**
     * Create an instance of {@link CustomersResponse }
     * 
     */
    public CustomersResponse createCustomersResponse() {
        return new CustomersResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link NewCustomerRequest }
     * 
     */
    public NewCustomerRequest createNewCustomerRequest() {
        return new NewCustomerRequest();
    }

    /**
     * Create an instance of {@link NewCustomerResponse }
     * 
     */
    public NewCustomerResponse createNewCustomerResponse() {
        return new NewCustomerResponse();
    }

    /**
     * Create an instance of {@link DeleteCustomerRequest }
     * 
     */
    public DeleteCustomerRequest createDeleteCustomerRequest() {
        return new DeleteCustomerRequest();
    }

    /**
     * Create an instance of {@link DeleteCustomerResponse }
     * 
     */
    public DeleteCustomerResponse createDeleteCustomerResponse() {
        return new DeleteCustomerResponse();
    }

    /**
     * Create an instance of {@link RegionsRequest }
     * 
     */
    public RegionsRequest createRegionsRequest() {
        return new RegionsRequest();
    }

    /**
     * Create an instance of {@link RegionsResponse }
     * 
     */
    public RegionsResponse createRegionsResponse() {
        return new RegionsResponse();
    }

    /**
     * Create an instance of {@link Region }
     * 
     */
    public Region createRegion() {
        return new Region();
    }

    /**
     * Create an instance of {@link CitiesByRegionRequest }
     * 
     */
    public CitiesByRegionRequest createCitiesByRegionRequest() {
        return new CitiesByRegionRequest();
    }

    /**
     * Create an instance of {@link CitiesByRegionResponse }
     * 
     */
    public CitiesByRegionResponse createCitiesByRegionResponse() {
        return new CitiesByRegionResponse();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

}
