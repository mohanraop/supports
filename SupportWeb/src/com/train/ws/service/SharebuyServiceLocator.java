/**
 * SharebuyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.train.ws.service;

public class SharebuyServiceLocator extends org.apache.axis.client.Service implements com.train.ws.service.SharebuyService {

    public SharebuyServiceLocator() {
    }


    public SharebuyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SharebuyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Sharebuy
    private java.lang.String Sharebuy_address = "http://localhost:8080/ShareTradingSystem/services/Sharebuy";

    public java.lang.String getSharebuyAddress() {
        return Sharebuy_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SharebuyWSDDServiceName = "Sharebuy";

    public java.lang.String getSharebuyWSDDServiceName() {
        return SharebuyWSDDServiceName;
    }

    public void setSharebuyWSDDServiceName(java.lang.String name) {
        SharebuyWSDDServiceName = name;
    }

    public com.train.ws.service.Sharebuy getSharebuy() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Sharebuy_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSharebuy(endpoint);
    }

    public com.train.ws.service.Sharebuy getSharebuy(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.train.ws.service.SharebuySoapBindingStub _stub = new com.train.ws.service.SharebuySoapBindingStub(portAddress, this);
            _stub.setPortName(getSharebuyWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSharebuyEndpointAddress(java.lang.String address) {
        Sharebuy_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.train.ws.service.Sharebuy.class.isAssignableFrom(serviceEndpointInterface)) {
                com.train.ws.service.SharebuySoapBindingStub _stub = new com.train.ws.service.SharebuySoapBindingStub(new java.net.URL(Sharebuy_address), this);
                _stub.setPortName(getSharebuyWSDDServiceName());
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
        if ("Sharebuy".equals(inputPortName)) {
            return getSharebuy();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.ws.train.com", "SharebuyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.ws.train.com", "Sharebuy"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Sharebuy".equals(portName)) {
            setSharebuyEndpointAddress(address);
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
