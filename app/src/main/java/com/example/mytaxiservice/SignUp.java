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

public class SignUp extends Activity {

	EditText name, password, conPassword, phoneNum;
	Button signUp;
	String pass,user,phone;
	int flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		name=(EditText) findViewById(R.id.signName);
		password=(EditText) findViewById(R.id.signPass);
		conPassword=(EditText) findViewById(R.id.conPass);
		phoneNum=(EditText) findViewById(R.id.phone);
		signUp=(Button) findViewById(R.id.signBt);
		
		signUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(name.getText().toString().length()==0||password.getText().toString().length()==0||conPassword.getText().toString().length()==0||phoneNum.getText().toString().length()==0){
					Toast.makeText(getBaseContext(), "Please fill all fields!", Toast.LENGTH_SHORT).show();
				}
				
				else if( !password.getText().toString().equals(conPassword.getText().toString())){
					flag=0;
					Toast.makeText(getBaseContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
				}
				else if(name.getText().toString().length()<5 || name.getText().toString().contains(" ") || password.getText().toString().length()<5 || password.getText().toString().contains(" ")){
					flag=0;
					Toast.makeText(getBaseContext(), "Username and Password must be atleast 5 characters long!", Toast.LENGTH_SHORT).show();
				}
				else{
					user=name.getText().toString();
					pass = password.getText().toString();
					Toast.makeText(getBaseContext(), "Account created!"+Interface.userCount, Toast.LENGTH_SHORT).show();
					Interface.users[Interface.userCount] = new Users(Interface.userCount,user,pass,phone,1); //customer
					Interface.userCount++;
					flag=1;
				}
				
				if(flag==1){
					Intent login = new Intent(SignUp.this, Login.class);
					startActivity(login);
					finish(); 	
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
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
