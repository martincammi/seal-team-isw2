package com.correportuvida.model.runningstate;

import java.util.ArrayList;

import android.location.Location;

import com.correportuvida.model.Navigator;
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
}
