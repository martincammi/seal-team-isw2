package com.correportuvida.activities;

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

public class PlansListActivity extends ActionBarActivity {

	public static final String EXTRA_MESSAGE = "com.correportuvida.activities.PlansListActivity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_list);
        
        String[] array = {"Plan1", "Plan2", "Plan3"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        
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
    
    public void goToTrainingActivity(View view) {
     
    	Intent intent = new Intent(this, TrainingActivity.class);
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
