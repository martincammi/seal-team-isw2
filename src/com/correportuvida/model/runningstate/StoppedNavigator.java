package com.correportuvida.model.runningstate;

import android.location.Location;

import com.correportuvida.model.Navigator;
import com.correportuvida.model.Phase;
import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.Velocity;


public class StoppedNavigator extends NavigatorState {

	public StoppedNavigator(){}

	@Override
	public Location getCurrentLocation() {
		return null;
	}

	@Override
	public void updateCurrentLocation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Velocity getCurrentSpeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Distance getDistanceTraveled() {
		// TODO Auto-generated method stub
		return null;
	}
}
