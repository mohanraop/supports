package com.train.ws.service;

public class ShareInfromationProxy implements com.train.ws.service.ShareInfromation {
  private String _endpoint = null;
  private com.train.ws.service.ShareInfromation shareInfromation = null;
  
  public ShareInfromationProxy() {
    _initShareInfromationProxy();
  }
  
  public ShareInfromationProxy(String endpoint) {
    _endpoint = endpoint;
    _initShareInfromationProxy();
  }
  
  private void _initShareInfromationProxy() {
    try {
      shareInfromation = (new com.train.ws.service.ShareInfromationServiceLocator()).getShareInfromation();
      if (shareInfromation != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shareInfromation)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shareInfromation)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shareInfromation != null)
      ((javax.xml.rpc.Stub)shareInfromation)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.train.ws.service.ShareInfromation getShareInfromation() {
    if (shareInfromation == null)
      _initShareInfromationProxy();
    return shareInfromation;
  }
  
  public void insertShare(java.lang.String shareName, int sharePrice) throws java.rmi.RemoteException{
    if (shareInfromation == null)
      _initShareInfromationProxy();
    shareInfromation.insertShare(shareName, sharePrice);
  }
  
  
}