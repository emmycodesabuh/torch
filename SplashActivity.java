package com.emmycodezstudio.torch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.content.*;
import android.os.*;

public class SplashActivity extends Activity
{
	Intent iHome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		
		iHome = new Intent(SplashActivity.this, MainActivity.class);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(iHome);
			}
		}, 2500);
	}
}