package com.correportuvida.model.timekeeper;

import java.util.Timer;
import java.util.TimerTask;

import com.correportuvida.model.interfaces.*;
import com.correportuvida.model.base.*;

public class TimeKeeper {
	private final Reportable _reportable;
	private final Timer _timer;
	private final TimeKeeperTask _timeKeeperTask;
	private final int NO_START_DELAY = 0;
	private final int MS = 1000;
		
	public TimeKeeper(Reportable notificable, TimeLapse lapso)
	{
		_reportable = notificable;
		_timer = new Timer();
		_timeKeeperTask =new TimeKeeperTask();
		_timer.schedule(_timeKeeperTask, NO_START_DELAY , lapso.getSecondsQuantity() * MS);
	}
	
	public void modifyTimeLapse(TimeLapse lapse)
	{
		_timer.schedule(_timeKeeperTask, lapse.getSecondsQuantity() * MS);
	}

	//TODO: Esta herencia no se si es correcto
	//pero no tengo forma sino mas que meter una funcion anonima ahi en el medio 
	//y te diria que me gusta menos aun.
	class TimeKeeperTask extends TimerTask
	{
		@Override
		public void run() {
			_reportable.report();
		}
	}
}
