package com.train.ws.service;

import java.rmi.RemoteException;

public class CurrencyProxy implements com.train.ws.service.Currency {
  private String _endpoint = null;
  private com.train.ws.service.Currency currency = null;
  
  public CurrencyProxy() {
    _initCurrencyProxy();
  }
  
  public CurrencyProxy(String endpoint) {
    _endpoint = endpoint;
    _initCurrencyProxy();
  }
  
  private void _initCurrencyProxy() {
    try {
      currency = (new com.train.ws.service.CurrencyServiceLocator()).getCurrency();
      if (currency != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)currency)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)currency)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (currency != null)
      ((javax.xml.rpc.Stub)currency)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.train.ws.service.Currency getCurrency() {
    if (currency == null)
      _initCurrencyProxy();
    return currency;
  }
  
  public java.lang.String getCountry(java.lang.String name) throws java.rmi.RemoteException{
    if (currency == null)
      _initCurrencyProxy();
    return currency.getCountry(name);
  }
  
  public static void main(String[] args) throws RemoteException {
	  CurrencyProxy proxy = new CurrencyProxy();
	  
	  System.out.println(proxy.getCountry("India"));
}
  
  
}