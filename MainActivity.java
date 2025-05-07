package com.emmycodezstudio.torch;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;
import android.view.ViewDebug.*;



public class MainActivity extends Activity {
	private Camera camera;
	private boolean isFlashOn = false;
	
	TextView developer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		String developerText = "EmmycodezStudio";
		developer = findViewById(R.id.dev_text);
		developer.setText("Developer: "+developerText);
		
		ToggleButton btnflash = findViewById(R.id.mainToggleButton);
		btnflash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleFlashlight();
			}
		});
	}

	private void toggleFlashlight() {
		try {
			if (camera == null) camera = Camera.open();
			Camera.Parameters params = camera.getParameters();
			if (!isFlashOn) {
				params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
				camera.setParameters(params);
				camera.startPreview();
				isFlashOn = true;
			} else {
				params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
				camera.setParameters(params);
				camera.stopPreview();
				isFlashOn = false;
			}
		} catch (Exception e) { e.printStackTrace(); }
	}

	
	@Override
	protected void onDestroy() {
		if (camera != null) camera.release();
		super.onDestroy();
	}
}
