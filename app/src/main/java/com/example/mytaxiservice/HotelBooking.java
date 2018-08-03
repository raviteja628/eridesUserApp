package com.example.mytaxiservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HotelBooking extends Activity {

	EditText loc;
	TextView disp;
	Button search,backHotel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hotel_booking);
		loc = (EditText) findViewById(R.id.loc);
		disp = (TextView) findViewById(R.id.dispHotels);
		search = (Button) findViewById(R.id.search);
		backHotel = (Button) findViewById(R.id.backHotel);
		
		search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int flag=-1;
				int i;
				String dispHotels="";
				for(i=0;i<Interface.hotelCount;i++){
					if(loc.getText().toString().equalsIgnoreCase(Interface.hotels[i].location)){
						dispHotels+="Hotel Id: "+Interface.hotels[i].hotelId+"\nHotel Name: "+Interface.hotels[i].hotelName+"\nContact: "+Interface.hotels[i].phone+"\nRating: "+Interface.hotels[i].rating+"\n\n";
						flag=1;
					}
				}
				if(flag==-1)
					disp.setText("No hotels found in that vicinity!");
				else
					disp.setText(dispHotels);
			}
		});
		
		backHotel.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent menu = new Intent(HotelBooking.this, MenuActivity.class);
						startActivity(menu);
						finish();
					}
				});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hotel_booking, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
