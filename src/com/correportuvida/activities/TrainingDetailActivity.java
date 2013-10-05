package com.correportuvida.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.correportuvida.R;
import com.correportuvida.controllers.Controller;
import com.correportuvida.controllers.TrainingDetailController;

public class TrainingDetailActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_training_detail);
		
		Controller controller = new TrainingDetailController(this);
		controller.updateView();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.running, menu);
		return true;
	}

}
