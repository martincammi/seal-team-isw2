package com.correportuvida.model.timekeeper;

import com.correportuvida.model.interfaces.*;

public class TimeKeeperPhaseChangeNotice implements Reportable{
	/*
	 * Adapter
	 */
	private final NotifyPhaseChange _notified;
	
	public TimeKeeperPhaseChangeNotice(NotifyPhaseChange avisableCambioFase)
	{
		_notified = avisableCambioFase;
	}
	
	@Override
	public void report() {
		_notified.notifyPhaseChanged();
	}

}
