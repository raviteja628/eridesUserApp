package com.example.mytaxiservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity {
	
	private Button logout;
	private Button taxi;
	private Button hotel;
	private Button hist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		logout=(Button) findViewById(R.id.logOut);
		taxi=(Button) findViewById(R.id.taxi);
		hotel=(Button) findViewById(R.id.hotel);
		hist=(Button) findViewById(R.id.hist);
		
		taxi.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent TaxiBooking = new Intent(MenuActivity.this, TaxiBooking.class);
				startActivity(TaxiBooking);
				finish(); 	
			}
		});
		hotel.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent hotelPage = new Intent(MenuActivity.this, HotelBooking.class);
				startActivity(hotelPage);
				finish(); 	
			}
		});
		hist.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent login = new Intent(MenuActivity.this, Login.class);
				startActivity(login);
				finish(); 	
			}
		});
		
		logout.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent login = new Intent(MenuActivity.this, Login.class);
				startActivity(login);
				finish(); 	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
