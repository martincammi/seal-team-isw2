package com.correportuvida.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.correportuvida.activities.TrainingListActivity;

import android.app.Activity;
import android.content.Intent;

public abstract class Controller {
	
	private Activity _activity;
	
	public Controller (Activity activity) {
		_activity = activity;
	}
	
	public Activity getActivity(){
		return _activity;
	}
	
	public abstract void updateView();
	public abstract void buttonBackPressed();

	public void goToActivity(Class activityClass){
		goToActivity(activityClass, new HashMap<String, Serializable>());
	}
	
	public void goToActivity(Class activityClass, String key, Serializable object){
		
		Map<String, Serializable> parameters = new HashMap<String, Serializable>();
		parameters.put(key, object);
				
		goToActivity(activityClass, parameters);
	}
	
	public void goToActivity(Class activityClass, Map<String, Serializable> parameters){
		Intent intent = new Intent(getActivity(), activityClass);
		
		for (String key : parameters.keySet()) {
			intent.putExtra(key, parameters.get(key));
		}
		
    	getActivity().startActivity(intent);
	}
}
