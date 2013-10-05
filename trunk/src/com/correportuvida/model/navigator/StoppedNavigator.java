package com.correportuvida.model.navigator;

import android.location.Location;

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
		// TODO ON NEXT SPRINT
		
	}

	@Override
	public Velocity getCurrentVelocity() {
		// TODO ON NEXT SPRINT
		return null;
	}

	@Override
	public Distance getDistanceTraveled() {
		// TODO ON NEXT SPRINT
		return null;
	}

	@Override
	public void stopUpdating() {
		// TODO ON NEXT SPRINT
		
	}
}
