/**
 * CurrencyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.train.ws.service;

public class CurrencyServiceLocator extends org.apache.axis.client.Service implements com.train.ws.service.CurrencyService {

    public CurrencyServiceLocator() {
    }


    public CurrencyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CurrencyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Currency
    private java.lang.String Currency_address = "http://localhost:8080/ShareTradingSystem/services/Currency";

    public java.lang.String getCurrencyAddress() {
        return Currency_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CurrencyWSDDServiceName = "Currency";

    public java.lang.String getCurrencyWSDDServiceName() {
        return CurrencyWSDDServiceName;
    }

    public void setCurrencyWSDDServiceName(java.lang.String name) {
        CurrencyWSDDServiceName = name;
    }

    public com.train.ws.service.Currency getCurrency() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Currency_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCurrency(endpoint);
    }

    public com.train.ws.service.Currency getCurrency(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.train.ws.service.CurrencySoapBindingStub _stub = new com.train.ws.service.CurrencySoapBindingStub(portAddress, this);
            _stub.setPortName(getCurrencyWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCurrencyEndpointAddress(java.lang.String address) {
        Currency_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.train.ws.service.Currency.class.isAssignableFrom(serviceEndpointInterface)) {
                com.train.ws.service.CurrencySoapBindingStub _stub = new com.train.ws.service.CurrencySoapBindingStub(new java.net.URL(Currency_address), this);
                _stub.setPortName(getCurrencyWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Currency".equals(inputPortName)) {
            return getCurrency();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.ws.train.com", "CurrencyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.ws.train.com", "Currency"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Currency".equals(portName)) {
            setCurrencyEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
