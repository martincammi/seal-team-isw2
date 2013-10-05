package com.correportuvida.model.timekeeper;

import com.correportuvida.model.interfaces.*;

public class TimeKeeperPositionVelocityNotice implements Reportable {
	/*
	 * Adapter
	 */
	private final NotifyPositionVelocityChange _notified;
	
	public TimeKeeperPositionVelocityNotice(NotifyPositionVelocityChange avisableCambioPosicionVelocidad)
	{
		_notified = avisableCambioPosicionVelocidad;
	}
	
	@Override
	public void report() {
		_notified.notifyPositionVelocityChanged();	
	}	
}
