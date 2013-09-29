package com.correportuvida.model;

import com.correportuvida.model.interfaces.*;

public class TimeKeeperPositionVelocityNotice implements Reportable{
	/*
	 * Adapter
	 */
	private final NotifyPhaseChange _notified;
	
	public TimeKeeperPositionVelocityNotice(NotifyPhaseChange avisableCambioFase)
	{
		_notified = avisableCambioFase;
	}
	
	@Override
	public void report() {
		_notified.notifyPhaseChanged();	
	}
	
}