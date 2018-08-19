package com.example.mytaxiservice;

public class Interface {
	
	public static Users[] users = new Users[9999];
	public static int userCount=0;
	public static int currentUserId=-1;
	
	public static Taxi[] taxis = new Taxi[999];
	public static int taxiCount=0;
	
	public static Hotel[] hotels = new Hotel[999];
	public static int hotelCount=0;
	
	public static Booking[] bookings = new Booking[999];
	public static int bookingCount=0;
	
	public static String[] locations = {"Alexandria","Barangaroo","Docklands","Barangaroo","Central Business District","West Perth","East Perth"};
	
	public static String searchTaxi(){
		for(int i=0;i<taxiCount;i++){
			if(taxis[i].status==1){
				taxis[i].status=0;
				return taxis[i].taxiNum;
			}
		}
		return("none");
	}
}
