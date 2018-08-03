package com.example.mytaxiservice;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{
	
	EditText name, password;
	Button login, sign;
	String pass, user;
	ArrayList<String> reg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		name=(EditText) findViewById(R.id.logName);
		password=(EditText) findViewById(R.id.logPass);
		login=(Button) findViewById(R.id.loginBt);
		sign=(Button) findViewById(R.id.signBt);
			
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					int flag=0;
					user=name.getText().toString();
					pass=password.getText().toString();
					for(int i=0; i<Interface.userCount;i++){
						if(Interface.users[i].username.equals(user)&&Interface.users[i].password.equals(pass)){
							Interface.currentUserId = Interface.users[i].id;
							flag=1;
							if(Interface.users[i].type==1)
								Toast.makeText(getBaseContext(), "Successfully logged in with user: "+user , Toast.LENGTH_SHORT).show();
							else
								Toast.makeText(getBaseContext(), "Successfully logged in with Admin: "+user, Toast.LENGTH_SHORT).show();
							Intent menu = new Intent(Login.this, MenuActivity.class);
							startActivity(menu);
							finish();
							break;
						}
					}
					if(flag==0)
						Toast.makeText(getBaseContext(), "Invalid Username and/or Password", Toast.LENGTH_SHORT).show();	
			}
		});
		
		sign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				Intent menu = new Intent(Login.this, SignUp.class);
				startActivity(menu);
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
