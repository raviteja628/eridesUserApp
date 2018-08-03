package com.example.mytaxiservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        
        start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Interface.users[Interface.userCount] = new Users(Interface.userCount,"admin1","adminx","1234567890",0); //admin
				Interface.userCount++;
				Interface.users[Interface.userCount] = new Users(Interface.userCount,"admin2","adminy","0987654321",0); //admin
				Interface.userCount++;
				Interface.users[Interface.userCount] = new Users(Interface.userCount,"janet","qweqwe","1593578524",1); //customer
				Interface.userCount++;
				Interface.users[Interface.userCount] = new Users(Interface.userCount,"chandler","asdasd","3579512846",1); //customer
				Interface.userCount++;
				
				Interface.taxis[Interface.taxiCount] = new Taxi("AD1234","Robert Bing","1515959565"); //taxi
				Interface.taxiCount++;
				Interface.taxis[Interface.taxiCount] = new Taxi("SY2457","Jammie Geller","1455415655"); //taxi
				Interface.taxiCount++;
				Interface.taxis[Interface.taxiCount] = new Taxi("MB6826","Nathan Tribiani","1838254679"); //taxi
				Interface.taxiCount++;
				Interface.taxis[Interface.taxiCount] = new Taxi("SY1234","Billy Adams","1595753528"); //taxi
				Interface.taxiCount++;
				
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"A Inn","Alexandria","32146598745",4); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"B Inn","Barangaroo","98745632115",5); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"C Inn","Alexandria","1874569871",3); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"D Inn","Docklands","1020304050",2); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"E Inn","Barangaroo","5060401020",4); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"F Inn","Barangaroo","1010202030",5); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"G Inn","Docklands","7080901020",5); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"H Inn","Central Business District","9010022125",4); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"I Inn","Central Business District","0101002125",5); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"J Inn","Central Business District","3214105635",3); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"K Inn","West Perth","3702956835",4); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"L Inn","East Perth","3702165635",4); //taxi
				Interface.hotelCount++;
				Interface.hotels[Interface.hotelCount] = new Hotel(Interface.hotelCount,"M Inn","East Perth","4682165635",5); //taxi
				Interface.hotelCount++;
				
				Intent login = new Intent(MainActivity.this, Login.class);
				startActivity(login);
				finish();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
