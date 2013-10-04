package com.correportuvida.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.correportuvida.R;

public class TrainingDetailActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_training_detail);
		
		TextView buttonStart = (TextView) findViewById(R.id.button_start);
		
		buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	goToRunningActivity(v);
            }
        });
		
	}
	
	//TODO: refactor, codigo duplicado
	public void goToRunningActivity(View view) {
    	Intent intent = new Intent(this, RunningActivity.class);
    	startActivity(intent);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.running, menu);
		return true;
	}

}
