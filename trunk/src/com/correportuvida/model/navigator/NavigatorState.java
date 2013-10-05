package com.correportuvida.model.navigator;

import android.location.Location;

import com.correportuvida.model.Phase;
import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.Velocity;


public abstract class NavigatorState {
	
	public abstract Location getCurrentLocation();
	
	public abstract void updateCurrentLocation();
	
	public abstract Velocity getCurrentVelocity();
	
	public abstract Distance getDistanceTraveled();

	public abstract void stopUpdating();
}
