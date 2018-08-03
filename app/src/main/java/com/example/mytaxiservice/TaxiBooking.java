package com.example.mytaxiservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TaxiBooking extends Activity {

	EditText pickupLoc, destLoc;
	Button book;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi_booking);
		
		pickupLoc=(EditText) findViewById(R.id.pickUpLoc);
		destLoc=(EditText) findViewById(R.id.destLoc);
		book=(Button) findViewById(R.id.bookBt);
		
		book.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(pickupLoc.getText().toString().isEmpty() || destLoc.getText().toString().isEmpty()){
					Toast.makeText(getBaseContext(), "Please fill all fields!", Toast.LENGTH_SHORT).show();
				}
				else if(pickupLoc.getText().toString().equalsIgnoreCase(destLoc.getText().toString())){
					Toast.makeText(getBaseContext(), "Pick Up and Destination locations cannot be same!", Toast.LENGTH_SHORT).show();
				}
				else{
					int flag=0;
					for(int i=0;i<Interface.locations.length;i++){
						if(pickupLoc.getText().toString().equalsIgnoreCase(Interface.locations[i]) || destLoc.getText().toString().equalsIgnoreCase(Interface.locations[i])){
							flag++;
							if(flag==2)
								break;
						}
					}
					if(flag==2){
						String taxiNum=Interface.searchTaxi();
						if(taxiNum.equals("none"))
							Toast.makeText(getBaseContext(), "Sorry! We are currently out of taxis! Please check back in some time!", Toast.LENGTH_SHORT).show();
						else{
							Interface.bookings[Interface.bookingCount] = new Booking(Interface.bookingCount,Interface.currentUserId,taxiNum,pickupLoc.getText().toString(),destLoc.getText().toString());
							Toast.makeText(getBaseContext(), "Taxi booked! Booking ID: 00"+Interface.bookingCount, Toast.LENGTH_SHORT).show();
							Interface.bookingCount++;
							
							Intent confirm = new Intent(TaxiBooking.this, BookingConfirmation.class);
							startActivity(confirm);
							finish();
						}
					}
					else{
						Toast.makeText(getBaseContext(), "We do not provide service in one of the towns that you mentioned!", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi_booking, menu);
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
