package com.correportuvida.controller;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.correportuvida.R;
import com.correportuvida.model.Trainer;
import com.correportuvida.model.base.Velocity;

public class Controller {
	
	private final Activity _activity;
	
	public Controller(Activity activity) {
		_activity = activity;
	}
	
	public static void OpenActivity(Activity sender, Class<?> classToOpen)
	{
		Intent intent = new Intent(sender, classToOpen);
    	sender.startActivity(intent);
	}

	public void notifyPositionVelocityChanged(Trainer trainer) {
		Velocity velocity = trainer.getCurrentVelocity();
		
		TextView valorDistancia = (TextView) _activity.findViewById(R.id.valueDistanceTraveled);
		
		valorDistancia.setText(new DecimalFormat("##.##").format(distance/1000) + " Km");
	}

	public void notifyPhaseChanged(Trainer trainer) {
		// TODO Auto-generated method stub
		
	}

}
