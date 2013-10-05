package com.correportuvida.model.navigator;

import java.util.ArrayList;

import android.location.Location;

import com.correportuvida.model.Navigator;
import com.correportuvida.model.Phase;
import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.Velocity;
import com.correportuvida.model.timekeeper.TimeKeeperPositionVelocityNotice;
import com.google.android.gms.maps.model.LatLng;

public class ActiveNavigator extends NavigatorState {
	
	protected final Navigator _navigator;
	
	public ActiveNavigator(Navigator navigator)
	{
		_navigator = navigator;
	}

	@Override
	public Location getCurrentLocation() {
		return _navigator.getPosition();
	}
	
	public void updateCurrentLocation(){
		_navigator.updatePosition();
		
	}

	@Override
	public Velocity getCurrentVelocity() {
		return _navigator.getVelocity();
	}

	@Override
	public Distance getDistanceTraveled() {
		return _navigator.getDistanceTraveled();
	}

	@Override
	public void stopUpdating() {
		_navigator.stopNavigator();
	}
}
