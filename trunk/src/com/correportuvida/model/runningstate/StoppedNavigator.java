package com.correportuvida.model.runningstate;

import android.location.Location;

import com.correportuvida.model.Navigator;


public class StoppedNavigator extends NavigatorState {

	public StoppedNavigator(){}

	@Override
	public void updateContext() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Location getCurrentLocation() {
		return null;
	}
}
