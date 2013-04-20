/**
 * CurrencyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.train.ws.service;

public interface CurrencyService extends javax.xml.rpc.Service {
    public java.lang.String getCurrencyAddress();

    public com.train.ws.service.Currency getCurrency() throws javax.xml.rpc.ServiceException;

    public com.train.ws.service.Currency getCurrency(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
