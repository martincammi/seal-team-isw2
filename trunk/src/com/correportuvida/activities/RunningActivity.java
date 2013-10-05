package com.correportuvida.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.correportuvida.R;
import com.correportuvida.controllers.Controller;
import com.correportuvida.controllers.RunningController;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RunningActivity extends FragmentActivity  {
	
	private Controller _controller;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_running);

		//Sets Controller to Trainer
		_controller = new RunningController(this);
		_controller.updateView();

	}

	@Override
	public void onBackPressed()
	{
		_controller.buttonBackPressed();
	}
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalle_plan, menu);
		return true;
	}
	
}
