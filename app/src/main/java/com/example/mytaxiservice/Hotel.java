package com.example.mytaxiservice;

public class Hotel {
	public int hotelId;
	public String hotelName;
	public String location;
	public String phone;
	public int rating;
	
	Hotel(int hotelId, String hotelName, String location, String phone, int rating){
		this.hotelId=hotelId;
		this.hotelName=hotelName;
		this.location=location;
		this.phone = phone;
		this.rating=rating;
	}
}
