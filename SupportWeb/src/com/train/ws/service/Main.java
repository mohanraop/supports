package com.train.ws.service;

import java.rmi.RemoteException;

public class Main {
	public static void main(String[] args) throws RemoteException {
		CurrencyProxy currencyProxy = new CurrencyProxy();
		System.out.println(currencyProxy.getCountry("India"));
		int i=15;
		ShareInfromationProxy shareInfromationProxy = new ShareInfromationProxy();
		shareInfromationProxy.insertShare("TCS", 1500);
	}
}
