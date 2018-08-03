package com.example.mytaxiservice;

public class Taxi {
	public String taxiNum;
	public String driver;
	public String phone;
	public int status;
	
	Taxi(String taxiNum, String driver, String phone){
		this.taxiNum=taxiNum;
		this.driver=driver;
		this.phone=phone;
		status=1; //available
	}
}
