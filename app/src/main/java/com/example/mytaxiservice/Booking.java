package com.example.mytaxiservice;

public class Booking {
	public int bookingId;
	public int userId;
	public String taxiNum;
	public String pickUp;
	public String destination;
	public int status;
	
	Booking(int bookingId, int userId, String taxiNum, String pickUp, String destination){
		this.bookingId=bookingId;
		this.taxiNum=taxiNum;
		this.userId=userId;
		this.taxiNum=taxiNum;
		this.pickUp=pickUp;
		this.destination=destination;
		status = 1;
	}
}
