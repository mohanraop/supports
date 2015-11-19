package com.train.ws.service;

import java.rmi.RemoteException;

public class SharebuyProxy implements com.train.ws.service.Sharebuy {
  private String _endpoint = null;
  private com.train.ws.service.Sharebuy sharebuy = null;
  
  public SharebuyProxy() {
    _initSharebuyProxy();
  }
  
  public SharebuyProxy(String endpoint) {
    _endpoint = endpoint;
    _initSharebuyProxy();
  }
  
  private void _initSharebuyProxy() {
    try {
      sharebuy = (new com.train.ws.service.SharebuyServiceLocator()).getSharebuy();
      if (sharebuy != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sharebuy)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sharebuy)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sharebuy != null)
      ((javax.xml.rpc.Stub)sharebuy)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.train.ws.service.Sharebuy getSharebuy() {
    if (sharebuy == null)
      _initSharebuyProxy();
    return sharebuy;
  }
  
  public java.lang.String getShare(java.lang.String shareName, int shareqntity) throws java.rmi.RemoteException{
    if (sharebuy == null)
      _initSharebuyProxy();
    return sharebuy.getShare(shareName, shareqntity);
  }
  public static void main(String[] args)   {
		 
		
		  SharebuyProxy proxy = new SharebuyProxy();
		  try {
			System.out.println(proxy.getShare("Infosys",5));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
  }
}