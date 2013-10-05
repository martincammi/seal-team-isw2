package com.correportuvida.activities;

import java.util.List;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.correportuvida.R;
import com.correportuvida.model.Plan;
import com.correportuvida.model.Trainer;
import com.correportuvida.model.training.Training;
import com.correportuvida.util.Util;

public class TrainingListActivity extends Activity {

	private Plan plan;
	
	public static String TRAINING_NAME = "TrainingListActivity.planName";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trainings_list);
		// Show the Up button in the action bar.
		setupActionBar();
		
		String planName = (String) getIntent().getSerializableExtra(PlansListActivity.PLAN_NAME);
		
		plan = Trainer.getInstance().getPlan(planName);
		
		List<Training> trainings = plan.getTrainings();
		
		List<String> trainingNames = Util.collectAsString(trainings, "name");
		
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, trainingNames);
        
        ListView listView = (ListView) findViewById(R.id.rest_list_view);
        listView.setAdapter(adapter);
        
        // Create a message handling object as an anonymous class.
        OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	//To Plan Details Activity  
            	goToDetallePlanActivity(view);
            }
        };

	        listView.setOnItemClickListener(mMessageClickedHandler); 
	}

	private List<String> getTrainingNames(List<Training> trainings) {
		List<String> trainingNames = Util.collectAsString(trainings, "name");
		
		String[] trainingNamesArray =  trainingNames.toArray(new String[trainingNames.size()]);
		return trainingNames;
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.training, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//TODO: refactor, codigo duplicado
	 public void goToDetallePlanActivity(View view) {

		Intent intent = new Intent(this, TrainingDetailActivity.class);
		String trainingName = ((TextView) view).getText().toString();
		//Training selectedTraining = plan.getTraining(trainingName);
		intent.putExtra(TRAINING_NAME, trainingName);
		intent.putExtra(PlansListActivity.PLAN_NAME, plan.getName());
    	startActivity(intent);
	 }
	    

}
