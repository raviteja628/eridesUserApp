package com.example.mytaxiservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookingConfirmation extends Activity {

	TextView disp;
	Button back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_booking_confirmation);
		
		disp = (TextView) findViewById(R.id.disp);
		back = (Button) findViewById(R.id.conBack);
		
		String driver="",phone="";
		for(int i =0;i<Interface.taxiCount;i++){
			if(Interface.taxis[i].taxiNum == Interface.bookings[Interface.bookingCount-1].taxiNum){
				driver = Interface.taxis[i].driver;
				phone = Interface.taxis[i].phone;
				break;
			}
		}
		disp.setText("Booking Confirmation\n\nBooking ID: 00"+Interface.bookings[Interface.bookingCount-1].bookingId+"\nTaxi Number: "+Interface.bookings[Interface.bookingCount-1].taxiNum+"\nDriver name: "+driver+"\nDriver Contact: "+phone+"\n\nPick Up Location: "+Interface.bookings[Interface.bookingCount-1].pickUp+"\nDestination Location: "+Interface.bookings[Interface.bookingCount-1].destination+"\n\nPlease proceed to pay $ ***\n\nYour ride is arriving within the next 10 minutes.");
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent menu = new Intent(BookingConfirmation.this, MenuActivity.class);
				startActivity(menu);
				finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.booking_confirmation, menu);
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
