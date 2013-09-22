package com.correportuvida.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.correportuvida.R;

public class DetallePlanActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_plan);
		
		Button buttonStart = (Button) findViewById(R.id.button_start);
		
		buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	goToRunningActivity(v);
            }
        });
	}
	
	 public void goToRunningActivity(View view) {
    	Intent intent = new Intent(this, RunningActivity.class);
    	//intent.putExtra(EXTRA_MESSAGE, view.getId());
    	startActivity(intent);
	    	
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalle_plan, menu);
		return true;
	}

}
