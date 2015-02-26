package com.sai.training.core;

public class MainVehicle {

	public static void main(String[] args) 
	{
		//Vehicle vh = new Vehicle();

		TwoWheeler tw = new TwoWheeler();
		tw.setManufacturedYear(2014);
		tw.setCost(20155);
		System.out.println(tw.getCost());
	}

}
