//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.2 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andr� persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.09 alle 03:13:31 PM CEST 
//


package com.consoft.soapws.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="newCustomer" type="{http://www.consoft.com/soapws/api}customer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "newCustomer"
})
@XmlRootElement(name = "NewCustomerRequest")
public class NewCustomerRequest {

    @XmlElement(required = true)
    protected Customer newCustomer;

    /**
     * Recupera il valore della propriet� newCustomer.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getNewCustomer() {
        return newCustomer;
    }

    /**
     * Imposta il valore della propriet� newCustomer.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setNewCustomer(Customer value) {
        this.newCustomer = value;
    }

}
