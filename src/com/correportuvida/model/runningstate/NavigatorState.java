package com.correportuvida.model.runningstate;

import android.location.Location;

import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.Velocity;


public abstract class NavigatorState {
	
	public abstract Location getCurrentLocation();
	
	public abstract void updateCurrentLocation();
	
	public abstract Velocity getCurrentSpeed();
	
	public abstract Distance getDistanceTraveled();
	
	

}
