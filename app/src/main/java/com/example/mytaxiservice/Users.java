package com.example.mytaxiservice;

public class Users {
	public int id;
	public String username;
	public String password;
	public String phone;
	public int type; //0 for admins, 1 for customers
	
	Users(int id,String username,String password,String phone,int type){
		this.id=id;
		this.username=username;
		this.password=password;
		this.phone=phone;
		this.type=type;	
	}
}
