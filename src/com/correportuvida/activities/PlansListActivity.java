package com.correportuvida.activities;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.correportuvida.R;
import com.correportuvida.adapters.PlanVisualAdapter;
import com.correportuvida.model.Plan;
import com.correportuvida.model.SportsDoctor;
import com.correportuvida.model.Trainer;
import com.correportuvida.model.runner.RunnerAvailability;
import com.correportuvida.model.runner.RunnerBuilder;
import com.correportuvida.model.runner.RunnerObjective;
import com.correportuvida.model.runner.RunnerProfile;
import com.correportuvida.model.runner.RunnerState;

public class PlansListActivity extends ActionBarActivity {

	public static final String EXTRA_MESSAGE = "com.correportuvida.activities.PlansListActivity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_list);
        
        Trainer trainer = new Trainer(new SportsDoctor());
        RunnerProfile profile = RunnerBuilder.buildDefaultProfile();
        RunnerObjective objective = RunnerBuilder.buildDefaultObjective();
        RunnerAvailability availability = RunnerBuilder.buildDefaultAvailability();
        RunnerState state = RunnerBuilder.buildDefaultState();
        
        List<PlanVisualAdapter> plans = new ArrayList<PlanVisualAdapter>();
        plans.add(new PlanVisualAdapter(trainer.createPlan("Plan1", profile, objective, availability, state)));
        plans.add(new PlanVisualAdapter(trainer.createPlan("Plan2", profile, objective, availability, state)));
        plans.add(new PlanVisualAdapter(trainer.createPlan("Plan3", profile, objective, availability, state)));
        
        String[] planNames = getPlanNames(plans);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planNames);
        
        ListView listView = (ListView) findViewById(R.id.rest_list_view);
        listView.setAdapter(adapter);
        
        // Create a message handling object as an anonymous class.
        OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	goToTrainingActivity(view);  
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler); 

    }

	private String[] getPlanNames(List<PlanVisualAdapter> plans) {
		String[] array = new String[plans.size()];
        for(int i=0;i<plans.size();i++)
        	array[i] = plans.get(i).toString();
		return array;
	}
    
	//TODO: refactor, codigo duplicado (casi)
    public void goToTrainingActivity(View view) {
     
    	Intent intent = new Intent(this, TrainingListActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, view.getId());
    	startActivity(intent);
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	 MenuInflater inflater = getMenuInflater();
    	 inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
